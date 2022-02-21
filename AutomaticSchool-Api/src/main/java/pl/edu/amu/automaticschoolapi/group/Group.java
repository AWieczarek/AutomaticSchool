package pl.edu.amu.automaticschoolapi.group;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "course_id",
            referencedColumnName = "id")
    private Course course;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JsonIgnoreProperties("studentsInGroups")
    private Set<Student> student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",
            referencedColumnName = "id")
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

    public void addStudent(Student newStudent){
        student.add(newStudent);
    }
}