package pl.edu.amu.automaticschoolapi.teacher;

import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.teacher.dto.TeacherDTO;
import pl.edu.amu.automaticschoolapi.teacher.exceptions.TeacherNotFoundException;

import javax.transaction.Transactional;
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

    @Transactional
    public Teacher addTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setSurname(teacherDTO.getSurname());
        teacher.setDob(teacherDTO.getDob());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());
        teacher.setEmail(teacherDTO.getEmail());
        return teacherRepository.save(teacher);
    }

    // Ogarnąć czy da się lepiej updatować pojedyńcze pola

    @Transactional
    public Teacher updateTeacher(TeacherDTO teacherDTO, Long id) {
        Teacher teacher = teacherRepository.findById(id)
                        .orElseThrow(() -> new TeacherNotFoundException(id));
        teacher.setName((teacherDTO.getName() != null) ? teacherDTO.getName() : teacher.getName());
        teacher.setSurname((teacherDTO.getSurname() != null) ? teacherDTO.getSurname() : teacher.getSurname());
        teacher.setDob((teacherDTO.getDob() != null) ? teacherDTO.getDob() : teacher.getDob());
        teacher.setPhoneNumber((teacherDTO.getPhoneNumber() != null) ? teacherDTO.getPhoneNumber() : teacher.getPhoneNumber());
        teacher.setEmail((teacherDTO.getEmail() != null) ? teacherDTO.getEmail() : teacher.getEmail());
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Long deleteSingleTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        teacherRepository.delete(teacher);
        return id;
    }

    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }
}
