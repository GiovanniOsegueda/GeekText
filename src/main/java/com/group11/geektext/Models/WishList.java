package com.group11.geektext.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WishList {

    @Id
    @GeneratedValue
    private int wishId;

    @Column
    private String userEmail;

    @Column
    private String wishListName;

    @Column
    private String bookISBN;

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookName) {
        this.bookISBN = bookName;
    }
}
