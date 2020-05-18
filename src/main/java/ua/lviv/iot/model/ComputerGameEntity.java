package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "computer_game")
public class ComputerGameEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "creator_id")
    private Integer creatorId;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "description", length = 45)
    private String description;
    @Column(name = "price")
    private Integer price;
    @Column(name = "cpu", length = 45)
    private String cpu;
    @Column(name = "gpu")
    private Integer gpu;
    @Column(name = "ram")
    private Integer ram;
    @Column(name = "operating_system", length = 45)
    private String operatingSystem;
    @Column(name = "genre", length = 45)
    private String genre;
    @Column(name = "language", length = 45)
    private String language;

    public ComputerGameEntity() {
    }

    public ComputerGameEntity(Integer creatorId, String name, String description, Integer price, String cpu,
                              Integer gpu, Integer ram, String operatingSystem, String genre, String language) {
        this.creatorId = creatorId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.genre = genre;
        this.language = language;
    }

    public ComputerGameEntity(Integer id, Integer creatorId, String name, String description, Integer price, String cpu,
                              Integer gpu, Integer ram, String operatingSystem, String genre, String language) {
        this.id = id;
        this.creatorId = creatorId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.genre = genre;
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getGpu() {
        return gpu;
    }

    public void setGpu(Integer gpu) {
        this.gpu = gpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ComputerGameEntity{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cpu='" + cpu + '\'' +
                ", gpu=" + gpu +
                ", ram=" + ram +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}