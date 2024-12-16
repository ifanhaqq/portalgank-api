package com.portalgank.portalgank_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "suspects")
public class Suspect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String profession;

    protected Suspect() {}

    public Suspect(String name, String profession) {
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
