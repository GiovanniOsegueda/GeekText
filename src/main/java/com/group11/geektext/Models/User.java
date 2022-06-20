package com.group11.geektext.Models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    //@PrimaryKeyJoinColumn
    @GeneratedValue
    public long id;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @Column
    public String email;

    @Column
    public String userPassword;

    @Column
    public String creditCard;

    @Column
    public String creditCardExpDateMonth;

    @Column
    public String getCreditCardExpDateYear;

    @Column
    public String shippingAddress;

    @Column
    public String shippingCity;

    @Column
    public String shippingZipCode;

    @Column
    public String ShippingState;


    @Column
    public String billingAddress;

    @Column
    public String billingCity;

    @Column
    public String billingState;

    @Column
    public String billingZipCode;


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

    public void setOccupation(String userPassword) {
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


}//closing class