package pl.edu.amu.automaticschoolapi.course.validation;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private final Integer code;
    private final String message;
}
