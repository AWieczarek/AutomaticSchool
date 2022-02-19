package pl.edu.amu.automaticschoolapi.parent.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParentNotFoundException extends RuntimeException {
    public ParentNotFoundException(Long id) {
        super(String.format("Could not find parent with id [%s]", id));
        log.error(String.format("Could not find parent with id [%s]", id));
    }
}
