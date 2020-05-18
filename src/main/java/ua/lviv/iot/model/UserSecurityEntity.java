package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "user_security")
public class UserSecurityEntity {
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;
    @Column(name = "login", length = 45)
    private String login;
    @Column(name = "password", length = 45)
    private String password;

    public UserSecurityEntity() {
    }

    public UserSecurityEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserSecurityEntity(Integer userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSecurityEntity{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}