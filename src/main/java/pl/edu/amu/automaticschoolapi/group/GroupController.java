package pl.edu.amu.automaticschoolapi.group;

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
@RequestMapping("api/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<Group> getGroups(){return groupService.getGroups();}

    @GetMapping("/{id}")
    public Group getSingleGroup(@PathVariable long id){return groupService.getSingleGroup(id);}
}
