package com.company;

public class BoardClient {
    private Board board;
    private final double fps = 10.0;
    private final double ns = 1000000000.0 / fps;
    private double delta = 0;
    private double lastTime = System.nanoTime();
    private GameView gV;

    public BoardClient(GameView gV, Board board) {
        this.board = board;
        this.gV = gV;
    }

    public void runGame() {
        boolean playing = true;
        gV.draw();
        while (playing) {
            double now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1.0) {
                board.update();
                gV.draw();
                delta--;
            }
        }
    }
}
