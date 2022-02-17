package pl.edu.amu.automaticschoolapi.group;

import lombok.*;
import pl.edu.amu.automaticschoolapi.LocalDateAttributeConverter;
import pl.edu.amu.automaticschoolapi.course.Course;
import pl.edu.amu.automaticschoolapi.student.Student;
import pl.edu.amu.automaticschoolapi.teacher.Teacher;

import javax.persistence.*;
import org.joda.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    private Set<Student> student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "start_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate startDate;

    @Column(name = "expected_end_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate expectedEndDate;

    private Integer ratePerHour;

    public Group(LocalDate startDate, LocalDate expectedEndDate, Integer ratePerHour) {
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.ratePerHour = ratePerHour;
    }
}