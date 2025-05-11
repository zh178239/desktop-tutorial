package view;

import controller.Client;
import controller.StageContrller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartFrame {
    MyTitle label=new MyTitle("华容道");
    MyButton login=new MyButton("登录");
    MyButton register=new MyButton("注册");
    public static GridPane grid=new GridPane();
    public StartFrame(Stage stage,StageContrller stageContrller) {
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(label,0,0);
        grid.add(login,0,1);
        grid.add(register,0,2);
        register.setOnAction(e->{
            stageContrller.showRegister(new RegisterFrame(stage,stageContrller));
        });
        login.setOnAction(e->{
            stageContrller.showLogin(new LoginFrame(stage,stageContrller));
        });
    }
    public static GridPane getGridPane() {
        return grid;
    }
}
