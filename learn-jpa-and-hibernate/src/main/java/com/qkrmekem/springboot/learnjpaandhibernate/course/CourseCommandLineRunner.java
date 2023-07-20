package com.qkrmekem.springboot.learnjpaandhibernate.course;

import com.qkrmekem.springboot.learnjpaandhibernate.Course;
import com.qkrmekem.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.qkrmekem.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.qkrmekem.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner
// spring 어플리케이션 시작 시에 실행될 로직이 있을 때 활용
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    private CourseJdbcRepository repository;
//
//    public CourseCommandLineRunner(CourseJdbcRepository repository) {
//        this.repository = repository;
//    }

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS Jpa!,", "qkrmekem"));
//        repository.insert(new Course(2, "Learn Azure Jpa!,", "qkrmekem"));
//        repository.insert(new Course(3, "Learn DevOps Jpa!,", "qkrmekem"));
        repository.save(new Course(1, "Learn AWS Jpa!,", "qkrmekem"));
        repository.save(new Course(2, "Learn Azure Jpa!,", "qkrmekem"));
        repository.save(new Course(3, "Learn DevOps Jpa!,", "qkrmekem"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("qkrmekem"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS Jpa!"));
        System.out.println(repository.findByName("Learn DevOps Jpa!"));
    }
}
