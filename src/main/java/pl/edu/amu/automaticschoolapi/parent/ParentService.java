package pl.edu.amu.automaticschoolapi.parent;

import org.springframework.stereotype.Service;
import pl.edu.amu.automaticschoolapi.parent.dto.ParentDTO;
import pl.edu.amu.automaticschoolapi.parent.exceptions.ParentNotFoundException;
import pl.edu.amu.automaticschoolapi.student.exceptions.StudentNotFoundException;

import javax.transaction.Transactional;
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

    @Transactional
    public Parent addParent(ParentDTO parentDTO) {
        Parent parent = new Parent();
        parent.setName(parentDTO.getName());
        parent.setSurname(parentDTO.getSurname());
        parent.setPhoneNumber(parentDTO.getPhoneNumber());
        parent.setEmail(parentDTO.getEmail());
        return parentRepository.save(parent);
    }

    // Ogarnąć czy da się lepiej updatować pojedyńcze pola

    @Transactional
    public Parent updateParent(ParentDTO parentDTO, Long id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new ParentNotFoundException(id));
        parent.setName((parentDTO.getName() != null) ? parentDTO.getName() : parent.getName());
        parent.setSurname((parentDTO.getSurname() != null) ? parentDTO.getSurname() : parent.getSurname());
        parent.setPhoneNumber((parentDTO.getPhoneNumber() != null) ? parentDTO.getPhoneNumber() : parent.getPhoneNumber());
        parent.setEmail((parentDTO.getEmail() != null) ? parentDTO.getEmail() : parent.getEmail());
        return parentRepository.save(parent);
    }

    @Transactional
    public Long deleteSingleParent(Long id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new ParentNotFoundException(id));
        parentRepository.delete(parent);
        return id;
    }

    public void deleteAllParents() {
        parentRepository.deleteAll();
    }
}
