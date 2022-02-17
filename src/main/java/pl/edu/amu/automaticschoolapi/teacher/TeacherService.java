package pl.edu.amu.automaticschoolapi.teacher;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {return teacherRepository.findAll();}

    public Teacher getSingleTeacher(long id) {
        return teacherRepository.findById(id)
                .orElseThrow();
    }
}
