package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "user_review")
public class UserReviewEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer Id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "computer_games_id")
    private Integer computer_games_id;
    @Column(name = "review")
    private String review;

    public UserReviewEntity() {
    }

    public UserReviewEntity(Integer userId, Integer computer_games_id, String review) {
        this.userId = userId;
        this.computer_games_id = computer_games_id;
        this.review = review;
    }

    public UserReviewEntity(Integer id, Integer userId, Integer computer_games_id, String review) {
        Id = id;
        this.userId = userId;
        this.computer_games_id = computer_games_id;
        this.review = review;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getComputer_games_id() {
        return computer_games_id;
    }

    public void setComputer_games_id(Integer computer_games_id) {
        this.computer_games_id = computer_games_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "UserReviewEntity{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", computer_games_id=" + computer_games_id +
                ", review='" + review + '\'' +
                '}';
    }
}