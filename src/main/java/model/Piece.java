package model;

import javafx.scene.paint.Color;
import java.io.Serializable;
import java.util.Objects;


public class Piece implements Serializable {
    public String name;
    public int height, width;
    public Color color;

    public Piece(String name, int height, int width, Color color) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.color = color;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(name, piece.name); // 名称唯一性验证
    }

}
