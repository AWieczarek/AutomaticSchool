package pl.edu.amu.automaticschoolapi.course;

import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.course.dto.CourseDTO;
import pl.edu.amu.automaticschoolapi.course.exception.CourseNotFoundException;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.group.exceptions.GroupNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){ return courseRepository.findAll(); }

    public Course getSingleCourse(long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Transactional
    public Course addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setNumberOfLessons(courseDTO.getNumberOfLessons());
        course.setMinAge(courseDTO.getMinAge());
        course.setMaxAge(courseDTO.getMaxAge());
        course.setCost(courseDTO.getCost());
        return courseRepository.save(course);
    }

    // Ogarnąć czy da się lepiej updatować pojedyńcze pola

    @Transactional
    public Course updateCourse(CourseDTO courseDTO, Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        course.setName((courseDTO.getName() != null) ? courseDTO.getName() : course.getName());
        course.setDescription((courseDTO.getDescription() != null) ? courseDTO.getDescription() : course.getDescription());
        course.setNumberOfLessons((courseDTO.getNumberOfLessons() != 0) ? courseDTO.getNumberOfLessons() : course.getNumberOfLessons());
        course.setMinAge((courseDTO.getMinAge() != 0) ? courseDTO.getMinAge() : course.getMinAge());
        course.setMaxAge((courseDTO.getMaxAge() != 0) ? courseDTO.getMaxAge() : course.getMaxAge());
        course.setCost((courseDTO.getCost() != 0) ? courseDTO.getCost() : course.getCost());
        return courseRepository.save(course);
    }

    @Transactional
    public Long deleteSingleCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        courseRepository.delete(course);
        return id;
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
