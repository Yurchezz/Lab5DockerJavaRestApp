package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "wish_list")
public class  WishListEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "computer_games_id")
    private Integer computerGamesId;

    public WishListEntity() {
    }

    public WishListEntity(Integer userId, Integer computerGamesId) {
        this.userId = userId;
        this.computerGamesId = computerGamesId;
    }

    public WishListEntity(Integer id, Integer userId, Integer computerGamesId) {
        this.id = id;
        this.userId = userId;
        this.computerGamesId = computerGamesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getComputerGamesId() {
        return computerGamesId;
    }

    public void setComputerGamesId(Integer computerGamesId) {
        this.computerGamesId = computerGamesId;
    }

    @Override
    public String toString() {
        return "WishListEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", computerGamesId=" + computerGamesId +
                '}';
    }
}