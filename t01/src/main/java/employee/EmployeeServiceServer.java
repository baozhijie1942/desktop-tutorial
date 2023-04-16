package employee;

import employee.EmployeeProto.*;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class EmployeeServiceServer {
    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        final EmployeeServiceServer server = new EmployeeServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        int port = 8080;
        server = ServerBuilder.forPort(port)
                .addService((BindableService) new EmployeeServiceImp())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            EmployeeServiceServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static class EmployeeServiceImp extends EmployeeServiceGrpc.EmployeeServiceImplBase {
        @Override
        public void getEmployeeSystem(GetEmployeeSystemRequest request, StreamObserver<GetEmployeeSystemResponse> responseObserver) {
            GetEmployeeSystemResponse response = GetEmployeeSystemResponse.newBuilder()
                    .setEname("peter")
                    .setEmail("111@gmail.com")
                    .setEphone("452(87)0001")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}