package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "nickname", length = 45)
    private String nickName;
    @Column(name = "description", length = 45)
    private String description;
    @Column(name = "country", length = 45)
    private String country;

    public UserEntity() {
    }

    public UserEntity(String nickName, String description, String country) {
        this.nickName = nickName;
        this.description = description;
        this.country = country;
    }

    public UserEntity(Integer id, String nickName, String description, String country) {
        this.id = id;
        this.nickName = nickName;
        this.description = description;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}