-- 스프링 데이터 jpa starter를 활용할 때마다 schema.sql을 활용하여 테이블을 생성해줌
create table course(
    id bigint not null,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
);