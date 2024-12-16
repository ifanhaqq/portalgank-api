package com.portalgank.portalgank_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portalgank.portalgank_api.enumeration.ReportStatus;
import jakarta.validation.constraints.NotNull;

public class ReportDto {

    private Long id;

    @NotNull
    private ChronologyDto chronology;

    @NotNull
    private ReporterDto reporter;

    @NotNull
    private SuspectDto suspect;

    @JsonProperty("user_id") @NotNull
    private Long userId;

    @JsonProperty("report_status") @NotNull
    private ReportStatus reportStatus;

    public ReportDto(Long id, Long userId, ChronologyDto chronology, ReporterDto reporter, SuspectDto suspect, ReportStatus reportStatus) {
        this.id = id;
        this.userId = userId;
        this.chronology = chronology;
        this.reporter = reporter;
        this.suspect = suspect;
        this.reportStatus = reportStatus;
    }

    public ChronologyDto getChronology() {
        return chronology;
    }

    public void setChronology(ChronologyDto chronology) {
        this.chronology = chronology;
    }

    public ReporterDto getReporter() {
        return reporter;
    }

    public void setReporter(ReporterDto reporter) {
        this.reporter = reporter;
    }

    public SuspectDto getSuspect() {
        return suspect;
    }

    public void setSuspect(SuspectDto suspect) {
        this.suspect = suspect;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportStatus getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(ReportStatus reportStatus) {
        this.reportStatus = reportStatus;
    }


}
