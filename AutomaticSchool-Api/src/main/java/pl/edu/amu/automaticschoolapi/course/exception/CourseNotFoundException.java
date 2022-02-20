package pl.edu.amu.automaticschoolapi.course.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super(String.format("Could not find course with id [%s]", id));
        log.error(String.format("Could not find course with id [%s]", id));
    }
}
