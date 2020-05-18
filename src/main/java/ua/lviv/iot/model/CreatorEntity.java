package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "creator")
public class CreatorEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;

    public CreatorEntity() {
    }

    public CreatorEntity(String name) {
        this.name = name;
    }

    public CreatorEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreatorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}