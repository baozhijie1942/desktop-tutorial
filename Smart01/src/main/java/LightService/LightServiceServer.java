package LightService;




import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Properties;

public class LightServiceServer {

    private Server server;
    private JmDNS jmdns;
    private final ConcurrentHashMap<String, Light> lights = new ConcurrentHashMap<>();
    private Properties prop;

    public static void main(String[] args) throws IOException, InterruptedException {
        LightServiceServer server = new LightServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        prop = getProperties();

        int port = Integer.valueOf(prop.getProperty("service_port"));

        server = ServerBuilder.forPort(port)
                .addService(new LightServiceImpl())
                .build()
                .start();

        // Registration
        jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create(prop.getProperty("service_type"), prop.getProperty("service_name"), port, "");
        jmdns.registerService(serviceInfo);
        System.out.println(prop.getProperty("service_name") + " Server and JmDNS started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("*** Shutting down gRPC server since JVM is shutting down");
            LightServiceServer.this.stop();
            System.out.println("*** Server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
        if (jmdns != null) {
            jmdns.unregisterAllServices();
            try {
                jmdns.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private Properties getProperties() {
        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/light.properties")) {
            prop = new Properties();
            prop.load(input);
            System.out.println(prop.getProperty("service_name") + " Service properties...");
            System.out.println("\t Service type: " + prop.getProperty("service_type"));
            System.out.println("\t Service name: " + prop.getProperty("service_name"));
            System.out.println("\t Service description: " + prop.getProperty("service_description"));
            System.out.println("\t Service port: " + prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    private class LightServiceImpl extends LightServiceGrpc.LightServiceImplBase {

        @Override
        public void controlLight(ControlLightRequest request, StreamObserver<ControlLightResponse> responseObserver) {
            String lightId = request.getLightId();
            boolean turnOn = request.getTurnOn();

            if (lightId == null || lightId.isEmpty()) {
                responseObserver.onError(new StatusException(Status.INVALID_ARGUMENT.withDescription("Invalid light_id provided")));
                return;
            }

            Light updatedLight = lights.compute(lightId, (key, light) -> {
                if (light == null) {
                    light = Light.newBuilder().setId(lightId).setIsOn(turnOn).build();
                } else {
                    light = light.toBuilder().setIsOn(turnOn).build();
                }
                return light;
            });

            responseObserver.onNext(ControlLightResponse.newBuilder().setSuccess(updatedLight.getIsOn() == turnOn).build());
            responseObserver.onCompleted();
        }
        @Override
        public void getRoomLights(GetRoomLightsRequest request, StreamObserver<GetRoomLightsResponse> responseObserver) {
            String roomId = request.getRoomId();

            if (roomId == null || roomId.isEmpty()) {
                responseObserver.onError(new StatusException(Status.INVALID_ARGUMENT.withDescription("Invalid room_id provided")));
                return;
            }

            GetRoomLightsResponse.Builder responseBuilder = GetRoomLightsResponse.newBuilder();

            lights.forEach((id, light) -> {
                if (id.startsWith(roomId)) {
                    responseBuilder.addLights(light);
                }
            });

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<ControlMultipleLightsRequest> controlMultipleLights(
                StreamObserver<ControlMultipleLightsResponse> responseObserver) {
            return new StreamObserver<ControlMultipleLightsRequest>() {
                int successCount = 0;
                int totalCount = 0;

                @Override
                public void onNext(ControlMultipleLightsRequest request) {
                    String lightId = request.getLightId();
                    boolean turnOn = request.getTurnOn();

                    if (lightId == null || lightId.isEmpty()) {
                        System.err.println("Invalid light_id provided");
                    } else {
                        Light updatedLight = lights.compute(lightId, (key, light) -> {
                            if (light == null) {
                                light = Light.newBuilder().setId(lightId).setIsOn(turnOn).build();
                            } else {
                                light = light.toBuilder().setIsOn(turnOn).build();
                            }
                            return light;
                        });

                        totalCount++;
                        if (updatedLight.getIsOn() == turnOn) {
                            successCount++;
                        }
                    }
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in controlMultipleLights stream: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onNext(ControlMultipleLightsResponse.newBuilder().setSuccess(successCount == totalCount).build());
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
