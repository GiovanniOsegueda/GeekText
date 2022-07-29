package com.group11.geektext.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column
    private String userPassword;

    @Column
    private String creditCard;

    @Column
    private String creditCardExpDateMonth;

    @Column
    private String getCreditCardExpDateYear;

    @Column
    private String shippingAddress;

    @Column
    private String shippingCity;

    @Column
    private String shippingZipCode;

    @Column
    private String ShippingState;


    @Column
    private String billingAddress;

    @Column
    private String billingCity;

    @Column
    private String billingState;

    @Column
    private String billingZipCode;

    @Transient
    private String wishListName;

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    //getters and setters

    @OneToMany
    private List<WishList> wishList;

    public List<WishList> getWishList() {
        return wishList;
    }

    public void setWishList(List<WishList> wishList) {
        this.wishList = wishList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setCreditCardExpDateMonth(String creditCardExpDateMonth) {
        this.creditCardExpDateMonth = creditCardExpDateMonth;
    }

    public void setGetCreditCardExpDateYear(String getCreditCardExpDateYear) {
        this.getCreditCardExpDateYear = getCreditCardExpDateYear;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public void setShippingState(String shippingState) {
        ShippingState = shippingState;
    }

    public void setShippingZipCode(String shippingZipCode) {
        this.shippingZipCode = shippingZipCode;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getCreditCardExpDateMonth() {
        return creditCardExpDateMonth;
    }

    public String getGetCreditCardExpDateYear() {
        return getCreditCardExpDateYear;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public String getShippingZipCode() {
        return shippingZipCode;
    }

    public String getShippingState() {
        return ShippingState;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }
}//closing class