package com.qkrmekem.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// 이 어노테이션을 선언하고 해당 빈을 인자로 받는
// 생성자에 해당 어노테이션을 그대로 적용
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    public void up() {
        System.out.println("up");
    }
    public void down() {
        System.out.println("Sit down");
    }
    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("Shoot a bullet");
    }
}
