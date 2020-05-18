package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.GameStatisticEntity;

@Repository
public interface GameStatisticRepository extends JpaRepository<GameStatisticEntity, Integer> {
}