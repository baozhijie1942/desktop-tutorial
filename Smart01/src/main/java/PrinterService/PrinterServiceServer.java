package PrinterService;




import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.Metadata;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PrinterServiceServer {

    private Server server;
    private JmDNS jmdns;
    private Properties prop;
    private static final Metadata.Key<String> AUTH_TOKEN_METADATA_KEY = Metadata.Key.of("auth_token", Metadata.ASCII_STRING_MARSHALLER);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("logback.configurationFile", "logback.xml");
        PrinterServiceServer server = new PrinterServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        prop = getProperties();
        int port = Integer.parseInt(prop.getProperty("service_port"));

        server = ServerBuilder.forPort(port)
                .addService(new PrinterServiceImpl())
                .intercept(new AuthInterceptor(AUTH_TOKEN_METADATA_KEY))
                .build()
                .start();

        // Register the service using jmDNS
        jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create(prop.getProperty("service_type"), prop.getProperty("service_name"), port, "");
        jmdns.registerService(serviceInfo);

        System.out.println(prop.getProperty("service_name") + " Server and JmDNS started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("*** Shutting down gRPC server since JVM is shutting down");
            PrinterServiceServer.this.stop();
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

        try (InputStream input = new FileInputStream("src/main/resources/printer.properties")) {
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

    static class PrinterServiceImpl extends PrinterServiceGrpc.PrinterServiceImplBase {
        // Implement print document, list print jobs, and cancel print job methods here.
        static class PrintJobInfo {
            String documentUrl;
            int pages;

            PrintJobInfo(String documentUrl, int pages) {
                this.documentUrl = documentUrl;
                this.pages = pages;
            }
        }

        // 存储 PrintJobInfo 对象的列表
        private final List<PrintJobInfo> printJobs = Collections.synchronizedList(new ArrayList<>());

        // ...

        @Override
        public void printDocument(PrintDocumentRequest request, StreamObserver<PrintDocumentResponse> responseObserver) {
            try {
                // 添加文档URL到集合中
                PrintJobInfo newPrintJob = new PrintJobInfo(request.getDocumentUrl(), 10); // 设置一个固定的页面数量，您可以根据需要修改
                printJobs.add(newPrintJob);

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
                // 返回文档URL列表
                for (PrintJobInfo printJob : printJobs) {
                    ListPrintJobsResponse response = ListPrintJobsResponse.newBuilder()
                            .setDocumentUrl(printJob.documentUrl)
                            .setPages(printJob.pages)
                            .build();
                    responseObserver.onNext(response);
                }
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(new StatusRuntimeException(Status.INTERNAL.withDescription("Internal error: " + e.getMessage())));
            }
        }

        @Override
        public void cancelPrintJob(CancelPrintJobRequest request, StreamObserver<CancelPrintJobResponse> responseObserver) {
            try {
                boolean removed = false;
                Optional<PrintJobInfo> printJobToRemove = printJobs.stream()
                        .filter(printJob -> printJob.documentUrl.equals(request.getDocumentUrl()))
                        .findFirst();

                if (printJobToRemove.isPresent()) {
                    removed = printJobs.remove(printJobToRemove.get());
                }

                CancelPrintJobResponse response = CancelPrintJobResponse.newBuilder()
                        .setSuccess(removed)
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
                return new io.grpc.ServerCall.Listener<ReqT>() {
                };
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