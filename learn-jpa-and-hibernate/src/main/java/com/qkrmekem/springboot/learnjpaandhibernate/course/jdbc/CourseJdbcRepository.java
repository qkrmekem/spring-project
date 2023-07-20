package com.qkrmekem.springboot.learnjpaandhibernate.course.jdbc;

import com.qkrmekem.springboot.learnjpaandhibernate.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 텍스트 블록
    // 멀티 라인의 문자열을 이스케이프 없이 사용할 수 있도록 지원하는 기능
    // 참고 : https://mostadmired.tistory.com/132
    private static String INSERT_QUERY =
            """
                    insert into course (id, name, author)
                    values(?, ?, ?);
                    
            """;

    private static String DELETE_QUERY =
            """
                    delete from course
                    where id = ?
                    """;

    private static String SELECT_QUERY =
            """
                        select * from course
                        where id = ?
                    """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // ResultSet -> Bean => Row Mapper
        // 객체 생성 -> setter를 이용해 필드 매핑
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }


}
