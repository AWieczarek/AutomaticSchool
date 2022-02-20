package pl.edu.amu.automaticschoolapi.teacher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.amu.automaticschoolapi.teacher.dto.TeacherDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers(){ return teacherService.getTeachers();}

    @GetMapping("/{id}")
    public Teacher getSingleTeacher(@PathVariable long id){ return teacherService.getSingleTeacher(id);}

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@Valid @RequestBody TeacherDTO teacherDTO){
        Teacher addedTeacher = teacherService.addTeacher(teacherDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody TeacherDTO teacherDTO, @PathVariable Long id){
        Teacher addedTeacher = teacherService.updateTeacher(teacherDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTeacher(@PathVariable @NotNull Long id) {
        Long deletedTeacherId = teacherService.deleteSingleTeacher(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedTeacherId);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllTeachers() {
        teacherService.deleteAllTeachers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted all teachers");
    }
}
