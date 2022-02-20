package pl.edu.amu.automaticschoolapi.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.group.GroupRepository;
import pl.edu.amu.automaticschoolapi.group.exceptions.GroupNotFoundException;
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
    private final GroupRepository groupRepository;

    public List<Student> getStudents() { return studentRepository.findAll(); }

    public Student getSingleStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Transactional
    public Student addStudent(StudentDTO studentDTO, Long id) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setDob(studentDTO.getDob());
        student.setEmail(studentDTO.getEmail());
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new ParentNotFoundException(id));
        student.setParent(parent);
        parent.addStudent(student);
        return studentRepository.save(student);
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

    @Transactional
    public Student assignStudentToGroup(Long studentId, Long groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException(groupId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        group.addStudent(student);
        return student;
    }
}
