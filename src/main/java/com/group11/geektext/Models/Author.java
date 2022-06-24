package com.group11.geektext.Models;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Author {

    @Id
    @GeneratedValue
    public long id;

    @Column
    public String authorFirstName;
    @Column
    public String authorLastName;
    @Column
    public String authorBiography;
    @Column
    public String authorPublisher;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public void setFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setLastName(String authorLastName){
        this.authorLastName = authorLastName;
    }

    public void setBiography(String authorBiography){
        this.authorBiography = authorBiography;
    }

    public void setPublisher(String authorPublisher){
        this.authorPublisher = authorPublisher;
    }



}
    /*
    @CreationTimestamp
    private LocalDateTime date_created;

    @UpdateTimestamp
    private LocalDateTime date_updated;

    */