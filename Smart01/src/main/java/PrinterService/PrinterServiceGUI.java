package PrinterService;

import PrinterService.PrinterProto.*;
import PrinterService.PrinterServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrinterServiceGUI {
    private static final String AUTH_TOKEN = "your_valid_auth_token";

    private static PrinterServiceGrpc.PrinterServiceBlockingStub blockingStub;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("auth_token", Metadata.ASCII_STRING_MARSHALLER), AUTH_TOKEN);
        blockingStub = MetadataUtils.attachHeaders(PrinterServiceGrpc.newBlockingStub(channel), metadata);

        JFrame frame = new JFrame("Printer Service Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        contentPane.add(controlPanel, BorderLayout.NORTH);

        JButton printDocumentButton = new JButton("Print Document");
        printDocumentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDocument();
            }
        });
        controlPanel.add(printDocumentButton);

        JButton listPrintJobsButton = new JButton("List Print Jobs");
        listPrintJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPrintJobs();
            }
        });
        controlPanel.add(listPrintJobsButton);

        JButton cancelPrintJobButton = new JButton("Cancel Print Job");
        cancelPrintJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelPrintJob();
            }
        });
        controlPanel.add(cancelPrintJobButton);

        JTextArea outputArea = new JTextArea();
        contentPane.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void printDocument() {
        String documentUrl = JOptionPane.showInputDialog("Enter the document URL:");
        if (documentUrl != null && !documentUrl.trim().isEmpty()) {
            PrintDocumentRequest request = PrintDocumentRequest.newBuilder()
                    .setDocumentUrl(documentUrl)
                    .build();

            try {
                PrintDocumentResponse response = blockingStub.printDocument(request);
                if (response.getSuccess()) {
                    JOptionPane.showMessageDialog(null, "Document printed successfully.");
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

    private static void listPrintJobs() {
        ListPrintJobsRequest request = ListPrintJobsRequest.newBuilder().build();

        try {
            StringBuilder printJobs = new StringBuilder();
            blockingStub.listPrintJobs(request).forEachRemaining(response -> {
                printJobs.append("URL: ").append(response.getDocumentUrl()).append(", Pages: ").append(response.getPages()).append("\n");
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

    private static void cancelPrintJob() {
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
    }
}