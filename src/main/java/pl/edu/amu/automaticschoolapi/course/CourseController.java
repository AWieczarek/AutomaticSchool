package pl.edu.amu.automaticschoolapi.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourses(){return courseService.getCourses();}

    @GetMapping("/{id}")
    public Course getSingleCourse(@PathVariable long id){return courseService.getSingleCourse(id);}
}
