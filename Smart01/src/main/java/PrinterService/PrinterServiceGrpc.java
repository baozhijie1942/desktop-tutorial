package PrinterService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: PrinterService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PrinterServiceGrpc {

  private PrinterServiceGrpc() {}

  public static final String SERVICE_NAME = "printer.PrinterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<PrintDocumentRequest,
      PrintDocumentResponse> getPrintDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrintDocument",
      requestType = PrintDocumentRequest.class,
      responseType = PrintDocumentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PrintDocumentRequest,
      PrintDocumentResponse> getPrintDocumentMethod() {
    io.grpc.MethodDescriptor<PrintDocumentRequest, PrintDocumentResponse> getPrintDocumentMethod;
    if ((getPrintDocumentMethod = PrinterServiceGrpc.getPrintDocumentMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getPrintDocumentMethod = PrinterServiceGrpc.getPrintDocumentMethod) == null) {
          PrinterServiceGrpc.getPrintDocumentMethod = getPrintDocumentMethod =
              io.grpc.MethodDescriptor.<PrintDocumentRequest, PrintDocumentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PrintDocument"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PrintDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PrintDocumentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("PrintDocument"))
              .build();
        }
      }
    }
    return getPrintDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ListPrintJobsRequest,
      ListPrintJobsResponse> getListPrintJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrintJobs",
      requestType = ListPrintJobsRequest.class,
      responseType = ListPrintJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ListPrintJobsRequest,
      ListPrintJobsResponse> getListPrintJobsMethod() {
    io.grpc.MethodDescriptor<ListPrintJobsRequest, ListPrintJobsResponse> getListPrintJobsMethod;
    if ((getListPrintJobsMethod = PrinterServiceGrpc.getListPrintJobsMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getListPrintJobsMethod = PrinterServiceGrpc.getListPrintJobsMethod) == null) {
          PrinterServiceGrpc.getListPrintJobsMethod = getListPrintJobsMethod =
              io.grpc.MethodDescriptor.<ListPrintJobsRequest, ListPrintJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPrintJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ListPrintJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ListPrintJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("ListPrintJobs"))
              .build();
        }
      }
    }
    return getListPrintJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CancelPrintJobRequest,
      CancelPrintJobResponse> getCancelPrintJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelPrintJob",
      requestType = CancelPrintJobRequest.class,
      responseType = CancelPrintJobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CancelPrintJobRequest,
      CancelPrintJobResponse> getCancelPrintJobMethod() {
    io.grpc.MethodDescriptor<CancelPrintJobRequest, CancelPrintJobResponse> getCancelPrintJobMethod;
    if ((getCancelPrintJobMethod = PrinterServiceGrpc.getCancelPrintJobMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getCancelPrintJobMethod = PrinterServiceGrpc.getCancelPrintJobMethod) == null) {
          PrinterServiceGrpc.getCancelPrintJobMethod = getCancelPrintJobMethod =
              io.grpc.MethodDescriptor.<CancelPrintJobRequest, CancelPrintJobResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelPrintJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CancelPrintJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CancelPrintJobResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("CancelPrintJob"))
              .build();
        }
      }
    }
    return getCancelPrintJobMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrinterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrinterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrinterServiceStub>() {
        @Override
        public PrinterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrinterServiceStub(channel, callOptions);
        }
      };
    return PrinterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrinterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrinterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrinterServiceBlockingStub>() {
        @Override
        public PrinterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrinterServiceBlockingStub(channel, callOptions);
        }
      };
    return PrinterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrinterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrinterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrinterServiceFutureStub>() {
        @Override
        public PrinterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrinterServiceFutureStub(channel, callOptions);
        }
      };
    return PrinterServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PrinterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void printDocument(PrintDocumentRequest request,
                              io.grpc.stub.StreamObserver<PrintDocumentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintDocumentMethod(), responseObserver);
    }

    /**
     */
    public void listPrintJobs(ListPrintJobsRequest request,
                              io.grpc.stub.StreamObserver<ListPrintJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPrintJobsMethod(), responseObserver);
    }

    /**
     */
    public void cancelPrintJob(CancelPrintJobRequest request,
                               io.grpc.stub.StreamObserver<CancelPrintJobResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelPrintJobMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPrintDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                PrintDocumentRequest,
                PrintDocumentResponse>(
                  this, METHODID_PRINT_DOCUMENT)))
          .addMethod(
            getListPrintJobsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ListPrintJobsRequest,
                ListPrintJobsResponse>(
                  this, METHODID_LIST_PRINT_JOBS)))
          .addMethod(
            getCancelPrintJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                CancelPrintJobRequest,
                CancelPrintJobResponse>(
                  this, METHODID_CANCEL_PRINT_JOB)))
          .build();
    }
  }

  /**
   */
  public static final class PrinterServiceStub extends io.grpc.stub.AbstractAsyncStub<PrinterServiceStub> {
    private PrinterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PrinterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrinterServiceStub(channel, callOptions);
    }

    /**
     */
    public void printDocument(PrintDocumentRequest request,
                              io.grpc.stub.StreamObserver<PrintDocumentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintDocumentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listPrintJobs(ListPrintJobsRequest request,
                              io.grpc.stub.StreamObserver<ListPrintJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListPrintJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelPrintJob(CancelPrintJobRequest request,
                               io.grpc.stub.StreamObserver<CancelPrintJobResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelPrintJobMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrinterServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrinterServiceBlockingStub> {
    private PrinterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PrinterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrinterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public PrintDocumentResponse printDocument(PrintDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintDocumentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ListPrintJobsResponse> listPrintJobs(
        ListPrintJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListPrintJobsMethod(), getCallOptions(), request);
    }

    /**
     */
    public CancelPrintJobResponse cancelPrintJob(CancelPrintJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelPrintJobMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrinterServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PrinterServiceFutureStub> {
    private PrinterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PrinterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrinterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PrintDocumentResponse> printDocument(
        PrintDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintDocumentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CancelPrintJobResponse> cancelPrintJob(
        CancelPrintJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelPrintJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRINT_DOCUMENT = 0;
  private static final int METHODID_LIST_PRINT_JOBS = 1;
  private static final int METHODID_CANCEL_PRINT_JOB = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrinterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrinterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRINT_DOCUMENT:
          serviceImpl.printDocument((PrintDocumentRequest) request,
              (io.grpc.stub.StreamObserver<PrintDocumentResponse>) responseObserver);
          break;
        case METHODID_LIST_PRINT_JOBS:
          serviceImpl.listPrintJobs((ListPrintJobsRequest) request,
              (io.grpc.stub.StreamObserver<ListPrintJobsResponse>) responseObserver);
          break;
        case METHODID_CANCEL_PRINT_JOB:
          serviceImpl.cancelPrintJob((CancelPrintJobRequest) request,
              (io.grpc.stub.StreamObserver<CancelPrintJobResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrinterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrinterServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return PrinterProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrinterService");
    }
  }

  private static final class PrinterServiceFileDescriptorSupplier
      extends PrinterServiceBaseDescriptorSupplier {
    PrinterServiceFileDescriptorSupplier() {}
  }

  private static final class PrinterServiceMethodDescriptorSupplier
      extends PrinterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrinterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PrinterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrinterServiceFileDescriptorSupplier())
              .addMethod(getPrintDocumentMethod())
              .addMethod(getListPrintJobsMethod())
              .addMethod(getCancelPrintJobMethod())
              .build();
        }
      }
    }
    return result;
  }
}
