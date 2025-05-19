package model;


import java.io.Serializable;
import java.util.List;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Setting setting;              // 初始布局
    private final List<Piece> piecesMoved;      // 玩家走过的每一步：棋子
    private final List<Direction> directions;   // 玩家走过的每一步：方向

    public GameProgress(Setting setting,
                        List<Piece> piecesMoved,
                        List<Direction> directions) {
        this.setting       = setting;
        this.piecesMoved   = piecesMoved;
        this.directions    = directions;
    }

    public Setting getSetting() {
        return setting;
    }
    public List<Piece> getPiecesMoved() {
        return piecesMoved;
    }
    public List<Direction> getDirections() {
        return directions;
    }
}

