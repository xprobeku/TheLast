package edu.mum.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date approvalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date declinedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickUpDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    public Rental() {
    }

    public Rental(Car car, User user, RentalStatus status, String declineDesc, Date createDate, Date approvalDate, Date declinedDate, Date pickUpDate, Date expectedDate, Date returnDate) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getDeclinedDate() {
        return declinedDate;
    }

    public void setDeclinedDate(Date declinedDate) {
        this.declinedDate = declinedDate;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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
