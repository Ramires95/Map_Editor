package org.academiadecodigo.grid;

import java.io.*;

public class Grid {

    public static final int CELL_SIZE = 20, PADDING = 10;
    private Cell[][] cells;
    private int cols, rows;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cells = new Cell[cols][rows];
        createGrid();
    }

    public void createGrid() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void clearGrid() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j].erase();
            }
        }
    }

    public String saveToString() {
        StringBuilder painted = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                painted.append(cells[i][j].getCell().isFilled() ? "p" : "n");
            }
        }
        return painted.toString();
    }

    public void saveToFile() {
        BufferedWriter out;

        try {
            out = new BufferedWriter(new FileWriter("painted.txt"));
            out.write(saveToString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadToString() {
        BufferedReader in = null;
        StringBuilder painted = new StringBuilder();

        try {
            in = new BufferedReader(new FileReader("painted.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                painted.append(line).append("\n");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return painted.toString();
    }

    public void loadToGrid() {
        String painted = loadToString();
        int paintedCells = 0;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (painted.charAt(j + paintedCells) == 'p') {
                    cells[i][j].getCell().fill();
                }
            }
            paintedCells += rows;
        }
    }

    public Cell getCell(int col, int row) {
        return cells[col][row];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
