package EmployeeService;

import io.grpc.stub.StreamObserver;

public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    @Override
    public void getEmployeeSystem(GetEmployeeSystemRequest request,
                                  StreamObserver<GetEmployeeSystemResponse> responseObserver) {
        // TODO: Implement your logic here
        // Retrieve employee information based on the request
        // and create a GetEmployeeSystemResponse object
        GetEmployeeSystemResponse response = GetEmployeeSystemResponse.newBuilder()
                .setEname("peter")
                .setEmail("111@gmail.com")
                .setEphone("452(87)0001")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listEmployeesSystem(ListEmployeesSystemRequest request,
                                    StreamObserver<ListEmployeesSystemResponse> responseObserver) {
        // TODO: Implement your logic here
        // Retrieve a list of all employees and
        // send each employee information as a separate response
        ListEmployeesSystemResponse response1 = ListEmployeesSystemResponse.newBuilder()
                .setEid("1")
                .setName("bob")
                .build();
        ListEmployeesSystemResponse response2 = ListEmployeesSystemResponse.newBuilder()
                .setEid("2")
                .setName("alice")
                .build();
        responseObserver.onNext(response1);
        responseObserver.onNext(response2);
        responseObserver.onCompleted();
    }
    @Override
    public StreamObserver<UpdatingEmployeeInformationRequest> updateEmployeeSystem(
            StreamObserver<UpdatingEmployeeInformationResponse> responseObserver) {
        return new StreamObserver<UpdatingEmployeeInformationRequest>() {
            // TODO: Implement your logic here
// Update employee information based on each request
// and send a response for each request
            @Override
            public void onNext(UpdatingEmployeeInformationRequest request) {
// update employee information based on the request
// and create an UpdatingEmployeeInformationResponse object
                UpdatingEmployeeInformationResponse response = UpdatingEmployeeInformationResponse.newBuilder()
                        .setSuccess(true)
                        .build();
                responseObserver.onNext(response);
            }
            @Override
            public void onError(Throwable t) {
                // Handle errors
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }}