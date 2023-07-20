package com.qkrmekem.learnspringframework.examples.h1;

import com.qkrmekem.learnspringframework.examples.a0.SimpleSpringContextLauncherApplication;
import com.qkrmekem.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {

        try (var context =
                    // xml configuration 파일을 사용할 경우 ClassPathXmlApplicationContext을 사용
                     new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            context.getBean(GameRunner.class).run();

        }
    }
}
