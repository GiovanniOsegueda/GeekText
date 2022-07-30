package com.group11.geektext.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//MYSQL will connect to the database and create a table
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long Id;
                                                //Change variable to private for getters and setters
    @Column
    private String authorFirstName;

    @Column
    private String authorLastName;

    @Column
    private String authorBiography;

    @Column
    private String authorPublisher;

    @Column
    private String authorFullName = authorFirstName + " " +authorLastName;         //Function to bring the first and last name together

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public String getAuthorPublisher() {
        return authorPublisher;
    }

    public void setAuthorPublisher(String authorPublisher) {
        this.authorPublisher = authorPublisher;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}