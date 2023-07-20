package com.qkrmekem.learnspringframework;

import com.qkrmekem.learnspringframework.game.GameRunner;
import com.qkrmekem.learnspringframework.game.GamingConsole;
import com.qkrmekem.learnspringframework.game.SuperContraGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(GamingConfiguration.class);) {

            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

    }
}
