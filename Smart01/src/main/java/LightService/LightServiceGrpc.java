package LightService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: LightService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "lights.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ControlLightRequest,
      ControlLightResponse> getControlLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLight",
      requestType = ControlLightRequest.class,
      responseType = ControlLightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ControlLightRequest,
      ControlLightResponse> getControlLightMethod() {
    io.grpc.MethodDescriptor<ControlLightRequest, ControlLightResponse> getControlLightMethod;
    if ((getControlLightMethod = LightServiceGrpc.getControlLightMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getControlLightMethod = LightServiceGrpc.getControlLightMethod) == null) {
          LightServiceGrpc.getControlLightMethod = getControlLightMethod =
              io.grpc.MethodDescriptor.<ControlLightRequest, ControlLightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ControlLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ControlLightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("ControlLight"))
              .build();
        }
      }
    }
    return getControlLightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetRoomLightsRequest,
      GetRoomLightsResponse> getGetRoomLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRoomLights",
      requestType = GetRoomLightsRequest.class,
      responseType = GetRoomLightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetRoomLightsRequest,
      GetRoomLightsResponse> getGetRoomLightsMethod() {
    io.grpc.MethodDescriptor<GetRoomLightsRequest, GetRoomLightsResponse> getGetRoomLightsMethod;
    if ((getGetRoomLightsMethod = LightServiceGrpc.getGetRoomLightsMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getGetRoomLightsMethod = LightServiceGrpc.getGetRoomLightsMethod) == null) {
          LightServiceGrpc.getGetRoomLightsMethod = getGetRoomLightsMethod =
              io.grpc.MethodDescriptor.<GetRoomLightsRequest, GetRoomLightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRoomLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetRoomLightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetRoomLightsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("GetRoomLights"))
              .build();
        }
      }
    }
    return getGetRoomLightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ControlMultipleLightsRequest,
      ControlMultipleLightsResponse> getControlMultipleLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlMultipleLights",
      requestType = ControlMultipleLightsRequest.class,
      responseType = ControlMultipleLightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ControlMultipleLightsRequest,
      ControlMultipleLightsResponse> getControlMultipleLightsMethod() {
    io.grpc.MethodDescriptor<ControlMultipleLightsRequest, ControlMultipleLightsResponse> getControlMultipleLightsMethod;
    if ((getControlMultipleLightsMethod = LightServiceGrpc.getControlMultipleLightsMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getControlMultipleLightsMethod = LightServiceGrpc.getControlMultipleLightsMethod) == null) {
          LightServiceGrpc.getControlMultipleLightsMethod = getControlMultipleLightsMethod =
              io.grpc.MethodDescriptor.<ControlMultipleLightsRequest, ControlMultipleLightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlMultipleLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ControlMultipleLightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ControlMultipleLightsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("ControlMultipleLights"))
              .build();
        }
      }
    }
    return getControlMultipleLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceStub>() {
        @Override
        public LightServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceStub(channel, callOptions);
        }
      };
    return LightServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceBlockingStub>() {
        @Override
        public LightServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceBlockingStub(channel, callOptions);
        }
      };
    return LightServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceFutureStub>() {
        @Override
        public LightServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceFutureStub(channel, callOptions);
        }
      };
    return LightServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 子系统1: 控制一个灯的开/关状态 (一元RPC)
     * </pre>
     */
    public void controlLight(ControlLightRequest request,
                             io.grpc.stub.StreamObserver<ControlLightResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlLightMethod(), responseObserver);
    }

    /**
     * <pre>
     * 子系统2: 获取一个房间中所有灯的状态 (一元RPC)
     * </pre>
     */
    public void getRoomLights(GetRoomLightsRequest request,
                              io.grpc.stub.StreamObserver<GetRoomLightsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRoomLightsMethod(), responseObserver);
    }

    /**
     * <pre>
     * 子系统3: 控制多个灯的开/关状态 (客户端流RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ControlMultipleLightsRequest> controlMultipleLights(
        io.grpc.stub.StreamObserver<ControlMultipleLightsResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getControlMultipleLightsMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getControlLightMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ControlLightRequest,
                ControlLightResponse>(
                  this, METHODID_CONTROL_LIGHT)))
          .addMethod(
            getGetRoomLightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetRoomLightsRequest,
                GetRoomLightsResponse>(
                  this, METHODID_GET_ROOM_LIGHTS)))
          .addMethod(
            getControlMultipleLightsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                ControlMultipleLightsRequest,
                ControlMultipleLightsResponse>(
                  this, METHODID_CONTROL_MULTIPLE_LIGHTS)))
          .build();
    }
  }

  /**
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractAsyncStub<LightServiceStub> {
    private LightServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 子系统1: 控制一个灯的开/关状态 (一元RPC)
     * </pre>
     */
    public void controlLight(ControlLightRequest request,
                             io.grpc.stub.StreamObserver<ControlLightResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlLightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 子系统2: 获取一个房间中所有灯的状态 (一元RPC)
     * </pre>
     */
    public void getRoomLights(GetRoomLightsRequest request,
                              io.grpc.stub.StreamObserver<GetRoomLightsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRoomLightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 子系统3: 控制多个灯的开/关状态 (客户端流RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ControlMultipleLightsRequest> controlMultipleLights(
        io.grpc.stub.StreamObserver<ControlMultipleLightsResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getControlMultipleLightsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 子系统1: 控制一个灯的开/关状态 (一元RPC)
     * </pre>
     */
    public ControlLightResponse controlLight(ControlLightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlLightMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 子系统2: 获取一个房间中所有灯的状态 (一元RPC)
     * </pre>
     */
    public GetRoomLightsResponse getRoomLights(GetRoomLightsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRoomLightsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LightServiceFutureStub> {
    private LightServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 子系统1: 控制一个灯的开/关状态 (一元RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ControlLightResponse> controlLight(
        ControlLightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlLightMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 子系统2: 获取一个房间中所有灯的状态 (一元RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<GetRoomLightsResponse> getRoomLights(
        GetRoomLightsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRoomLightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_LIGHT = 0;
  private static final int METHODID_GET_ROOM_LIGHTS = 1;
  private static final int METHODID_CONTROL_MULTIPLE_LIGHTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_LIGHT:
          serviceImpl.controlLight((ControlLightRequest) request,
              (io.grpc.stub.StreamObserver<ControlLightResponse>) responseObserver);
          break;
        case METHODID_GET_ROOM_LIGHTS:
          serviceImpl.getRoomLights((GetRoomLightsRequest) request,
              (io.grpc.stub.StreamObserver<GetRoomLightsResponse>) responseObserver);
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
        case METHODID_CONTROL_MULTIPLE_LIGHTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlMultipleLights(
              (io.grpc.stub.StreamObserver<ControlMultipleLightsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LightProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getControlLightMethod())
              .addMethod(getGetRoomLightsMethod())
              .addMethod(getControlMultipleLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
