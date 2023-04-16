package employee;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import employee.*;

import java.util.concurrent.TimeUnit;

public class EmployeeServiceClient {
    private final ManagedChannel channel;
    private final EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    private final EmployeeServiceGrpc.EmployeeServiceStub asyncStub;

    public EmployeeServiceClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
        asyncStub = EmployeeServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getEmployee(String employeeId) {
        System.out.println("Get employee for ID: " + employeeId);
        EmployeeProto.GetEmployeeSystemRequest request = EmployeeProto.GetEmployeeSystemRequest.newBuilder().setEid(employeeId).build();
        EmployeeProto.GetEmployeeSystemResponse response;
        try {
            response = blockingStub.getEmployeeSystem(request);
            System.out.println("Employee found: " + response.getEname());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        EmployeeServiceClient client = new EmployeeServiceClient("localhost", 8080);
        try {
            client.getEmployee("1234");
        } finally {
            client.shutdown();
        }
    }
}