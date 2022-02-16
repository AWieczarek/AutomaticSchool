package pl.edu.amu.automaticschoolapi.course;

import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.group.Group;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){ return courseRepository.findAll(); }
}
