package pl.edu.amu.automaticschoolapi.parent;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.amu.automaticschoolapi.parent.dto.ParentDTO;
import pl.edu.amu.automaticschoolapi.student.Student;
import pl.edu.amu.automaticschoolapi.student.dto.StudentDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/parents")
public class ParentController {

    private final ParentService parentService;

    @GetMapping
    public List<Parent> getParents(){return parentService.getParents();}

    @GetMapping("/{id}")
    public Parent getSingleParent(@PathVariable long id){ return parentService.getSingleParent(id);}

    @PostMapping
    public ResponseEntity<Parent> addParent(@Valid @RequestBody ParentDTO parentDTO){
        Parent addedParent = parentService.addParent(parentDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedParent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@Valid @RequestBody ParentDTO parentDTO, @PathVariable Long id){
        Parent updatedParent = parentService.updateParent(parentDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedParent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteParent(@PathVariable @NotNull Long id) {
        Long deletedParentId = parentService.deleteSingleParent(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedParentId);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllParents() {
        parentService.deleteAllParents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted all parents");
    }
}
