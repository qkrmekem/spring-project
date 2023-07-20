package com.qkrmekem.learnspringframework.examples.a1;

import com.qkrmekem.learnspringframework.game.GameRunner;
import com.qkrmekem.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusinessclass{
    Dependency1 dependency1;
    Dependency2 dependency2;

    public YourBusinessclass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }

    @Override
    public String toString() {
        return "YourBusinessclass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2 {

}
@Configuration
// @ComponentScan을 main클래스에서 사용하면
// 해당 패키지를 컴포넌트 스캔 대상으로 지정
// 따로 경로를 지정하지 않으면 클래스파일 위치와 그 믿에 있는 모든 패키지를
// 컴포넌트 스캔 대상으로 지정
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class);) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }

    }
}
