package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "finance_statistic")
public class FinanceStatisticEntity {
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;
    @Column(name = "date")
    private Date date;
    @Column(name = "balance")
    private Integer balance;

    public FinanceStatisticEntity() {
    }

    public FinanceStatisticEntity(Date date, Integer balance) {
        this.date = date;
        this.balance = balance;
    }

    public FinanceStatisticEntity(Integer userId, Date date, Integer balance) {
        this.userId = userId;
        this.date = date;
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "FinanceStatisticEntity{" +
                "userId=" + userId +
                ", date=" + date +
                ", balance=" + balance +
                '}';
    }
}
