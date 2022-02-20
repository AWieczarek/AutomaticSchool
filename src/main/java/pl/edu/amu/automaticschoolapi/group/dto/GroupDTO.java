package pl.edu.amu.automaticschoolapi.group.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

import org.joda.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private Course course;

    private Teacher teacher;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate expectedEndDate;

    private Integer ratePerHour;

}