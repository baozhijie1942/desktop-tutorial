package EmployeeService;


import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class EmployeeServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Start the gRPC server
        Server server = ServerBuilder.forPort(9090)
                .addService(new EmployeeServiceImpl())
                .build()
                .start();

        // Register the service with jmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "EmployeeService", 9090,
                "EmployeeService gRPC Service");
        jmdns.registerService(serviceInfo);

        // Wait for the server to shut down
        server.awaitTermination();
    }
}