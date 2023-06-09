package EmployeeService;




import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EmployeeServiceServer {

    private Server server;
    private JmDNS jmdns;
    private final ConcurrentMap<Integer, Employee> employeeMap = new ConcurrentHashMap<>();
    private Properties prop;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("logback.configurationFile", "logback.xml");
        EmployeeServiceServer server = new EmployeeServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        prop = getProperties();

        int port = Integer.valueOf(prop.getProperty("service_port"));

        server = ServerBuilder.forPort(port)
                .addService(new EmployeeServiceImpl())
                .build()
                .start();

        // Registration
        jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create(prop.getProperty("service_type"), prop.getProperty("service_name"), port, "");
        jmdns.registerService(serviceInfo);

        System.out.println(prop.getProperty("service_name") + " Server and JmDNS started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("*** Shutting down gRPC server since JVM is shutting down");
            EmployeeServiceServer.this.stop();
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

        try (InputStream input = new FileInputStream("src/main/resources/employee.properties")) {
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

    private class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {

        @Override
        public void addEmployee(AddEmployeeRequest request, StreamObserver<AddEmployeeResponse> responseObserver) {
            int id = request.getId();
            String name = request.getName();
            int age = request.getAge();
            String department = request.getDepartment();

            Employee employee = Employee.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setAge(age)
                    .setDepartment(department)
                    .build();

            employeeMap.put(id, employee);

            AddEmployeeResponse response = AddEmployeeResponse.newBuilder()
                    .setId(id)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getEmployee(GetEmployeeRequest request, StreamObserver<GetEmployeeResponse> responseObserver) {
            int id = request.getId();
            Employee employee = employeeMap.get(id);
            if (employee == null) {
                responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND.withDescription("Employee not found")));
            } else {
                GetEmployeeResponse response = GetEmployeeResponse.newBuilder()
                        .setId(employee.getId())
                        .setName(employee.getName())
                        .setAge(employee.getAge())
                        .setDepartment(employee.getDepartment())
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }

        @Override
        public StreamObserver<UpdateEmployeeRequest> updateEmployee(StreamObserver<UpdateEmployeeResponse> responseObserver) {
            return new StreamObserver<UpdateEmployeeRequest>() {
                @Override
                public void onNext(UpdateEmployeeRequest request) {
                    int id = request.getId();
                    Employee newEmployeeData = request.getEmployee();
                    Employee oldEmployee = employeeMap.get(id);
                    if (oldEmployee == null) {
                        responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND.withDescription("Employee not found")));
                        return;
                    }

                    employeeMap.put(id, newEmployeeData);

                    UpdateEmployeeResponse response = UpdateEmployeeResponse.newBuilder()
                            .setSuccess(true)
                            .build();

                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Error updating employee: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }

}