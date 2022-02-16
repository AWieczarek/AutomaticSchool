package pl.edu.amu.automaticschoolapi.course.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.amu.automaticschoolapi.course.validation.CustomIntegerSerializer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @Min(value = 5, message = "Age must be greater than 6.")
    @Max(value = 100, message = "Age must be less than 100.")
    @JsonDeserialize(using = CustomIntegerSerializer.class)
    private int minAge;

    @Min(value = 5, message = "Age must be greater than 6.")
    @Max(value = 20, message = "Age must be less than 100.")
    @JsonDeserialize(using = CustomIntegerSerializer.class)
    private int maxAge;

    @Min(value = 0, message = "Age must be greater than 0.")
    @JsonDeserialize(using = CustomIntegerSerializer.class)
    private int numberOfLessons;

    @Min(value = 0, message = "Age must be greater than 0.")
    @JsonDeserialize(using = CustomIntegerSerializer.class)
    private int cost;

}