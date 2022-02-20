package pl.edu.amu.automaticschoolapi.teacher.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super(String.format("Could not find teacher with id [%s]", id));
        log.error(String.format("Could not find teacher with id [%s]", id));
    }
}