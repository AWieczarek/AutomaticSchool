package pl.edu.amu.automaticschoolapi.validation;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private final Integer code;
    private final String message;
}
