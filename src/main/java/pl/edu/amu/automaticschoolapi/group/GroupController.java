package pl.edu.amu.automaticschoolapi.group;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.amu.automaticschoolapi.group.dto.GroupDTO;
import pl.edu.amu.automaticschoolapi.parent.Parent;
import pl.edu.amu.automaticschoolapi.parent.dto.ParentDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @PostMapping
    public ResponseEntity<Group> addGroup(@Valid @RequestBody GroupDTO groupDTO){
        Group addedGroup = groupService.addGroup(groupDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@Valid @RequestBody GroupDTO groupDTO, @PathVariable Long id){
        Group updatedGroup = groupService.updateGroup(groupDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteGroup(@PathVariable @NotNull Long id) {
        Long deletedGroupId = groupService.deleteSingleGroup(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedGroupId);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllGroups() {
        groupService.deleteAllGroups();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted all groups");
    }
}
