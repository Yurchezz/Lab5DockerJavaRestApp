package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.FinanceStatisticEntity;

@Repository
public interface FinanceStatisticRepository extends JpaRepository<FinanceStatisticEntity, Integer> {
}
