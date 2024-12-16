package com.portalgank.portalgank_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portalgank.portalgank_api.enumeration.As;
import jakarta.validation.constraints.NotNull;

public class ReporterDto {
    @NotNull
    private As as;

    @NotNull
    private String name;

    @NotNull
    private String profession;

    @NotNull
    private String address;

    @JsonProperty("phone_number")
    @NotNull
    private String phoneNumber;

    public ReporterDto(As as, String name, String profession, String address, String phoneNumber) {
        this.as = as;
        this.name = name;
        this.profession = profession;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
