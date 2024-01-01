package org.academiadecodigo.grid;

import static org.academiadecodigo.grid.Grid.CELL_SIZE;

public class Cursor extends Cell {

    public Cursor() {
        super(0, 0);
        paint();
    }

    public void moveUp() {
        row--;
        cell.translate(0, -CELL_SIZE);
    }

    public void moveDown() {
        row++;
        cell.translate(0, CELL_SIZE);
    }

    public void moveLeft(){
        col--;
        cell.translate(-CELL_SIZE, 0);
    }

    public void moveRight(){
        col++;
        cell.translate(CELL_SIZE, 0 );
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
