package com.qkrmekem.learnspringframework.game;

public class GameRunner {
    private GamingConsole game;
    public GameRunner(GamingConsole marioGame) {
        this.game = marioGame;
    }

    public void run() {
        System.out.println("Running game: "+ game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
