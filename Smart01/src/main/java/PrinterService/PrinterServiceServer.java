package PrinterService;





import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.Metadata;

import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class PrinterServiceServer {
    public static final int PORT = 50051;
    public static final String SERVICE_TYPE = "_grpc._tcp.local.";
    public static final String SERVICE_NAME = "PrinterService";
    private static final Metadata.Key<String> AUTH_TOKEN_METADATA_KEY = Metadata.Key.of("auth_token", Metadata.ASCII_STRING_MARSHALLER);

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        Server server = ServerBuilder.forPort(PORT)
                .addService(new PrinterServiceImpl())
                .intercept(new AuthInterceptor(AUTH_TOKEN_METADATA_KEY))
                .build()
                .start();

        System.out.println("Server started on port " + PORT);

        // Register the service using jmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create(SERVICE_TYPE, SERVICE_NAME, PORT, "");
        jmdns.registerService(serviceInfo);
        System.out.println("Service registered with jmDNS");

        server.awaitTermination();
    }

    static class PrinterServiceImpl extends PrinterServiceGrpc.PrinterServiceImplBase {
        @Override
        public void printDocument(PrintDocumentRequest request, StreamObserver<PrintDocumentResponse> responseObserver) {
            try {
                // Implement print document logic here
                PrintDocumentResponse response = PrintDocumentResponse.newBuilder()
                        .setSuccess(true)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(new StatusRuntimeException(Status.INTERNAL.withDescription("Internal error: " + e.getMessage())));
            }
        }

        @Override
        public void listPrintJobs(ListPrintJobsRequest request, StreamObserver<ListPrintJobsResponse> responseObserver) {
            try {
                // Implement list print jobs logic here
                ListPrintJobsResponse response = ListPrintJobsResponse.newBuilder()
                        .setDocumentUrl("D://A.pdf")
                        .setPages(10)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(new StatusRuntimeException(Status.INTERNAL.withDescription("Internal error: " + e.getMessage())));
            }
        }

        @Override
        public void cancelPrintJob(CancelPrintJobRequest request, StreamObserver<CancelPrintJobResponse> responseObserver) {
            try {
                // Implement cancel print job logic here
                CancelPrintJobResponse response = CancelPrintJobResponse.newBuilder()
                        .setSuccess(true)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(new StatusRuntimeException(Status.INTERNAL.withDescription("Internal error: " + e.getMessage())));
            }
        }
    }

    static class AuthInterceptor implements io.grpc.ServerInterceptor {
        private final Metadata.Key<String> authTokenMetadataKey;
        public AuthInterceptor(Metadata.Key<String> authTokenMetadataKey) {
            this.authTokenMetadataKey = authTokenMetadataKey;
        }

        @Override
        public <ReqT, RespT> io.grpc.ServerCall.Listener<ReqT> interceptCall(io.grpc.ServerCall<ReqT, RespT> call, Metadata headers, io.grpc.ServerCallHandler<ReqT, RespT> next) {
            String authToken = headers.get(authTokenMetadataKey);

            // Check the authentication token
            if (!isValidAuthToken(authToken)) {
                call.close(Status.UNAUTHENTICATED.withDescription("Invalid auth token"), new Metadata());
                return new io.grpc.ServerCall.Listener<ReqT>() {};
            }

            // If the token is valid, continue with the call
            return next.startCall(call, headers);
        }

        private boolean isValidAuthToken(String authToken) {
            // Replace with your own authentication logic
            return "your_valid_auth_token".equals(authToken);
        }
    }
}
