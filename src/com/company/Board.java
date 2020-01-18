package com.company;

import java.util.Random;

import static com.company.Cell.*;

public class Board {
    private Cell[][] board;
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Cell[width][height];
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = OFF;
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int x = random.nextInt(10);
                if(x == 1) {
                    board[i][j] = ON;
                }
            }
        }
    }

    public void update() {
        Cell[][] newBoard = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                switch (board[i][j]) {
                    case DYING:
                        newBoard[i][j] = OFF;
                        break;
                    case ON:
                        newBoard[i][j] = DYING;
                        break;
                    case OFF:
                        if (neighboursOn(i, j)) {
                            newBoard[i][j] = ON;
                        } else {
                            newBoard[i][j] = OFF;
                        }
                        break;
                }
            }
        }
        this.board = newBoard;
    }

    private boolean neighboursOn(int x, int y) {
        int count = 0;
        for (int i = (x - 1); i <= (x + 1); i++) {
            for (int j = (y - 1); j <= (y + 1); j++) {
                if(i < 0 || j < 0 || i >= width || j >= height) {
                    continue;
                } else if (board[i][j] == ON) {
                    count++;
                }
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Cell getCell(int x, int y) {
        return this.board[x][y];
    }
}
