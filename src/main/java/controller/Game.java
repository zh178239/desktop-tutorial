package controller;

import model.*;
import view.GameFrame;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.LoginFrame;
import view.RegisterFrame;


import java.io.*;
import java.util.ArrayList;

public class Game {
    public GameBoard gameBoard;
    public Setting setting;
    private Stage stage;
    private GameFrame frame;
    public ArrayList<Piece> piecesMoved= new ArrayList<>();
    public ArrayList<Direction> directionsMoved = new ArrayList<>();

    public Game(){

    }

    public Game(Setting setting) {
        gameBoard = new GameBoard(setting.height, setting.width);
    }

    public void initialize(Setting setting) throws Exception {
        this.setting = setting;
        gameBoard.clear();
        piecesMoved.clear();
        directionsMoved.clear();
        for (PieceAndPos pieceAndPos : setting.piecesAndPoses) {
            gameBoard.put(pieceAndPos.piece, pieceAndPos.h, pieceAndPos.w);
        }
    }


    public void start(Stage stage,Client client) throws Exception {
        frame=new GameFrame(stage , gameBoard, this);
        stage.show();
    }


    public void step(Piece piece, Direction direction) {
        try {
            if (gameBoard.ableToMove(piece, direction)) {
                gameBoard.move(piece, direction);
                piecesMoved.add(piece);
                directionsMoved.add(direction);

                // 更新 JavaFX 控件中的状态
                Platform.runLater(() -> {
                    frame.gamePanel.update(piece, direction);

                    // 检查是否达成胜利条件
                    PieceAndPos winCondition = setting.winCondition;
                    if (gameBoard.pieceAtPos(winCondition.piece, winCondition.h, winCondition.w)) {
                        end();
                    }
                });
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void undo() throws Exception {
        int n =piecesMoved.size()-1;
        gameBoard.move(piecesMoved.get(n),directionsMoved.get(n).reverse());
        piecesMoved.remove(n);
        directionsMoved.remove(n);
    }

    public int numberOfMoves()
    {
        return piecesMoved.size();
    }

    public void end() {
        // 使用 JavaFX 弹出提示框代替 Swing 的 JOptionPane
        Platform.runLater(() -> {
            Button btn = new Button("恭喜获胜！");
            btn.setOnAction(e -> {
                stage.close();  // 关闭窗口
            });

            StackPane endRoot = new StackPane();
            endRoot.getChildren().add(btn);
            Scene endScene = new Scene(endRoot, 300, 200);
            Stage endStage = new Stage();
            endStage.setTitle("Game Over");
            endStage.setScene(endScene);
            endStage.show();
        });
    }
    //存档用户进度
    public void saveProgress(String username)
    {
        GameProgress progress = new GameProgress(setting,new ArrayList<>(piecesMoved),new ArrayList<>(directionsMoved));
        //复制集合元素
        File dir=new File("saves");
        if(!dir.exists())dir.mkdirs();

        try (ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(dir,username+".sav"))))
        {
            out.writeObject(progress);
            System.out.println("存档成功："+dir.getAbsolutePath()+"/"+username+".sav");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //从文件读回进度，没有存档就返回null
    public static GameProgress loadProgress(String username)
    {
        File f =new File("saves",username+".sav");
        if(!f.exists()) return null;
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f))){
            return (GameProgress) in.readObject();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
