package employee;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;

public class ExampleServiceDiscovery {
    private static final String SERVICE_TYPE = "_example._tcp.local.";

    public static void main(String[] args) throws IOException, InterruptedException {
        // 创建JmDNS实例
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // 注册服务
        ServiceInfo serviceInfo = ServiceInfo.create(SERVICE_TYPE, "example-service", 50051, "Example Service");
        jmdns.registerService(serviceInfo);

        // 监听服务
        jmdns.addServiceListener(SERVICE_TYPE, new ServiceListener() {
            @Override
            public void serviceAdded(ServiceEvent event) {
                System.out.println("Service added: " + event.getInfo());
            }

            @Override
            public void serviceRemoved(ServiceEvent event) {
                System.out.println("Service removed: " + event.getInfo());
            }

            @Override
            public void serviceResolved(ServiceEvent event) {
                System.out.println("Service resolved: " + event.getInfo());
            }
        });

        // 等待服务注册完成
        Thread.sleep(1000);

        // 查找服务
        ServiceInfo[] serviceInfos = jmdns.list(SERVICE_TYPE);
        if (serviceInfos.length > 0) {
            ServiceInfo serviceInfoFound = serviceInfos[0];
            System.out.println("Service found: " + serviceInfoFound);
        } else {
            System.out.println("No service found.");
        }

        // 关闭JmDNS实例
        jmdns.close();
    }
}