package controller;
import model.GameProgress;
import model.Setting;
import controller.Game;
import controller.StageController;
import javafx.stage.Stage;
import view.LoginFrame;
import view.RegisterFrame;
import view.StartFrame;
import model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoginController {
    public LoginFrame loginFrame;
    public RegisterFrame registerFrame;
    public StartFrame startFrame;

    public void onLogin(String username) throws Exception {

        // 尝试加载存档
        GameProgress prog = Game.loadProgress(username);
        if (prog != null) {
            // 恢复布局和步数
            try {
                Setting theSetting=prog.getSetting();
                Game game = new Game(theSetting);
                game.initialize(theSetting);
                GameBoard board=new GameBoard(theSetting.height, theSetting.width);
            } catch (Exception e) { e.printStackTrace(); }
            // 按历史步数走一遍
            for (int i = 0; i < prog.getPiecesMoved().size(); i++) {
                game.step(prog.getPiecesMoved().get(i),
                        prog.getDirections().get(i));
            }
        } else {
            // 无存档：加载默认关卡
            Setting defaultSetting = new Setting("横刀立马");
            try {
                Game game = new Game(theSetting);
                game.initialize(defaultSetting);
                GameBoard board=new GameBoard(defaultSetting.height, defaultSetting.width);

            } catch (Exception e) { e.printStackTrace(); }
        }
 }
    public void onGuest(Stage stage) throws Exception {
        // 游客无法存档，只加载默认关卡
        Setting setting = new Setting("横刀立马");
        Game game = new Game(setting);
        game.initialize(setting);

        // 传入一个没有用户功能的 client
        startGame(stage, game, null); // 或 new Client(null)
    }
    private void startGame(Stage stage, Game game, Client client) throws Exception {
        StageController stageController = new StageController(stage);
        startFrame = new StartFrame(stage, stageController, game, client,this);
        loginFrame = new LoginFrame(stage, stageController, game, client,this);
        registerFrame = new RegisterFrame(stage, stageController, game, client,this);
        stageController.start(startFrame);
    }
    //从文件读回进度，没有存档就返回null
    public static GameProgress loadProgress(String username) {
        File f = new File("saves", username + ".sav");
        if (!f.exists()) return null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (GameProgress) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
