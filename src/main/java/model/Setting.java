package model;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Setting {
    public ArrayList<PieceAndPos> piecesAndPoses;
    public PieceAndPos winCondition;
    public int height, width;
    public Piece caoCao = new Piece("曹操", 2, 2, Color.RED);
    public Piece zhangFei = new Piece("张飞", 2, 1, Color.BLUE);
    public Piece zhaoYun = new Piece("赵云", 2, 1, Color.GREEN);
    public Piece maChao = new Piece("马超", 2, 1, Color.YELLOW);
    public Piece huangZhong = new Piece("黄忠", 2, 1, Color.ORANGE);
    public Piece guanYu = new Piece("关羽", 1, 2, Color.PURPLE);
    public Piece xiaoBing1 = new Piece("1号小兵", 1, 1, Color.CYAN);
    public Piece xiaoBing2 = new Piece("2号小兵", 1, 1, Color.BEIGE);
    public Piece xiaoBing3 = new Piece("3号小兵", 1, 1, Color.GRAY);
    public Piece xiaoBing4 = new Piece("4号小兵", 1, 1, Color.BLACK);


    public Setting(String name) throws Exception {
        piecesAndPoses = new ArrayList<>();

        if (name.equals("横刀立马")) {
            height = 5;
            width = 4;

            piecesAndPoses.add(new PieceAndPos(zhangFei, 0, 0));
            piecesAndPoses.add(new PieceAndPos(caoCao, 0, 1));
            piecesAndPoses.add(new PieceAndPos(zhaoYun, 0, 3));
            piecesAndPoses.add(new PieceAndPos(maChao, 2, 0));
            piecesAndPoses.add(new PieceAndPos(huangZhong, 2, 3));
            piecesAndPoses.add(new PieceAndPos(guanYu, 2, 1));
            piecesAndPoses.add(new PieceAndPos(xiaoBing1, 4, 0));
            piecesAndPoses.add(new PieceAndPos(xiaoBing2, 3, 1));
            piecesAndPoses.add(new PieceAndPos(xiaoBing3, 3, 2));
            piecesAndPoses.add(new PieceAndPos(xiaoBing4, 4, 3));

            winCondition = new PieceAndPos(caoCao, 3, 1);
        } else {
            throw new Exception("未找到该名称的游戏设置！");
        }
    }


}
