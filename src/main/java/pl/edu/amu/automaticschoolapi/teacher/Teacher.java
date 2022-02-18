package pl.edu.amu.automaticschoolapi.teacher;

import lombok.*;
import pl.edu.amu.automaticschoolapi.LocalDateAttributeConverter;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.student.Student;

import javax.persistence.*;
import org.joda.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    @Column(name = "dob", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dob;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Group> groups;

    public Teacher(String name, String surname, LocalDate dob, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}