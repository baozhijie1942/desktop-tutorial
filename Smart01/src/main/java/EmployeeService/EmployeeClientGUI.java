package EmployeeService;


import EmployeeService.EmployeeServiceGrpc;
import EmployeeService.GetEmployeeSystemRequest;
import EmployeeService.GetEmployeeSystemResponse;
import EmployeeService.ListEmployeesSystemRequest;
import EmployeeService.ListEmployeesSystemResponse;
import EmployeeService.UpdatingEmployeeInformationRequest;
import EmployeeService.UpdatingEmployeeInformationResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeClientGUI extends Application {
    private EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    private EmployeeServiceGrpc.EmployeeServiceStub asyncStub;

    private TextField getEmployeeSystemEidTextField;
    private Label getEmployeeSystemEnameLabel;
    private Label getEmployeeSystemEmailLabel;
    private Label getEmployeeSystemEphoneLabel;

    private ListView<String> listEmployeesSystemListView;

    private TextField updateEmployeeSystemEidTextField;
    private TextField updateEmployeeSystemNemailTextField;
    private TextField updateEmployeeSystemNephoneTextField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Use jmDNS to discover the service
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            List<ServiceInfo> serviceInfos = Arrays.asList(jmdns.list("_grpc._tcp.local."));
            ServiceInfo serviceInfo = serviceInfos.get(0);

            // Create a gRPC channel to the service
            ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceInfo.getHostAddresses()[0], serviceInfo.getPort())
                    .usePlaintext()
                    .build();

            // Create a blocking stub and async stub for the gRPC service
            blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
            asyncStub = EmployeeServiceGrpc.newStub(channel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create the GUI window
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(gridPane, 700, 500);

        // Add controls to the GUI window for GetEmployeeSystem
        Label getEmployeeSystemLabel = new Label("Get Employee System");
        Label getEmployeeSystemEidLabel = new Label("Employee ID:");
        getEmployeeSystemEidTextField = new TextField();
        getEmployeeSystemEnameLabel = new Label();
        getEmployeeSystemEmailLabel = new Label();
        getEmployeeSystemEphoneLabel = new Label();
        Label updateEmployeeSystemResponseLabel = new Label();
        gridPane.add(updateEmployeeSystemResponseLabel, 0, 13);
        Button getEmployeeSystemButton = new Button("Get");
        getEmployeeSystemButton.setOnAction(event -> {
            GetEmployeeSystemRequest getEmployeeSystemRequest = GetEmployeeSystemRequest.newBuilder()
                    .setEid(getEmployeeSystemEidTextField.getText())
                    .build();
            GetEmployeeSystemResponse getEmployeeSystemResponse = blockingStub.getEmployeeSystem(getEmployeeSystemRequest);
            getEmployeeSystemEnameLabel.setText("EmployeeName: " + getEmployeeSystemResponse.getEname());
            getEmployeeSystemEmailLabel.setText("Email Address: " + getEmployeeSystemResponse.getEmail());
            getEmployeeSystemEphoneLabel.setText("Phone Number: " + getEmployeeSystemResponse.getEphone());
        });
        // Add controls to the GUI window for ListEmployeesSystem
        Label listEmployeesSystemLabel = new Label("List Employees System");
        listEmployeesSystemListView = new ListView<>();
        Button listEmployeesSystemButton = new Button("List");
        listEmployeesSystemButton.setOnAction(event -> {
            ListEmployeesSystemRequest listEmployeesSystemRequest = ListEmployeesSystemRequest.newBuilder()
                    .build();
            List<String> employeeList = new ArrayList<>();
            blockingStub.listEmployeesSystem(listEmployeesSystemRequest).forEachRemaining(response -> {
                employeeList.add("Employee ID: " + response.getEid() + ", Name: " + response.getName());
            });
            listEmployeesSystemListView.getItems().clear();
            listEmployeesSystemListView.getItems().addAll(employeeList);
        });

        // Add controls to the GUI window for UpdateEmployeeSystem
        Label updateEmployeeSystemLabel = new Label("Update Employee System");
        Label updateEmployeeSystemEidLabel = new Label("Employee ID:");
        updateEmployeeSystemEidTextField = new TextField();
        Label updateEmployeeSystemNemailLabel = new Label("New Email Address:");
        updateEmployeeSystemNemailTextField = new TextField();
        Label updateEmployeeSystemNephoneLabel = new Label("New Phone Number:");
        updateEmployeeSystemNephoneTextField = new TextField();
        Button updateEmployeeSystemButton = new Button("Update");
        updateEmployeeSystemButton.setOnAction(event -> {
            StreamObserver<UpdatingEmployeeInformationRequest> updateEmployeeSystemRequestObserver = asyncStub.updateEmployeeSystem(new StreamObserver<UpdatingEmployeeInformationResponse>() {
                @Override
                public void onNext(UpdatingEmployeeInformationResponse response) {
                    if (response.getSuccess()) {
                        updateEmployeeSystemEidTextField.clear();
                        updateEmployeeSystemNemailTextField.clear();
                        updateEmployeeSystemNephoneTextField.clear();
                        updateEmployeeSystemResponseLabel.setText("Update successful.");
                    } else {
                        updateEmployeeSystemResponseLabel.setText("Update failed.");
                    }
                }

                @Override
                public void onError(Throwable t) {
                    updateEmployeeSystemResponseLabel.setText("Update failed: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                }
            });
            UpdatingEmployeeInformationRequest updateEmployeeSystemRequest = UpdatingEmployeeInformationRequest.newBuilder()
                    .setEid(updateEmployeeSystemEidTextField.getText())
                    .setNemail(updateEmployeeSystemNemailTextField.getText())
                    .setNephone(updateEmployeeSystemNephoneTextField.getText())
                    .build();
            updateEmployeeSystemRequestObserver.onNext(updateEmployeeSystemRequest);
            updateEmployeeSystemRequestObserver.onCompleted();
        });
        //Label updateEmployeeSystemResponseLabel = new Label();

        // Add controls to the GUI window for layout
        HBox getEmployeeSystemBox = new HBox(10);
        getEmployeeSystemBox.getChildren().addAll(getEmployeeSystemEidLabel, getEmployeeSystemEidTextField, getEmployeeSystemButton);
        VBox getEmployeeSystemVBox = new VBox(10);
        getEmployeeSystemVBox.getChildren().addAll(getEmployeeSystemLabel, getEmployeeSystemBox, getEmployeeSystemEnameLabel, getEmployeeSystemEmailLabel, getEmployeeSystemEphoneLabel);
        HBox listEmployeesSystemBox = new HBox(10);
        listEmployeesSystemBox.getChildren().addAll(listEmployeesSystemButton);
        VBox listEmployeesSystemVBox = new VBox(10);
        listEmployeesSystemVBox.getChildren().addAll(listEmployeesSystemLabel, listEmployeesSystemListView, listEmployeesSystemBox);
        HBox updateEmployeeSystemBox1 = new HBox(10);
        updateEmployeeSystemBox1.getChildren().addAll(updateEmployeeSystemEidLabel, updateEmployeeSystemEidTextField);
        HBox updateEmployeeSystemBox2 = new HBox(10);
        updateEmployeeSystemBox2.getChildren().addAll(updateEmployeeSystemNemailLabel, updateEmployeeSystemNemailTextField);
        HBox updateEmployeeSystemBox3 = new HBox(10);
        updateEmployeeSystemBox3.getChildren().addAll(updateEmployeeSystemNephoneLabel, updateEmployeeSystemNephoneTextField);
        HBox updateEmployeeSystemBox4 = new HBox(10);
        updateEmployeeSystemBox4.getChildren().addAll(updateEmployeeSystemButton);
        VBox updateEmployeeSystemVBox = new VBox(10);
        updateEmployeeSystemVBox.getChildren().addAll(updateEmployeeSystemLabel, updateEmployeeSystemBox1, updateEmployeeSystemBox2, updateEmployeeSystemBox3, updateEmployeeSystemBox4, updateEmployeeSystemResponseLabel);
        gridPane.add(getEmployeeSystemVBox, 0, 0);
        gridPane.add(listEmployeesSystemVBox, 1, 0);
        gridPane.add(updateEmployeeSystemVBox, 2, 0);
        // Show the GUI window
        primaryStage.setTitle("Employee Service Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}