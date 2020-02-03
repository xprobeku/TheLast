package edu.mum.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;

    private RentalStatus status;

    private String declineDesc;

    private LocalDateTime createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate approvalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate declinedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    public Rental() {
    }

    public Rental(Car car, User user, RentalStatus status, String declineDesc, LocalDateTime createDate, LocalDate approvalDate, LocalDate declinedDate, LocalDate pickUpDate, LocalDate expectedDate, LocalDate returnDate) {
        this.car = car;
        this.user = user;
        this.status = status;
        this.declineDesc = declineDesc;
        this.createDate = createDate;
        this.approvalDate = approvalDate;
        this.declinedDate = declinedDate;
        this.pickUpDate = pickUpDate;
        this.expectedDate = expectedDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public String getDeclineDesc() {
        return declineDesc;
    }

    public void setDeclineDesc(String declineDesc) {
        this.declineDesc = declineDesc;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public LocalDate getDeclinedDate() {
        return declinedDate;
    }

    public void setDeclinedDate(LocalDate declinedDate) {
        this.declinedDate = declinedDate;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", car=" + car +
                ", user=" + user +
                ", status=" + status +
                ", declineDesc='" + declineDesc + '\'' +
                ", createDate=" + createDate +
                ", approvalDate=" + approvalDate +
                ", declinedDate=" + declinedDate +
                ", pickUpDate=" + pickUpDate +
                ", expectedDate=" + expectedDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
