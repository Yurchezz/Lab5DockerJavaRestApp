package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.ComputerGameEntity;
import ua.lviv.iot.repository.ComputerGameRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ComputerGameController {
    @Autowired
    ComputerGameRepository computerGameRepository;

    @GetMapping("/games")
    public List<ComputerGameEntity> getAllComputerGames() {
        return computerGameRepository.findAll();
    }

    @PostMapping("/games")
    public ComputerGameEntity createComputerGame(@Valid @RequestBody ComputerGameEntity computerGameEntity) {
        return computerGameRepository.save(computerGameEntity);
    }

    @GetMapping("/games/{id}")
    public ComputerGameEntity getComputerGameById(@PathVariable(value = "id") Integer Id) {
        return computerGameRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Computer Game", "id", Id));
    }

    @PutMapping("/games/{id}")
    public ComputerGameEntity updateComputerGame(@PathVariable(value = "id") Integer Id,
                                    @Valid @RequestBody ComputerGameEntity computer) {

        ComputerGameEntity computerGameEntity = computerGameRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Computer Game", "id", Id));

        computerGameEntity.setName(computer.getName());
        computerGameEntity.setCpu(computer.getCpu());
        computerGameEntity.setCreatorId(computer.getCreatorId());
        computerGameEntity.setDescription(computer.getDescription());
        computerGameEntity.setGenre(computer.getGenre());
        computerGameEntity.setGpu(computer.getGpu());
        computerGameEntity.setLanguage(computer.getLanguage());
        computerGameEntity.setOperatingSystem(computer.getOperatingSystem());
        computerGameEntity.setRam(computer.getRam());
        computerGameEntity.setPrice(computer.getPrice());

        return computerGameRepository.save(computerGameEntity);
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer Id) {
        ComputerGameEntity computerGameEntity = computerGameRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Computer Game", "id", Id));

        computerGameRepository.delete(computerGameEntity);

        return ResponseEntity.ok().build();
    }
}
