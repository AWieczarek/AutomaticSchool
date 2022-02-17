package pl.edu.amu.automaticschoolapi.group;

import org.springframework.stereotype.Service;

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
}
