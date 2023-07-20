package com.qkrmekem.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // Launch a Spring Context
        // 일반적으로 프라이빗 리소스는 private 접근자를 사용한 리소스를 뜻하지만
        // try문 또한 해당 블록에서 사용되고 리소스가 해제되기 때문에 프라이빗 리소스라고 할 수 있다
        /*
        예를 들어 아래의 코드처럼 인자에 connection을 생성하고 블록내에 로직을 작성하면 따로 connection을
        해제하지 않아도 자동으로 리소스를 해제해준다.
        그게 가능한 이유는 AutoCloseable 인터페이스를 구현한 클래스이기 때문인데,
        AutoCloseable을 구현한 클래스는 아래처럼 try문에 사용하면 자동으로 리소스를 해제할 수 있다.
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // 데이터베이스 연결을 사용하는 코드
            // ...
        } catch (SQLException e) {
            // 예외 처리 코드
        }
        * */
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // 설정 클래스 생성
            // name빈 등록
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person5Qualifier"));

//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);
        };

    }
}
