package pl.edu.amu.automaticschoolapi.parent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> getParents(){ return parentRepository.findAll(); }

    public Parent getSingleParent(long id) {
        return parentRepository.findById(id)
                .orElseThrow();
    }
}
