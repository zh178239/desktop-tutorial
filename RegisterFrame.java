package view;

import controller.Client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterFrame {
    private Stage stage;
    public MyLabel usernameLabel = new MyLabel("用户名:");
    public TextField usernameField = new TextField();
    public MyLabel passwordLabel = new MyLabel("密码:");
    public TextField passwordField = new TextField();
    public MyButton registerButton=new MyButton("注册");
    public LoginFrame loginFrame;
    public static String username;
    public static String password;

    public RegisterFrame(Client client) {
        registerButton.setOnAction(e -> {
            username = usernameField.getText();
            password = passwordField.getText();
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(registerButton, 1, 2);

        Scene scene = new Scene(gridPane, 300, 250);
        stage.setTitle("用户登录");
        stage.setScene(scene);
        stage.show();
    }
    //要写一个注册之后直接登录的转换程序
    public static String getusername() {
        return username;
    }
    public static String getpassword() {
        return password;
    }
    public void start(){

    }
}

