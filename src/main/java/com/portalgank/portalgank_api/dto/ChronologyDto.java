package com.portalgank.portalgank_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ChronologyDto {

    @JsonProperty("event_date")
    @NotNull
    private LocalDate eventDate;

    @JsonProperty("event_detail")
    @NotNull
    private String eventDetail;

    @NotNull
    private String location;

    @JsonProperty("supporting_evidence")
    @NotNull
    private String supportingEvidence;

    public ChronologyDto(LocalDate eventDate, String eventDetail, String location, String supportingEvidence) {
        this.eventDate = eventDate;
        this.eventDetail = eventDetail;
        this.location = location;
        this.supportingEvidence = supportingEvidence;
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
