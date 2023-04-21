package LightService;






import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import LightService.ControlLightRequest;
import LightService.ControlLightResponse;
import LightService.GetRoomLightsRequest;
import LightService.GetRoomLightsResponse;
import LightService.Light;
import LightService.ControlMultipleLightsRequest;
import LightService.ControlMultipleLightsResponse;
import LightService.LightServiceGrpc;

public class LightServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;

        // 创建并启动 gRPC 服务器
        Server server = ServerBuilder.forPort(port).addService(new LightServiceImpl()).build().start();
        System.out.println("LightServer started, listening on port " + port);

        // 添加 jmDNS 服务发现
        JmDNS jmdns;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "LightServer", port, "");
            jmdns.registerService(serviceInfo);
            System.out.println("LightServer registered with jmDNS");
        } catch (UnknownHostException e) {
            System.err.println("Error registering LightServer with jmDNS: " + e.getMessage());
        }

        // 等待服务器关闭
        server.awaitTermination();
    }

    static class LightServiceImpl extends LightServiceGrpc.LightServiceImplBase {
        private ConcurrentHashMap<String, Light> lights = new ConcurrentHashMap<>();

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
    }}

