package pl.edu.amu.automaticschoolapi.course.exception;

public class TypeMismatchException extends RuntimeException {
    public TypeMismatchException(String errorMessage) {
        super(errorMessage);
    }
}
