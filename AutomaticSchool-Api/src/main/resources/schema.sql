DROP TABLE IF EXISTS STUDENTS_IN_GROUPS;
DROP TABLE IF EXISTS GROUPS_STUDENT;
DROP TABLE IF EXISTS GROUPS;
DROP TABLE IF EXISTS COURSE;
DROP TABLE IF EXISTS TEACHER;
DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS PARENT;



CREATE TABLE PARENT (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    phone_number VARCHAR(9) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE STUDENT (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    parent_id BIGINT NOT NULL
);

CREATE TABLE TEACHER (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    phone_number VARCHAR(9) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE COURSE(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(1000),
    number_of_lessons INTEGER,
    min_age INTEGER,
    max_age INTEGER,
    cost INTEGER NOT NULL
);

CREATE TABLE GROUPS(
    id BIGSERIAL PRIMARY KEY,
    course_id BIGINT,
    teacher_id BIGINT,
    start_date DATE NOT NULL,
    expected_end_date DATE,
    rate_per_hour INTEGER
);

CREATE TABLE GROUPS_STUDENT(
    group_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL
);

ALTER TABLE STUDENT
    ADD CONSTRAINT student_parent_id
    FOREIGN KEY (parent_id) REFERENCES parent(id);

ALTER TABLE GROUPS
    ADD CONSTRAINT group_course_id
        FOREIGN KEY (course_id) REFERENCES course(id);

ALTER TABLE GROUPS
    ADD CONSTRAINT group_teacher_id
        FOREIGN KEY (teacher_id) REFERENCES teacher(id);

ALTER TABLE GROUPS_STUDENT
    ADD CONSTRAINT student_group_id
        FOREIGN KEY (group_id) REFERENCES groups(id);

ALTER TABLE GROUPS_STUDENT
    ADD CONSTRAINT group_student_id
        FOREIGN KEY (student_id) REFERENCES student(id);

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  BOOLEAN      NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);

