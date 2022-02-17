package pl.edu.amu.automaticschoolapi.parent;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.edu.amu.automaticschoolapi.student.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Student> students;

    public Parent(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
