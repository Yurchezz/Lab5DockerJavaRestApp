package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.CreatorEntity;

@Repository
public interface CreatorRepository extends JpaRepository<CreatorEntity, Integer> {
}
