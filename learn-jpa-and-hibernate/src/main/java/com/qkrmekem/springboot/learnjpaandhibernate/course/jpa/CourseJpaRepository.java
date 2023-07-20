package com.qkrmekem.springboot.learnjpaandhibernate.course.jpa;

import com.qkrmekem.springboot.learnjpaandhibernate.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    // 컨테이너 관리형 EntityManager 및
    // 그에 연결된 영속성 컨텍스트와의 종속성을 나타냄
    @PersistenceContext
    private EntityManager entityManager;

//    public CourseJpaRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
