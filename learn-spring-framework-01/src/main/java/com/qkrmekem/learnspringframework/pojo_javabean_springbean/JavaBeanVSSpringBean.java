package com.qkrmekem.learnspringframework.pojo_javabean_springbean;

import java.io.Serializable;

// 아무런 제약이 없으며
// 모든 객체가 pojo
class Pojo {
    private String text;

    private int number;

    @Override
    public String toString() {
        return "Pojo{" +
                "text='" + text + '\'' +
                '}';
    }
}

// Serializable을 상속받아야함
// 따로 구현해야 하는 메서드는 없으며 그저 선언만 하면 됨
class JavaBean implements Serializable { // EJB

    private String text;

    private int number;

    // 1. public no-args constructor
    // 인수 생성자가 없어야 함
    public JavaBean() {
    }

    // 2. getter setter가 있어야함

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

// SpringBean
// 스프링(또는 컨테이너, IOC컨테이너)에서 관리하는 빈
public class JavaBeanVSSpringBean {

    public static void main(String[] args) {
        Pojo pojo = new Pojo();

        System.out.println(pojo);
    }
}
