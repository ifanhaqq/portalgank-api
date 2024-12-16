package com.portalgank.portalgank_api.entity;

import com.portalgank.portalgank_api.enumeration.ReportStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reporter_id", nullable = false)
    private Reporter reporter;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chronology_id", nullable = false)
    private Chronology chronology;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "suspect_id", nullable = false)
    private Suspect suspect;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_status")
    private ReportStatus reportStatus;

    protected Report(){}


    public Report(Long userId, Reporter reporter, Chronology chronology, Suspect suspect) {
        this.userId = userId;
        this.reporter = reporter;
        this.chronology = chronology;
        this.suspect = suspect;
        this.reportStatus = ReportStatus.REVIEW;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public Chronology getChronology() {
        return chronology;
    }

    public void setChronology(Chronology chronology) {
        this.chronology = chronology;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ReportStatus getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(ReportStatus reportStatus) {
        this.reportStatus = reportStatus;
    }
}
