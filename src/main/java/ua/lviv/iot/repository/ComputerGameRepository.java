package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.ComputerGameEntity;

@Repository
public interface ComputerGameRepository extends JpaRepository<ComputerGameEntity, Integer> {
}
