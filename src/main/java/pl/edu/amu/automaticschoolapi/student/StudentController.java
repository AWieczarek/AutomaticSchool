package pl.edu.amu.automaticschoolapi.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.amu.automaticschoolapi.student.dto.StudentDTO;
import pl.edu.amu.automaticschoolapi.teacher.Teacher;
import pl.edu.amu.automaticschoolapi.teacher.dto.TeacherDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor

@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {return studentService.getStudents();}

    @GetMapping("/{id}")
    public Student getSingleStudent(@PathVariable long id) {return studentService.getSingleStudent(id);}

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDTO studentDTO){
        Student addedStudent = studentService.addStudent(studentDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentDTO studentDTO, @PathVariable Long id){
        Student updatedStudent = studentService.updateStudent(studentDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteStudent(@PathVariable @NotNull Long id) {
        Long deletedStudentId = studentService.deleteSingleStudent(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedStudentId);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted all students");
    }

}
