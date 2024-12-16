package com.portalgank.portalgank_api.entity;


import com.portalgank.portalgank_api.enumeration.As;
import jakarta.persistence.*;

@Entity
@Table(name = "reporters")
public class Reporter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "as_what")
    private As as;

    private String name;
    private String profession;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    protected Reporter() {}


    public Reporter(As as, String name, String profession, String address, String phoneNumber) {
        this.as = as;
        this.name = name;
        this.profession = profession;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public As getAs() {
        return as;
    }

    public void setAs(As as) {
        this.as = as;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


