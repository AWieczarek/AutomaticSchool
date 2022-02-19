package pl.edu.amu.automaticschoolapi.group;

import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.group.dto.GroupDTO;
import pl.edu.amu.automaticschoolapi.group.exceptions.GroupNotFoundException;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups(){ return groupRepository.findAll(); }

    public Group getSingleGroup(long id) {
        return groupRepository.findById(id)
                .orElseThrow();
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
}
