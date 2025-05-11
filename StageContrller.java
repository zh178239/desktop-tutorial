package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoginFrame;
import view.RegisterFrame;
import view.StartFrame;

public class StageContrller {
    private final Stage stage;
    private final Client client=new Client();
    Scene scene=new Scene(StartFrame.getGridPane(), 300, 250);
    Scene scene1=new Scene(LoginFrame.getGridPane(),300,250);
    Scene scene2=new Scene(RegisterFrame.getGridPane(),300,250);

    public StageContrller(Stage stage) {
        this.stage=stage;
    }

    public void start(StartFrame startFrame) {
        stage.setTitle("开始界面");
        stage.setScene(scene);
        stage.show();
    }

    public void showLogin(LoginFrame loginFrame) {
        stage.setTitle("Login");
        stage.setScene(scene1);
        stage.show();
    }

    public void showRegister(RegisterFrame registerFrame) {
        stage.setTitle("Register");
        stage.setScene(scene2);
        stage.show();
    }
}
