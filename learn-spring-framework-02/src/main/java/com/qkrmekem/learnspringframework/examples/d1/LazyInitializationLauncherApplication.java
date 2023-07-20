package com.qkrmekem.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
// 기본적으로 스프링 빈은 eager 초기화
// 왜냐하면 이렇게 해야 서버가 시작하는 시점에서 구성에러를 발견할 수 있음
// Lazy는 권장되지 않음
// @Component나 @Bean이 사용되는 모든곳에 사용 가능
// 이럴 경우 프록시 객체가 대신 주입됨
// @Configuration에다가도 사용이 가능한데
// 이 경우 @Configuration 안의 모든 빈도 지연 초기화가 됨
// 하지만 지연 초기화를 이용할 경우 서버가 시작될 때 spring구성 에러는 발견되지 않음
//@Lazy
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }

    public void doSomeThing() {
        System.out.println("do something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (LazyInitializationLauncherApplication.class)) {
//            System.out.println("Initialization of context is competed");
//
//            context.getBean(ClassB.class).doSomeThing();
        }
    }
}
