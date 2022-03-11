package com.LibraryManagement.Entity;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;


@Entity
@Table(name="User")
public class UserEntity {
    @Id
//    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;
//    @NotBlank(message="Student name cannot be empty")
    private String name;
    private String address;
    private Long phoneNumber;

    public UserEntity() {

    }

    public UserEntity(Long id1, String name, String address, Long phoneNumber) {
        this.id1 = id1;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public Long getId() {
        return id1;
    }

    public void setId(Long id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
