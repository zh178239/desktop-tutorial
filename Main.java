package Main;
import controller.Client;
import controller.Game;
import controller.StageContrller;
import javafx.stage.Stage;
import model.Setting;
import model.UserLib;
import javafx.application.Application;
import view.LoginFrame;
import view.RegisterFrame;
import view.StartFrame;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
//        Client client = new Client();
        Game game = new Game();
        Setting setting = new Setting("横刀立马"); // 初始化游戏设置
        game.initialize(setting); // 初始化游戏
        game.start();
        UserLib userLib = new UserLib();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageContrller stageContrller = new StageContrller(stage);
        StartFrame startFrame=new StartFrame(stage,stageContrller);
        stageContrller.start(startFrame);
    }
}