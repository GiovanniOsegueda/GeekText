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
    public int age;
    @Column
    public String occupation;

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

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
