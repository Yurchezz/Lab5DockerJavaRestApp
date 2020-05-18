package ua.lviv.iot.model;

import javax.persistence.*;


@Entity
@Table(name = "game_statistic")
public class GameStatisticEntity {
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;
    @Column(name = "hour")
    private Integer hour;
    @Column(name = "achivement", length = 45)
    private String achivement;

    public GameStatisticEntity() {
    }

    public GameStatisticEntity(Integer hour, String achivement) {
        this.hour = hour;
        this.achivement = achivement;
    }

    public GameStatisticEntity(Integer userId, Integer hour, String achivement) {
        this.userId = userId;
        this.hour = hour;
        this.achivement = achivement;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getAchivement() {
        return achivement;
    }

    public void setAchivement(String achivement) {
        this.achivement = achivement;
    }

    @Override
    public String toString() {
        return "GameStatisticEntity{" +
                "userId=" + userId +
                ", hour=" + hour +
                ", achivement='" + achivement + '\'' +
                '}';
    }
}