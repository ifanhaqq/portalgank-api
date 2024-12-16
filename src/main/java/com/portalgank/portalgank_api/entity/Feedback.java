package com.portalgank.portalgank_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    public Report report;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    protected Feedback() {}

    public Feedback(Report report, String content) {
        this.report = report;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Report getReport() {
        return this.report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
