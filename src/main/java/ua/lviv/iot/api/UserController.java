package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.UserEntity;
import ua.lviv.iot.model.UserSecurityEntity;
import ua.lviv.iot.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable(value = "id") Integer Id) {
        return userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
    }

    @PutMapping("/users/{id}")
    public UserEntity updateUser(@PathVariable(value = "id") Integer Id,
                                    @Valid @RequestBody UserEntity user) {

        UserEntity userEntity = userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));

        userEntity.setNickName(user.getNickName());
        userEntity.setDescription(user.getDescription());
        userEntity.setCountry(user.getCountry());

        return userRepository.save(userEntity);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer Id) {
        UserEntity creatorEntity = userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));

        userRepository.delete(creatorEntity);

        return ResponseEntity.ok().build();
    }
}
