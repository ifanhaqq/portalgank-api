package com.portalgank.portalgank_api.dto;

import jakarta.validation.constraints.NotNull;

public class SuspectDto {
    @NotNull
    private String name;

    @NotNull
    private String profession;

    public SuspectDto(String name, String profession) {
        this.name = name;
        this.profession = profession;
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
}
