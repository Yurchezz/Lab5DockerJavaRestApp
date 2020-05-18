package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.FinanceStatisticEntity;
import ua.lviv.iot.repository.FinanceStatisticRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FinanceStatisticController {
    @Autowired
    FinanceStatisticRepository financeStatisticRepository;

    @GetMapping("/finance")
    public List<FinanceStatisticEntity> getAllFinanceStatistics() {
        return financeStatisticRepository.findAll();
    }

    @PostMapping("/finance")
    public FinanceStatisticEntity createFinanceStatistic(@Valid @RequestBody FinanceStatisticEntity creatorEntity) {
        return financeStatisticRepository.save(creatorEntity);
    }

    @GetMapping("/finance/{id}")
    public FinanceStatisticEntity getFinanceStatisticById(@PathVariable(value = "id") Integer Id) {
        return financeStatisticRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Creator", "id", Id));
    }

    @PutMapping("/finance/{id}")
    public FinanceStatisticEntity updateFinanceStatistic(@PathVariable(value = "id") Integer Id,
                                    @Valid @RequestBody FinanceStatisticEntity finance) {

        FinanceStatisticEntity financeStatisticEntity = financeStatisticRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Creator", "id", Id));

        finance.setUserId(finance.getUserId());
        finance.setBalance(finance.getBalance());
        finance.setDate(finance.getDate());

        return financeStatisticRepository.save(financeStatisticEntity);
    }

    @DeleteMapping("/finance/{id}")
    public ResponseEntity<?> deleteFinanceStatistic(@PathVariable(value = "id") Integer Id) {
        FinanceStatisticEntity creatorEntity = financeStatisticRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Creator", "id", Id));

        financeStatisticRepository.delete(creatorEntity);

        return ResponseEntity.ok().build();
    }
}
