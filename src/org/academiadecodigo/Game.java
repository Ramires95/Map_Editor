package org.academiadecodigo;

import org.academiadecodigo.grid.Cell;
import org.academiadecodigo.grid.Cursor;
import org.academiadecodigo.grid.Grid;

public class Game {
    private Cursor cursor;
    private Grid grid;
    private boolean isPainting;

    public Game(int cols, int rows) {
        cursor = new Cursor();
        grid = new Grid(cols, rows);
    }

    public void moveCursor(Cursor.Direction direction) {

        if (isEdge(direction)) {
            return;
        }

        switch (direction) {
            case UP -> cursor.moveUp();
            case DOWN -> cursor.moveDown();
            case LEFT -> cursor.moveLeft();
            case RIGHT -> cursor.moveRight();

        }

        if (isPainting) {
            paint();
        }

    }

    public void paint() {
        Cell cell = grid.getCell(cursor.getCol(), cursor.getRow());
        if (cell.isPainted()) {
            cell.erase();
        } else {
            cell.paint();
        }
    }

    public void save() {
        grid.saveToFile();
    }

    public void load() {
        grid.loadToGrid();
    }

    public void clear() {
        grid.clearGrid();
    }

    public void setPainting(boolean painting) {
        isPainting = painting;
    }

    public boolean isEdge(Cursor.Direction direction) {
        return direction == Cursor.Direction.UP && cursor.getRow() == 0 ||
                direction == Cursor.Direction.DOWN && cursor.getRow() == grid.getRows() -1 ||
                direction == Cursor.Direction.LEFT && cursor.getCol() == 0 ||
                direction == Cursor.Direction.RIGHT && cursor.getCol() == grid.getCols() -1;
    }
}
