package pl.edu.amu.automaticschoolapi.course;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import pl.edu.amu.automaticschoolapi.course.validation.CustomIntegerSerializer;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.student.Student;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private int minAge;

    private int maxAge;

    private int numberOfLessons;

    private int cost;

    @OneToMany(mappedBy = "course")
    private Set<Group> groups;

}