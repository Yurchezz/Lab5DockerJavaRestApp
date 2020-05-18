package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.UserReviewEntity;
import ua.lviv.iot.repository.UserReviewRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserReviewController {
    @Autowired
    UserReviewRepository userReviewRepository;

    @GetMapping("/userReview")
    public List<UserReviewEntity> getAllUserReview() {
        return userReviewRepository.findAll();
    }

    @PostMapping("/userReview")
    public UserReviewEntity createUserReview(@Valid @RequestBody UserReviewEntity userReviewEntity) {
        return userReviewRepository.save(userReviewEntity);
    }

    @GetMapping("/userReview/{id}")
    public UserReviewEntity getUserReviewById(@PathVariable(value = "id") Integer Id) {
        return userReviewRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User Review", "id", Id));
    }

    @PutMapping("/userReview/{id}")
    public UserReviewEntity updateUserReview(@PathVariable(value = "id") Integer Id,
                                                 @Valid @RequestBody UserReviewEntity userReview) {

        UserReviewEntity userReviewEntity = userReviewRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User Review", "id", Id));

        userReviewEntity.setComputer_games_id(userReview.getComputer_games_id());
        userReviewEntity.setUserId(userReview.getUserId());
        userReviewEntity.setReview(userReview.getReview());

        return userReviewRepository.save(userReview);
    }

    @DeleteMapping("/userReview/{id}")
    public ResponseEntity<?> deleteUserReview(@PathVariable(value = "id") Integer Id) {
        UserReviewEntity userReviewEntity = userReviewRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User Review", "id", Id));

        userReviewRepository.delete(userReviewEntity);

        return ResponseEntity.ok().build();
    }
}
