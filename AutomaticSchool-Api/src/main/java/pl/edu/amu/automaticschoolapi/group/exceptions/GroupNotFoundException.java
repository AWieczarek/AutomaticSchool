package pl.edu.amu.automaticschoolapi.group.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(Long id) {
        super(String.format("Could not find group with id [%s]", id));
        log.error(String.format("Could not find group with id [%s]", id));
    }
}
