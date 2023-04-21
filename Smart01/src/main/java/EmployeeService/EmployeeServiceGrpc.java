package EmployeeService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: EmployeeService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EmployeeServiceGrpc {

  private EmployeeServiceGrpc() {}

  public static final String SERVICE_NAME = "employee.EmployeeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GetEmployeeSystemRequest,
      GetEmployeeSystemResponse> getGetEmployeeSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEmployeeSystem",
      requestType = GetEmployeeSystemRequest.class,
      responseType = GetEmployeeSystemResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetEmployeeSystemRequest,
      GetEmployeeSystemResponse> getGetEmployeeSystemMethod() {
    io.grpc.MethodDescriptor<GetEmployeeSystemRequest, GetEmployeeSystemResponse> getGetEmployeeSystemMethod;
    if ((getGetEmployeeSystemMethod = EmployeeServiceGrpc.getGetEmployeeSystemMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getGetEmployeeSystemMethod = EmployeeServiceGrpc.getGetEmployeeSystemMethod) == null) {
          EmployeeServiceGrpc.getGetEmployeeSystemMethod = getGetEmployeeSystemMethod =
              io.grpc.MethodDescriptor.<GetEmployeeSystemRequest, GetEmployeeSystemResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEmployeeSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetEmployeeSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetEmployeeSystemResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("GetEmployeeSystem"))
              .build();
        }
      }
    }
    return getGetEmployeeSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ListEmployeesSystemRequest,
      ListEmployeesSystemResponse> getListEmployeesSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEmployeesSystem",
      requestType = ListEmployeesSystemRequest.class,
      responseType = ListEmployeesSystemResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ListEmployeesSystemRequest,
      ListEmployeesSystemResponse> getListEmployeesSystemMethod() {
    io.grpc.MethodDescriptor<ListEmployeesSystemRequest, ListEmployeesSystemResponse> getListEmployeesSystemMethod;
    if ((getListEmployeesSystemMethod = EmployeeServiceGrpc.getListEmployeesSystemMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getListEmployeesSystemMethod = EmployeeServiceGrpc.getListEmployeesSystemMethod) == null) {
          EmployeeServiceGrpc.getListEmployeesSystemMethod = getListEmployeesSystemMethod =
              io.grpc.MethodDescriptor.<ListEmployeesSystemRequest, ListEmployeesSystemResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEmployeesSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ListEmployeesSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ListEmployeesSystemResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("ListEmployeesSystem"))
              .build();
        }
      }
    }
    return getListEmployeesSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdatingEmployeeInformationRequest,
      UpdatingEmployeeInformationResponse> getUpdateEmployeeSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEmployeeSystem",
      requestType = UpdatingEmployeeInformationRequest.class,
      responseType = UpdatingEmployeeInformationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<UpdatingEmployeeInformationRequest,
      UpdatingEmployeeInformationResponse> getUpdateEmployeeSystemMethod() {
    io.grpc.MethodDescriptor<UpdatingEmployeeInformationRequest, UpdatingEmployeeInformationResponse> getUpdateEmployeeSystemMethod;
    if ((getUpdateEmployeeSystemMethod = EmployeeServiceGrpc.getUpdateEmployeeSystemMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getUpdateEmployeeSystemMethod = EmployeeServiceGrpc.getUpdateEmployeeSystemMethod) == null) {
          EmployeeServiceGrpc.getUpdateEmployeeSystemMethod = getUpdateEmployeeSystemMethod =
              io.grpc.MethodDescriptor.<UpdatingEmployeeInformationRequest, UpdatingEmployeeInformationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEmployeeSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdatingEmployeeInformationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdatingEmployeeInformationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("UpdateEmployeeSystem"))
              .build();
        }
      }
    }
    return getUpdateEmployeeSystemMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployeeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceStub>() {
        @Override
        public EmployeeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmployeeServiceStub(channel, callOptions);
        }
      };
    return EmployeeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployeeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceBlockingStub>() {
        @Override
        public EmployeeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmployeeServiceBlockingStub(channel, callOptions);
        }
      };
    return EmployeeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployeeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceFutureStub>() {
        @Override
        public EmployeeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmployeeServiceFutureStub(channel, callOptions);
        }
      };
    return EmployeeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EmployeeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEmployeeSystem(GetEmployeeSystemRequest request,
                                  io.grpc.stub.StreamObserver<GetEmployeeSystemResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEmployeeSystemMethod(), responseObserver);
    }

    /**
     */
    public void listEmployeesSystem(ListEmployeesSystemRequest request,
                                    io.grpc.stub.StreamObserver<ListEmployeesSystemResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEmployeesSystemMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<UpdatingEmployeeInformationRequest> updateEmployeeSystem(
        io.grpc.stub.StreamObserver<UpdatingEmployeeInformationResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUpdateEmployeeSystemMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEmployeeSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetEmployeeSystemRequest,
                GetEmployeeSystemResponse>(
                  this, METHODID_GET_EMPLOYEE_SYSTEM)))
          .addMethod(
            getListEmployeesSystemMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ListEmployeesSystemRequest,
                ListEmployeesSystemResponse>(
                  this, METHODID_LIST_EMPLOYEES_SYSTEM)))
          .addMethod(
            getUpdateEmployeeSystemMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                UpdatingEmployeeInformationRequest,
                UpdatingEmployeeInformationResponse>(
                  this, METHODID_UPDATE_EMPLOYEE_SYSTEM)))
          .build();
    }
  }

  /**
   */
  public static final class EmployeeServiceStub extends io.grpc.stub.AbstractAsyncStub<EmployeeServiceStub> {
    private EmployeeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EmployeeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmployeeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getEmployeeSystem(GetEmployeeSystemRequest request,
                                  io.grpc.stub.StreamObserver<GetEmployeeSystemResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEmployeeSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listEmployeesSystem(ListEmployeesSystemRequest request,
                                    io.grpc.stub.StreamObserver<ListEmployeesSystemResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListEmployeesSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<UpdatingEmployeeInformationRequest> updateEmployeeSystem(
        io.grpc.stub.StreamObserver<UpdatingEmployeeInformationResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getUpdateEmployeeSystemMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class EmployeeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EmployeeServiceBlockingStub> {
    private EmployeeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EmployeeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmployeeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GetEmployeeSystemResponse getEmployeeSystem(GetEmployeeSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEmployeeSystemMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ListEmployeesSystemResponse> listEmployeesSystem(
        ListEmployeesSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListEmployeesSystemMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployeeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EmployeeServiceFutureStub> {
    private EmployeeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EmployeeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmployeeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetEmployeeSystemResponse> getEmployeeSystem(
        GetEmployeeSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEmployeeSystemMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EMPLOYEE_SYSTEM = 0;
  private static final int METHODID_LIST_EMPLOYEES_SYSTEM = 1;
  private static final int METHODID_UPDATE_EMPLOYEE_SYSTEM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployeeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployeeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EMPLOYEE_SYSTEM:
          serviceImpl.getEmployeeSystem((GetEmployeeSystemRequest) request,
              (io.grpc.stub.StreamObserver<GetEmployeeSystemResponse>) responseObserver);
          break;
        case METHODID_LIST_EMPLOYEES_SYSTEM:
          serviceImpl.listEmployeesSystem((ListEmployeesSystemRequest) request,
              (io.grpc.stub.StreamObserver<ListEmployeesSystemResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_EMPLOYEE_SYSTEM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateEmployeeSystem(
              (io.grpc.stub.StreamObserver<UpdatingEmployeeInformationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmployeeServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return EmployeeServiceProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmployeeService");
    }
  }

  private static final class EmployeeServiceFileDescriptorSupplier
      extends EmployeeServiceBaseDescriptorSupplier {
    EmployeeServiceFileDescriptorSupplier() {}
  }

  private static final class EmployeeServiceMethodDescriptorSupplier
      extends EmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmployeeServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmployeeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployeeServiceFileDescriptorSupplier())
              .addMethod(getGetEmployeeSystemMethod())
              .addMethod(getListEmployeesSystemMethod())
              .addMethod(getUpdateEmployeeSystemMethod())
              .build();
        }
      }
    }
    return result;
  }
}
