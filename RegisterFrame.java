package view;

import controller.Client;
import controller.StageContrller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class RegisterFrame {
    public MyLabel usernameLabel = new MyLabel("用户名:");
    public TextField usernameField = new TextField();
    public MyLabel passwordLabel = new MyLabel("密码:");
    public TextField passwordField = new TextField();
    public MyButton registerButton=new MyButton("注册");
    public static String username;
    public static String password;
    public static GridPane gridPane=new GridPane();

    public RegisterFrame(Stage stage,StageContrller stageContrller) {
        registerButton.setOnAction(e -> {
            username = usernameField.getText();
            password = passwordField.getText();
            stageContrller.showLogin(new LoginFrame(stage,stageContrller));
        });

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(registerButton, 1, 2);
    }
    public String getusername() {
        return username;
    }
    public String getpassword() {
        return password;
    }
    public static GridPane getGridPane() {
        return gridPane;
    }
}

