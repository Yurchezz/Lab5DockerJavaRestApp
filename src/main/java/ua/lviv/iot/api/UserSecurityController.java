package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.UserSecurityEntity;
import ua.lviv.iot.repository.UserSecurityRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserSecurityController {
    @Autowired
    UserSecurityRepository userSecurityRepository;

    @GetMapping("/userSecurity")
    public List<UserSecurityEntity> getAllUserSecurity() {
        return userSecurityRepository.findAll();
    }

    @PostMapping("/userSecurity")
    public UserSecurityEntity createUserSecurity(@Valid @RequestBody UserSecurityEntity userSecurityEntity) {
        return userSecurityRepository.save(userSecurityEntity);
    }

    @GetMapping("/userSecurity/{id}")
    public UserSecurityEntity getUserSecurityById(@PathVariable(value = "id") Integer Id) {
        return userSecurityRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User Security", "id", Id));
    }

    @PutMapping("/userSecurity/{id}")
    public UserSecurityEntity updateUserSecurity(@PathVariable(value = "id") Integer Id,
                                                 @Valid @RequestBody UserSecurityEntity userSecurity) {

        UserSecurityEntity userSecurityEntity = userSecurityRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User Security", "id", Id));

        userSecurityEntity.setUserId(userSecurity.getUserId());
        userSecurityEntity.setLogin(userSecurity.getLogin());
        userSecurityEntity.setPassword(userSecurity.getPassword());

        return userSecurityRepository.save(userSecurity);
    }

    @DeleteMapping("/userSecurity/{id}")
    public ResponseEntity<?> deleteUserSecurity(@PathVariable(value = "id") Integer Id) {
        UserSecurityEntity userSecurityEntity = userSecurityRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User Security", "id", Id));

        userSecurityRepository.delete(userSecurityEntity);

        return ResponseEntity.ok().build();
    }
}
