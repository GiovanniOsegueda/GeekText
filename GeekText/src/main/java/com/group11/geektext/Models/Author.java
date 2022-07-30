package com.group11.geektext.Models;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Variables Setters and Getters for the Author Class
 * Author: Michelle Picciuto ( Assigned Book Details )
 */
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long Id;

    @Column
    private String authorFirstName;

    @Column
    private String authorLastName;

    @Column
    private String authorBiography;

    @Column
    private String authorPublisher;

    @Column
    private String authorFullName = authorFirstName + " " +authorLastName;

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