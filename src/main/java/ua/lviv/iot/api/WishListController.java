package ua.lviv.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exception.ResourceNotFoundException;
import ua.lviv.iot.model.WishListEntity;
import ua.lviv.iot.repository.WishListRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WishListController {
    @Autowired
    WishListRepository wishListRepository;

    @GetMapping("/wishList")
    public List<WishListEntity> getAllWishList() {
        return wishListRepository.findAll();
    }

    @PostMapping("/wishList")
    public WishListEntity createWishList(@Valid @RequestBody WishListEntity wishListEntity) {
        return wishListRepository.save(wishListEntity);
    }

    @GetMapping("/wishList/{id}")
    public WishListEntity getWishListById(@PathVariable(value = "id") Integer Id) {
        return wishListRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish List", "id", Id));
    }

    @PutMapping("/wishList/{id}")
    public WishListEntity updateWishListEntity(@PathVariable(value = "id") Integer Id,
                                                   @Valid @RequestBody WishListEntity wishList) {

        WishListEntity wishListEntity = wishListRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish List", "id", Id));

        wishListEntity.setUserId(wishList.getUserId());
        wishListEntity.setComputerGamesId(wishList.getComputerGamesId());

        return wishListRepository.save(wishListEntity);
    }

    @DeleteMapping("/wishList/{id}")
    public ResponseEntity<?> deleteWishList(@PathVariable(value = "id") Integer Id) {
        WishListEntity gameStatisticEntity = wishListRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish List", "id", Id));

        wishListRepository.delete(gameStatisticEntity);

        return ResponseEntity.ok().build();
    }
}
