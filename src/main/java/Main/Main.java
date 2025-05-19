package Main;
import controller.Client;
import controller.Game;
import controller.LoginController;
import controller.StageController;
import javafx.stage.Stage;
import model.Setting;
import model.UserLib;
import javafx.application.Application;
import view.*;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Setting setting = new Setting("横刀立马");// 初始化游戏设置
        UserLib lib = new UserLib();
        Client client = new Client(lib);
        LoginController login=new LoginController();
        login.onLogin(LoginFrame.username);
    }
}