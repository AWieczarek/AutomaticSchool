package pl.edu.amu.automaticschoolapi.parent;


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
@RequestMapping("api/parents")
public class ParentController {

    private final ParentService parentService;

    @GetMapping
    public List<Parent> getParents(){return parentService.getParents();}

    @GetMapping("/{id}")
    public Parent getSingleParent(@PathVariable long id){ return parentService.getSingleParent(id);}
}
