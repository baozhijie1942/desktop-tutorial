package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class EmployeeServiceGUI extends JFrame {
    private JPanel panel;
    private JTextField textFieldID;
    private JTextArea textAreaResponse;

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    private EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;

    public EmployeeServiceGUI() {
        super("Employee Service GUI");

        // 设置窗口属性
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建主面板
        panel = new JPanel(new GridBagLayout());
        add(panel);

        // 添加 ID 输入框
        JLabel labelID = new JLabel("Employee ID:");
        textFieldID = new JTextField(20);
        GridBagConstraints constraintsID = new GridBagConstraints();
        constraintsID.gridx = 0;
        constraintsID.gridy = 0;
        constraintsID.anchor = GridBagConstraints.LINE_START;
        panel.add(labelID, constraintsID);
        panel.add(textFieldID, constraintsID);

        // 添加按钮
        JButton buttonGet = new JButton("Get Employee");
        GridBagConstraints constraintsButton = new GridBagConstraints();
        constraintsButton.gridx = 0;
        constraintsButton.gridy = 1;
        constraintsButton.anchor = GridBagConstraints.LINE_START;
        panel.add(buttonGet, constraintsButton);

        // 添加响应区域
        JLabel labelResponse = new JLabel("Response:");
        textAreaResponse = new JTextArea(10, 30);
        textAreaResponse.setEditable(false);
        JScrollPane scrollPaneResponse = new JScrollPane(textAreaResponse);
        GridBagConstraints constraintsResponse = new GridBagConstraints();
        constraintsResponse.gridx = 0;
        constraintsResponse.gridy = 2;
        constraintsResponse.anchor = GridBagConstraints.LINE_START;
        panel.add(labelResponse, constraintsResponse);
        panel.add(scrollPaneResponse, constraintsResponse);

        // 添加按钮事件监听器
        buttonGet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取输入框的 ID
                String id = textFieldID.getText().trim();

                // 调用 gRPC 服务获取员工信息
                try {
                    EmployeeProto.GetEmployeeSystemResponse response = getEmployee(id);
                    textAreaResponse.setText("Name: " + response.getEname()
                            + "\nEmail: " + response.getEmail()
                            + "\nPhone: " + response.getEphone());
                } catch (StatusRuntimeException ex) {
                    textAreaResponse.setText("Error: " + ex.getMessage());
                }
            }
        });

        // 创建 gRPC 通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext()
                .build();

        // 创建 gRPC 客户端存根
        blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
    }

    // 获取员工信息
    private EmployeeProto.GetEmployeeSystemResponse getEmployee(String id) {
        EmployeeProto.GetEmployeeSystemRequest request = EmployeeProto.GetEmployeeSystemRequest.newBuilder().setEid(id).build();
        EmployeeProto.GetEmployeeSystemResponse response = blockingStub.getEmployeeSystem(request);

        return response;
    }

    public static void main(String[] args) {
        // 在事件分派线程
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmployeeServiceGUI gui = new EmployeeServiceGUI();
                gui.setVisible(true);
            }
        });
    }

}