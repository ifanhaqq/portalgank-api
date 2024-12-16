package com.portalgank.portalgank_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "chronologies")
public class Chronology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Lob
    @Column(name = "event_detail", columnDefinition = "TEXT")
    private String eventDetail;

    private String location;

    @Column(name = "supporting_evidence")
    private String supportingEvidence;

    protected Chronology() {}


    public Chronology(LocalDate eventDate, String eventDetail, String location, String supportingEvidence) {
        this.eventDate = eventDate;
        this.eventDetail = eventDetail;
        this.location = location;
        this.supportingEvidence = supportingEvidence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSupportingEvidence() {
        return supportingEvidence;
    }

    public void setSupportingEvidence(String supportingEvidence) {
        this.supportingEvidence = supportingEvidence;
    }
}
