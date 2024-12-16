package com.portalgank.portalgank_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackRequest {
    private Long id;

    @JsonProperty("report_id")
    private Long reportId;

    private String content;

    public FeedbackRequest(Long reportId, String content) {
        this.reportId = reportId;
        this.content = content;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
