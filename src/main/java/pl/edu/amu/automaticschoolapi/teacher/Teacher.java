package pl.edu.amu.automaticschoolapi.teacher;

import lombok.*;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.student.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private LocalDate dob;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "teacher")
    private Set<Group> groups;
}