package pl.edu.amu.automaticschoolapi.group;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.course.Course;
import pl.edu.amu.automaticschoolapi.course.CourseRepository;
import pl.edu.amu.automaticschoolapi.course.exception.CourseNotFoundException;
import pl.edu.amu.automaticschoolapi.group.dto.GroupDTO;
import pl.edu.amu.automaticschoolapi.group.exceptions.GroupNotFoundException;
import pl.edu.amu.automaticschoolapi.teacher.Teacher;
import pl.edu.amu.automaticschoolapi.teacher.TeacherRepository;
import pl.edu.amu.automaticschoolapi.teacher.exceptions.TeacherNotFoundException;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Group> getGroups(){ return groupRepository.findAll(); }

    public Group getSingleGroup(long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
    }

    @Transactional
    public Group addGroup(GroupDTO groupDTO) {
        Group group = new Group();
        group.setStartDate(groupDTO.getStartDate());
        group.setExpectedEndDate(groupDTO.getExpectedEndDate());
        group.setRatePerHour(groupDTO.getRatePerHour());
        return groupRepository.save(group);
    }

    // Ogarnąć czy da się lepiej updatować pojedyńcze pola

    @Transactional
    public Group updateGroup(GroupDTO groupDTO, Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
        group.setStartDate((groupDTO.getStartDate() != null) ? groupDTO.getStartDate() : group.getStartDate() );
        group.setExpectedEndDate((groupDTO.getExpectedEndDate() != null) ? groupDTO.getExpectedEndDate() : group.getExpectedEndDate() );
        group.setRatePerHour((groupDTO.getRatePerHour() != null) ? groupDTO.getRatePerHour() : group.getRatePerHour() );
        return groupRepository.save(group);
    }

    @Transactional
    public Long deleteSingleGroup(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
        groupRepository.delete(group);
        return id;
    }

    public void deleteAllGroups() {
        groupRepository.deleteAll();
    }

    @Transactional
    public Group assignCourseToGroup(Long groupId, Long courseId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException(groupId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));

        group.setCourse(course);
        return groupRepository.save(group);
    }

    @Transactional
    public Group assignTeacherToGroup(Long groupId, Long teacherId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException(groupId));
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(teacherId));

        group.setTeacher(teacher);
        return groupRepository.save(group);
    }
}
