package pl.edu.amu.automaticschoolapi.teacher;

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
@RequestMapping("api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers(){ return teacherService.getTeachers();}

    @GetMapping("/{id}")
    public Teacher getSingleTeacher(@PathVariable long id){ return teacherService.getSingleTeacher(id);}
}
