package login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LController extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label usernameLabel = new Label("用户名:");
        TextField usernameField = new TextField();
        Label emailLabel = new Label("邮箱:");
        TextField emailField = new TextField();
        Button registerButton = new Button("登录");

        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();

        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(registerButton, 1, 2);

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setTitle("用户登录");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //要写一个没有账号然后去注册的程序

    public static void main(String[] args) {
        launch(args);
    }
}
