package com.qkrmekem.learnspringframework;

import com.qkrmekem.learnspringframework.game.GameRunner;
import com.qkrmekem.learnspringframework.game.GamingConsole;
import com.qkrmekem.learnspringframework.game.PackmanGame;
import com.qkrmekem.learnspringframework.game.SuperContraGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole game() {
        // 1. 객체 생성
        var game = new PackmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner() {
        var gameRunner = new GameRunner(game());
        return gameRunner;
    }



}
