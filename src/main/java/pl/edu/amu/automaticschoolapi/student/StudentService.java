package pl.edu.amu.automaticschoolapi.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() { return studentRepository.findAll(); }

    public Student getSingleStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow();
    }
}
