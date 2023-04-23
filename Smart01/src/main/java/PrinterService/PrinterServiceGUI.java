package PrinterService;
import io.grpc.*;
import io.grpc.stub.MetadataUtils;
import PrinterService.PrinterServiceGrpc;
import PrinterService.*;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class PrinterServiceGUI {
    private ManagedChannel channel;
    private PrinterServiceGrpc.PrinterServiceBlockingStub blockingStub;
    private String host;
    private int port;
    private static final String AUTH_TOKEN = "your_valid_auth_token";

    public static void main(String[] args) throws IOException {
        PrinterServiceGUI clientGUI = new PrinterServiceGUI();
        clientGUI.discoverService();
        SwingUtilities.invokeLater(clientGUI::createAndShowGUI);
    }

    public void discoverService() throws IOException {
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        ServiceListener listener = new ServiceListener() {
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
                String newHost = event.getInfo().getInet4Addresses()[0].getHostAddress();
                int newPort = event.getInfo().getPort();
                System.out.println("Service resolved: " + event.getInfo());
                System.out.println("Service host: " + newHost);
                System.out.println("Service port: " + newPort);
                System.out.println("Service resolved: " + event.getInfo());
                host = event.getInfo().getInet4Addresses()[0].getHostAddress();
                port = event.getInfo().getPort();
            }
        };
        jmdns.addServiceListener("_printer._tcp.local.", listener);
    }

    public void createAndShowGUI() {
        Font defaultFont = new Font(Font.SANS_SERIF, Font.PLAIN, 26);
        UIManager.put("Button.font", defaultFont);
        UIManager.put("CheckBox.font", defaultFont);
        UIManager.put("Label.font", defaultFont);
        UIManager.put("TextField.font", defaultFont);
        UIManager.put("TextArea.font", defaultFont);
        JFrame frame = new JFrame("Printer Service Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        contentPane.add(controlPanel, BorderLayout.NORTH);

        JButton printDocumentButton = new JButton("Add Print Document URL");
        printDocumentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (host != null && port != 0) {
                    connectToServer();
                    printDocument();
                    disconnectFromServer();
                } else {
                    JOptionPane.showMessageDialog(null, "Service has not been discovered yet.");
                }
            }
        });
        controlPanel.add(printDocumentButton);

        JButton listPrintJobsButton = new JButton("List Print Jobs");
        listPrintJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (host != null && port != 0) {
                    connectToServer();
                    listPrintJobs();
                    disconnectFromServer();
                } else {
                    JOptionPane.showMessageDialog(null, "Service has not been discovered yet.");
                }
            }
        });
        controlPanel.add(listPrintJobsButton);

        JButton cancelPrintJobButton = new JButton("Cancel Print Job");
        cancelPrintJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (host != null && port != 0) {
                    connectToServer();
                    cancelPrintJob();
                    disconnectFromServer();
                } else {
                    JOptionPane.showMessageDialog(null, "Service has not been discovered yet.");
                }
            }
        });
        controlPanel.add(cancelPrintJobButton);
        frame.setVisible(true);
    }

    private void connectToServer() {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // Add authentication metadata to the gRPC request headers
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("auth_token", Metadata.ASCII_STRING_MARSHALLER), AUTH_TOKEN);
        blockingStub = MetadataUtils.attachHeaders(PrinterServiceGrpc.newBlockingStub(channel), metadata);
    }

    private void disconnectFromServer() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printDocument() {
        String documentUrl = JOptionPane.showInputDialog("Enter the document URL:");
        if (documentUrl != null && !documentUrl.trim().isEmpty()) {
            PrintDocumentRequest request = PrintDocumentRequest.newBuilder()
                    .setDocumentUrl(documentUrl)
                    .build();

            try {
                PrintDocumentResponse response = blockingStub.printDocument(request);
                if (response.getSuccess()) {
                    JOptionPane.showMessageDialog(null, "Add Print Document URL successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to print document.");
                }
            } catch (StatusRuntimeException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getStatus().getDescription());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Document URL cannot be empty.");
        }
    }

    private void listPrintJobs() {
        ListPrintJobsRequest request = ListPrintJobsRequest.newBuilder().build();

        try {
            StringBuilder printJobs = new StringBuilder();
            blockingStub.listPrintJobs(request).forEachRemaining(response -> {
                printJobs.append("URL: ").append(response.getDocumentUrl()).append("\n");
                // printJobs.append("URL: ").append(response.getDocumentUrl()).append(", Pages: ").append(response.getPages()).append("\n");
            });

            if (printJobs.length() > 0) {
                JOptionPane.showMessageDialog(null, "Print Jobs:\n" + printJobs.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No print jobs found.");
            }
        } catch (StatusRuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getStatus().getDescription());
        }
    }

    private void cancelPrintJob() {
        String documentUrl = JOptionPane.showInputDialog("Enter the document URL to cancel:");
        if (documentUrl != null && !documentUrl.trim().isEmpty()) {
            CancelPrintJobRequest request = CancelPrintJobRequest.newBuilder()
                    .setDocumentUrl(documentUrl)
                    .build();

            try {
                CancelPrintJobResponse response = blockingStub.cancelPrintJob(request);
                if (response.getSuccess()) {
                    JOptionPane.showMessageDialog(null, "Print job cancelled successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to cancel print job.");
                }
            } catch (StatusRuntimeException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getStatus().getDescription());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Document URL cannot be empty.");
        }
    }}
