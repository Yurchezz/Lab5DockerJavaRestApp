package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.WishListEntity;

@Repository
public interface WishListRepository extends JpaRepository<WishListEntity, Integer> {
}
