package LightService;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class LightServiceClientGUI {

    private static LightServiceGrpc.LightServiceBlockingStub blockingStub;
    private static LightServiceGrpc.LightServiceStub asyncStub;

    public static void main(String[] args) {
        JmDNS jmdns;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener("_light._tcp.local.", new ServiceListener() {
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
                    ManagedChannel channel = ManagedChannelBuilder.forAddress(event.getInfo().getHostAddresses()[0], event.getInfo().getPort())
                            .usePlaintext()
                            .build();

                    blockingStub = LightServiceGrpc.newBlockingStub(channel);
                    asyncStub = LightServiceGrpc.newStub(channel);

                    createAndShowGUI();
                }
            });
        } catch (IOException e) {
            System.err.println("Error initializing jmDNS: " + e.getMessage());
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("LightService Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(4, 1));

        // 子系统1: 控制一个灯的开/关状态
        JPanel controlLightPanel = new JPanel();
        contentPane.add(controlLightPanel);
        controlLightPanel.add(new JLabel("Light ID:"));
        JTextField controlLightIdField = new JTextField(10);
        controlLightPanel.add(controlLightIdField);
        JCheckBox controlLightTurnOnCheckBox = new JCheckBox("Turn On");
        controlLightPanel.add(controlLightTurnOnCheckBox);
        JButton controlLightButton = new JButton("Control Light");
        controlLightPanel.add(controlLightButton);

        controlLightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lightId = controlLightIdField.getText();
                boolean turnOn = controlLightTurnOnCheckBox.isSelected();
                ControlLightRequest request = ControlLightRequest.newBuilder().setLightId(lightId).setTurnOn(turnOn).build();
                ControlLightResponse response;
                try {
                    response = blockingStub.controlLight(request);
                    JOptionPane.showMessageDialog(null, "Success: " + response.getSuccess());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // 子系统2: 获取一个房间中所有灯的状态
        JPanel getRoomLightsPanel = new JPanel();
        contentPane.add(getRoomLightsPanel);
        getRoomLightsPanel.add(new JLabel("Room ID:"));
        JTextField getRoomIdField = new JTextField(10);
        getRoomLightsPanel.add(getRoomIdField);
        JButton getRoomLightsButton = new JButton("Get Room Lights");
        getRoomLightsPanel.add(getRoomLightsButton);
        getRoomLightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomId = getRoomIdField.getText();
                GetRoomLightsRequest request = GetRoomLightsRequest.newBuilder().setRoomId(roomId).build();
                GetRoomLightsResponse response;
                try {
                    response = blockingStub.getRoomLights(request);
                    List<String> lightStates = new ArrayList<>();
                    for (Light light : response.getLightsList()) {
                        lightStates.add("Light ID: " + light.getId() + ", State: " + (light.getIsOn() ? "On" : "Off"));
                    }
                    JOptionPane.showMessageDialog(null, String.join("\n", lightStates));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // 子系统3: 控制多个灯的开/关状态
        JPanel controlMultipleLightsPanel = new JPanel();
        contentPane.add(controlMultipleLightsPanel);
        controlMultipleLightsPanel.add(new JLabel("Light IDs (comma-separated):"));
        JTextField controlMultipleLightsIdField = new JTextField(10);
        controlMultipleLightsPanel.add(controlMultipleLightsIdField);
        JCheckBox controlMultipleLightsTurnOnCheckBox = new JCheckBox("Turn On");
        controlMultipleLightsPanel.add(controlMultipleLightsTurnOnCheckBox);
        JButton controlMultipleLightsButton = new JButton("Control Multiple Lights");
        controlMultipleLightsPanel.add(controlMultipleLightsButton);

        controlMultipleLightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] lightIds = controlMultipleLightsIdField.getText().split(",");
                boolean turnOn = controlMultipleLightsTurnOnCheckBox.isSelected();

                StreamObserver<ControlMultipleLightsResponse> responseObserver = new StreamObserver<ControlMultipleLightsResponse>() {
                    @Override
                    public void onNext(ControlMultipleLightsResponse response) {
                        JOptionPane.showMessageDialog(null, "Success: " + response.getSuccess());
                    }

                    @Override
                    public void onError(Throwable t) {
                        JOptionPane.showMessageDialog(null, "Error: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("controlMultipleLights stream completed");
                    }
                };

                StreamObserver<ControlMultipleLightsRequest> requestObserver = asyncStub.controlMultipleLights(responseObserver);
                for (String lightId : lightIds) {
                    ControlMultipleLightsRequest request = ControlMultipleLightsRequest.newBuilder().setLightId(lightId.trim()).setTurnOn(turnOn).build();
                    requestObserver.onNext(request);
                }
                requestObserver.onCompleted();
            }
        });

        frame.setVisible(true);
    }
}


