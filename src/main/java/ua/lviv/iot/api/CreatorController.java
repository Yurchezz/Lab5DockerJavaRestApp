package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.CreatorEntity;
import ua.lviv.iot.repository.CreatorRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CreatorController {

    @Autowired
    CreatorRepository creatorRepository;

    @GetMapping("/creators")
    public List<CreatorEntity> getAllNotes() {
        return creatorRepository.findAll();
    }

    @PostMapping("/creators")
    public CreatorEntity createNote(@Valid @RequestBody CreatorEntity creatorEntity) {
        return creatorRepository.save(creatorEntity);
    }

    @GetMapping("/creators/{id}")
    public CreatorEntity getNoteById(@PathVariable(value = "id") Integer noteId) {
        return creatorRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Creator", "id", noteId));
    }

    @PutMapping("/creators/{id}")
    public CreatorEntity updateNote(@PathVariable(value = "id") Integer noteId,
                           @Valid @RequestBody CreatorEntity noteDetails) {

        CreatorEntity creatorEntity = creatorRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Creator", "id", noteId));

        creatorEntity.setName(noteDetails.getName());

        return creatorRepository.save(creatorEntity);
    }

    @DeleteMapping("/creators/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer Id) {
        CreatorEntity creatorEntity = creatorRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Creator", "id", Id));

        creatorRepository.delete(creatorEntity);

        return ResponseEntity.ok().build();
    }
}
