package com.qkrmekem.learnspringframework;

import com.qkrmekem.learnspringframework.game.GameRunner;
import com.qkrmekem.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

//        var marioGame = new MarioGame();

        // 1. 객체 생성
        var superContraGame = new SuperContraGame();
        // 2. 객체 생성 + 종속성 생성
        var gameRunner = new GameRunner(superContraGame);
        gameRunner.run();
    }
}
