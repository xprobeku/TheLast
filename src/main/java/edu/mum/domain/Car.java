package edu.mum.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Base64;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String carBrand;

    @NotEmpty
    private String model=null;

//    @NotNull(message = "Please provide year")
    @DateTimeFormat(pattern="yyyy")
    private Integer year;

    @NotNull(message = "Please provide price")
    private Double price;

    @NotNull(message = "Please provide seats number")
    private Integer seats;

    @ManyToOne
    private User owner;

    private String pickUpLocation;

    @NotBlank(message = "Please provide description")
    private String description;

    @NotBlank(message = "Please provide status")
    private String status;

   // @NotNull
    private Boolean isAvailable = true;

    private transient MultipartFile cover;
    //@JsonIgnore
    @Lob
    @Column(name = "cover")
    private byte[] bookCover;


    public byte[] getBookCover() {
        return bookCover;
    }

    public String getUrl() {
        if(this.bookCover != null && this.bookCover.length > 0)
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(this.bookCover);
        return "";
    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Image> images;


    public Car() {
    }

    public Car(String carBrand,
               @NotBlank(message = "Please provide model") String model,
               @NotNull(message = "Please provide year") Integer year,
               @NotNull(message = "Please provide price") Double price,
               @NotNull(message = "Please provide seats number") Integer seats,
               User owner) {
        this.carBrand = carBrand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.seats = seats;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
//
//    public List<Image> getImages() {
//        return images;
//    }
//
//    public void setImages(List<Image> images) {
//        this.images = images;
//    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", seats=" + seats +
                ", owner=" + owner +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", isAvailable=" + isAvailable +
//                ", images=" + images +
                '}';
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }
}
