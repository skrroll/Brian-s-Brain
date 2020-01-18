package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int width = 100;
        int height = 100;
        int node_size = 4;
        JFrame window = new JFrame("Brian's Brain");
        Board board = new Board(width, height);
        GameView gameView = new GameView(board, node_size);
        BoardClient bClient = new BoardClient(gameView, board);
        Container contentPane = window.getContentPane();
        gameView.getCanvas().setPreferredSize(new Dimension(width * node_size, height * node_size));
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        bClient.runGame();
    }
}
