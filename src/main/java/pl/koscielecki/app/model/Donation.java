package pl.koscielecki.app.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Items> items=new ArrayList<>();

    private int quantity;

    @ManyToOne
    private TrustedInstitutions trustedInstitutions;

    private String city;
    private String address;
    private String zip;
    private String phoneNumber;

    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpRemarks;

    private boolean pickedUp;

    private LocalDate actualPickUpDate;

    private boolean donated;

    private LocalDate donationDate;

    private LocalDateTime creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public TrustedInstitutions getTrustedInstitutions() {
        return trustedInstitutions;
    }

    public void setTrustedInstitutions(TrustedInstitutions trustedInstitutions) {
        this.trustedInstitutions = trustedInstitutions;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpRemarks() {
        return pickUpRemarks;
    }

    public void setPickUpRemarks(String pickUpRemarks) {
        this.pickUpRemarks = pickUpRemarks;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public LocalDate getActualPickUpDate() {
        return actualPickUpDate;
    }

    public void setActualPickUpDate(LocalDate actualPickUpDate) {
        this.actualPickUpDate = actualPickUpDate;
    }

    public boolean isDonated() {
        return donated;
    }

    public void setDonated(boolean donated) {
        this.donated = donated;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
