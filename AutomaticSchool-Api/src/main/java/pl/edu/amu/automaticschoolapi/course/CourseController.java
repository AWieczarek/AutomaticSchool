package pl.edu.amu.automaticschoolapi.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.amu.automaticschoolapi.course.dto.CourseDTO;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.group.dto.GroupDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @PostMapping
    public ResponseEntity<Course> addCourse(@Valid @RequestBody CourseDTO courseDTO){
        Course addedCourse = courseService.addCourse(courseDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateGroup(@Valid @RequestBody CourseDTO courseDTO, @PathVariable Long id){
        Course updatedCourse = courseService.updateCourse(courseDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable @NotNull Long id) {
        Long deletedCourseId = courseService.deleteSingleCourse(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedCourseId);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCourses() {
        courseService.deleteAllCourses();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted all courses");
    }
}
