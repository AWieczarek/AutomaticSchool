package pl.edu.amu.automaticschoolapi.student.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super(String.format("Could not find student with id [%s]", id));
        log.error(String.format("Could not find student with id [%s]", id));
    }
}
