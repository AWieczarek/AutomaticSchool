package pl.edu.amu.automaticschoolapi.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.parent.Parent;
import pl.edu.amu.automaticschoolapi.parent.ParentRepository;
import pl.edu.amu.automaticschoolapi.student.dto.StudentDTO;
import pl.edu.amu.automaticschoolapi.parent.exceptions.ParentNotFoundException;
import pl.edu.amu.automaticschoolapi.student.exceptions.StudentNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;



    public List<Student> getStudents() { return studentRepository.findAll(); }

    public Student getSingleStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public Student addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setDob(studentDTO.getDob());
        student.setEmail(studentDTO.getEmail());
        student.setParent(getParentById(studentDTO));
        return studentRepository.save(student);
    }

    private Parent getParentById(StudentDTO studentDTO) {
        return parentRepository.findById(studentDTO.getParent_id())
                .orElseThrow(() -> new ParentNotFoundException(studentDTO.getParent_id()));
    }

    // Ogarnąć czy da się lepiej updatować pojedyńcze pola

    @Transactional
    public Student updateStudent(StudentDTO studentDTO, Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        student.setName((studentDTO.getName() != null) ? studentDTO.getName() : student.getName());
        student.setSurname((studentDTO.getSurname() != null) ? studentDTO.getSurname() : student.getSurname());
        student.setDob((studentDTO.getDob() != null) ? studentDTO.getDob() : student.getDob());
        student.setEmail((studentDTO.getEmail() != null) ? studentDTO.getEmail() : student.getEmail());
        student.setParent((studentDTO.getParent_id() == null) ? student.getParent() : getParentById(studentDTO));
        return studentRepository.save(student);
    }

    @Transactional
    public Long deleteSingleStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.delete(student);
        return id;
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
