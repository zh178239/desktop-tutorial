package board;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BController extends Application {

    private static final int TILE_SIZE = 80;
    private static final int GRID_SIZE = 5;
    private Tile[][] board = new Tile[5][4];

    // 经典布局（横刀立马）
    private final int[][] layout = {
            {2, 1, 1, 5},
            {2, 1, 1, 5},
            {3, 4, 4, 6},
            {3, 7, 7, 6},
            {7, 0, 0, 7}
    };

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = createBoard();
        setupLayout(grid);

        Scene scene = new Scene(grid, TILE_SIZE*GRID_SIZE, TILE_SIZE*GRID_SIZE);
        primaryStage.setTitle("华容道 - 横刀立马");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createBoard() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(3);
        grid.setVgap(3);
        grid.setStyle("-fx-background-color: #333;");


        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < 4; col++) {
                Tile tile = new Tile(0, 1, 1); // 初始化为空格
                board[row][col] = tile;
                grid.add(tile, col, row);
            }
        }
        return grid;
    }

    private void setupLayout(GridPane grid) {

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                int type = layout[row][col];
                if (type != 0) {
                    Tile tile = createTile(type, row, col);
                    updateGrid(grid, tile, row, col);
                }
            }
        }
    }

    private Tile createTile(int type, int row, int col) {
        Color color = switch (type) {
            case 1 -> Color.RED;
            case 2 -> Color.BLUE;
            case 3 -> Color.GREEN;
            case 4 -> Color.YELLOW;
            case 5 -> Color.ORANGE;
            case 6 -> Color.PURPLE;
            case 7 -> Color.CYAN;
            default -> Color.TRANSPARENT;
        };

        int width = (type == 1) ? 2 : 1;  // 曹操2x2
        int height = (type == 2) ? 2 : 1; // 关羽纵向2格

        Tile tile = new Tile(type, width, height);
        tile.setFill(color);
        tile.setStroke(Color.BLACK);
        tile.setStrokeWidth(2);

        return tile;
    }


    private void updateGrid(GridPane grid, Tile tile, int row, int col) {
        grid.getChildren().removeIf(node ->
                GridPane.getRowIndex(node) == row &&
                        GridPane.getColumnIndex(node) == col
        );

        grid.add(tile, col, row);
        GridPane.setColumnSpan(tile, tile.getwidth());
        GridPane.setRowSpan(tile, tile.getheight());
    }

    class Tile extends Rectangle {
        private final int type;
        private final int width;
        private final int height;

        public Tile(int type, int width, int height) {
            super(TILE_SIZE * width - 3, TILE_SIZE * height - 3);
            this.type = type;
            this.width = width;
            this.height = height;
        }

        public boolean isEmpty() {
            return type == 0;
        }

        public int gettype() {
            return type;
        }

        public int getwidth() {
            return width;
        }

        public int getheight() {
            return height;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}