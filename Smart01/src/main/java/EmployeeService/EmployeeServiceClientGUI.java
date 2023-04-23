package EmployeeService;



import EmployeeService.EmployeeServiceGrpc;
import EmployeeService.EmployeeServiceProto.*;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.slf4j.LoggerFactory;

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
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmployeeServiceClientGUI {
    private ManagedChannel channel;
    private EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    private EmployeeServiceGrpc.EmployeeServiceStub asyncStub;
    private String host;
    private int port;

    public static void main(String[] args) throws IOException {

        EmployeeServiceClientGUI clientGUI = new EmployeeServiceClientGUI();
        clientGUI.discoverService();
        SwingUtilities.invokeLater(clientGUI::createAndShowGUI);
    }

    public void discoverService() throws IOException {
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        jmdns.addServiceListener("_employee._tcp.local.", new ServiceListener() {
            @Override
            public void serviceAdded(ServiceEvent event) {
                ServiceInfo serviceInfo = jmdns.getServiceInfo(event.getType(), event.getName());
                if (serviceInfo != null) {
                    host = serviceInfo.getHostAddresses()[0];
                    port = serviceInfo.getPort();
                }
            }

            @Override
            public void serviceRemoved(ServiceEvent event) {
            }

            @Override
            public void serviceResolved(ServiceEvent event) {
                System.out.println("Service resolved: " + event.getInfo());
                System.out.println("Service host: " + event.getInfo().getHostAddress());
                System.out.println("Service port: " + event.getInfo().getPort());
                System.out.println("JMDNS Service INFO: " + event.getInfo());
            }
        });
    }

    public void createAndShowGUI() {
        Font defaultFont = new Font(Font.SANS_SERIF, Font.PLAIN, 26); // 修改字体为 Sans-serif 且大小为 16
        UIManager.put("Button.font", defaultFont);
        UIManager.put("CheckBox.font", defaultFont);
        UIManager.put("Label.font", defaultFont);
        UIManager.put("TextField.font", defaultFont);
        UIManager.put("TextArea.font", defaultFont);
        JFrame frame = new JFrame("Employee Service Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        JTextField idField = new JTextField(30);
        JTextField nameField = new JTextField(30);
        JTextField ageField = new JTextField(30);
        JTextField departmentField = new JTextField(30);
        Font font = new Font("Verdana", Font.PLAIN, 25);

        idField.setFont(font);
        nameField.setFont(font);
        ageField.setFont(font);
        departmentField.setFont(font);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String department = departmentField.getText();

                connectToServer(host, port);
                AddEmployeeResponse response = addEmployee(id, name, age, department);
                disconnectFromServer();

                JOptionPane.showMessageDialog(frame, "Employee added with ID: " + response.getId());
            }
        });



        JButton updateButton = new JButton("Update Employee");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String department = departmentField.getText();

                connectToServer(host, port);
                boolean success = updateEmployee(id, name, age, department);
                disconnectFromServer();

                if (success) {
                    JOptionPane.showMessageDialog(frame, "Employee updated");
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee not found");
                }
            }
        });
        JButton getButton = new JButton("Get Employee BY ID");
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                connectToServer(host, port);
                GetEmployeeResponse response = getEmployee(id);
                disconnectFromServer();

                if (response != null) {
                    nameField.setText(response.getName());
                    ageField.setText(String.valueOf(response.getAge()));
                    departmentField.setText(response.getDepartment());
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee id = "+id+" is not found");
                }
            }

        });

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Department:"));
        panel.add(departmentField);
        panel.add(addButton);
        panel.add(getButton);
        panel.add(updateButton);

        frame.setVisible(true);

    }

    private void connectToServer(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
        asyncStub = EmployeeServiceGrpc.newStub(channel);
    }

    private void disconnectFromServer() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private AddEmployeeResponse addEmployee(int id, String name, int age, String department) {
        AddEmployeeRequest request = AddEmployeeRequest.newBuilder()
                .setId(id)
                .setName(name)
                .setAge(age)
                .setDepartment(department)
                .build();
        return blockingStub.addEmployee(request);
    }

    private GetEmployeeResponse getEmployee(int id) {
        GetEmployeeRequest request = GetEmployeeRequest.newBuilder()
                .setId(id)
                .build();
        try {
            return blockingStub.getEmployee(request);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return null;
        }
    }


    private boolean updateEmployee(int id, String name, int age, String department) {
        Employee employee = Employee.newBuilder()
                .setId(id)
                .setName(name)
                .setAge(age)
                .setDepartment(department)
                .build();
        UpdateEmployeeRequest request = UpdateEmployeeRequest.newBuilder()
                .setId(id)
                .setEmployee(employee)
                .build();

        final AtomicBoolean success = new AtomicBoolean(false);
        final CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<UpdateEmployeeResponse> responseObserver = new StreamObserver<UpdateEmployeeResponse>() {
            @Override
            public void onNext(UpdateEmployeeResponse response) {
                success.set(response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error updating employee: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        };

        StreamObserver<UpdateEmployeeRequest> requestObserver = asyncStub.updateEmployee(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();

        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return success.get();
    }
}