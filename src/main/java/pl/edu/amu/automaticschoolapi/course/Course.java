package pl.edu.amu.automaticschoolapi.course;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.edu.amu.automaticschoolapi.group.Group;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "course")
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

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Group> groups;

    public Course(String name, String description, int minAge, int maxAge, int numberOfLessons, int cost) {
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.numberOfLessons = numberOfLessons;
        this.cost = cost;
    }
}
