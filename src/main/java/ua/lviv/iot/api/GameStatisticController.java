package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.GameStatisticEntity;
import ua.lviv.iot.repository.GameStatisticRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GameStatisticController {
    @Autowired
    GameStatisticRepository gameStatisticRepository;

    @GetMapping("/gameStat")
    public List<GameStatisticEntity> getAllGameStatistics() {
        return gameStatisticRepository.findAll();
    }

    @PostMapping("/gameStat")
    public GameStatisticEntity createGameStatistic(@Valid @RequestBody GameStatisticEntity gameStatisticEntity) {
        return gameStatisticRepository.save(gameStatisticEntity);
    }

    @GetMapping("/gameStat/{id}")
    public GameStatisticEntity getGameStatisticById(@PathVariable(value = "id") Integer Id) {
        return gameStatisticRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Game Statistic", "id", Id));
    }

    @PutMapping("/gameStat/{id}")
    public GameStatisticEntity updateGameStatistic(@PathVariable(value = "id") Integer Id,
                                                 @Valid @RequestBody GameStatisticEntity gameStat) {

        GameStatisticEntity gameStatisticEntity = gameStatisticRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Game Statistic", "id", Id));

        gameStatisticEntity.setUserId(gameStat.getUserId());
        gameStatisticEntity.setHour(gameStat.getHour());
        gameStatisticEntity.setAchivement(gameStat.getAchivement());

        return gameStatisticRepository.save(gameStatisticEntity);
    }

    @DeleteMapping("/gameStat/{id}")
    public ResponseEntity<?> deleteGameStatistic(@PathVariable(value = "id") Integer Id) {
        GameStatisticEntity gameStatisticEntity = gameStatisticRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Game Statistic", "id", Id));

        gameStatisticRepository.delete(gameStatisticEntity);

        return ResponseEntity.ok().build();
    }
}
