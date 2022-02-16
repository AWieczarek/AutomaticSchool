package pl.edu.amu.automaticschoolapi.group.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.amu.automaticschoolapi.course.Course;
import pl.edu.amu.automaticschoolapi.validation.CustomIntegerSerializer;
import pl.edu.amu.automaticschoolapi.student.Student;
import pl.edu.amu.automaticschoolapi.teacher.Teacher;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    @NotNull
    private Course course;

    @NotNull
    private Set<Student> student;

    @NotNull
    private Teacher teacher;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate expectedEndDate;

    @JsonDeserialize(using = CustomIntegerSerializer.class)
    private Integer ratePerHour;

}