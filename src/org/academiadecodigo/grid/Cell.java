package org.academiadecodigo.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import static org.academiadecodigo.grid.Grid.CELL_SIZE;
import static org.academiadecodigo.grid.Grid.PADDING;

public class Cell {

    protected Rectangle cell;
    protected int col;
    protected int row;
    private boolean painted;

    public Cell(int cols, int rows) {
        cell = new Rectangle(PADDING + cols * CELL_SIZE, PADDING + rows * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        cell.draw();
    }

    public void paint() {
        painted = true;
        cell.fill();
    }

    public void erase() {
        painted = false;
        cell.draw();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Rectangle getCell() {
        return cell;
    }

    public boolean isPainted() {
        return painted;
    }
}