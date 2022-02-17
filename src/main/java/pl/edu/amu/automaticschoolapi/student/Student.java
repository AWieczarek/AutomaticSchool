package pl.edu.amu.automaticschoolapi.student;

import lombok.*;
import pl.edu.amu.automaticschoolapi.LocalDateAttributeConverter;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.parent.Parent;

import javax.persistence.*;
import org.joda.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    @Column(name = "dob", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dob;

    private String email;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToMany
    @JoinTable(
            name = "student_in_groups",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    Set<Group> studentsGroups;

    public Student(String name, String surname, LocalDate dob, String email) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.email = email;
    }
}
