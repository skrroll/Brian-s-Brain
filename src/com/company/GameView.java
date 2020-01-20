package com.company;

import javax.swing.*;
import java.awt.*;
import static com.company.Cell.*;

public class GameView {
    private JPanel canvas;
    private int node_size;
    private Board board;

    public GameView(Board board, int node_size) {
        this.board = board;
        this.node_size = node_size;
        init();
    }

    private void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                for (int i = 0; i < board.getWidth(); i++) {
                    for (int j = 0; j < board.getHeight(); j++) {
                        switch(board.getCell(i, j)) {
                            case ON:
                                g.setColor(Color.BLUE);
                                g.fillRect(i * node_size, j * node_size,(i * node_size) + node_size - 1, (j * node_size) + node_size - 1);
                                break;
                            case DYING:
                                g.setColor(Color.WHITE);
                                g.fillRect(i * node_size, j * node_size,(i * node_size) + node_size - 1, (j * node_size) + node_size - 1);
                                break;
                            case OFF:
                                g.setColor(Color.BLACK);
                                g.fillRect(i * node_size, j * node_size,(i * node_size) + node_size - 1, (j * node_size) + node_size - 1);
                                break;
                        }
                    }
                }
            }
        };
    }

    public void draw() {
        canvas.repaint();
    }

    public JPanel getCanvas() {
        return canvas;
    }

}
