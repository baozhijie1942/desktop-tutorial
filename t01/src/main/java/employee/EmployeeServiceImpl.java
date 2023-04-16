package employee;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    @Override
    public void getEmployeeSystem(EmployeeProto.GetEmployeeSystemRequest request, StreamObserver<EmployeeProto.GetEmployeeSystemResponse> responseObserver) {
        try {
            // TODO: 根据 request 中的 eid 参数获取员工信息，并封装成 response 返回
            EmployeeProto.GetEmployeeSystemResponse response = EmployeeProto.GetEmployeeSystemResponse.newBuilder()
                    .setEname("Peter")
                    .setEmail("111@gmail.com")
                    .setEphone("452(87)0001")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // 出现异常时，返回错误状态码和错误信息
            responseObserver.onError(Status.INTERNAL.withDescription("Internal error").withCause(e).asException());
        }
    }
}