package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.UserReviewEntity;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReviewEntity, Integer> {
}
