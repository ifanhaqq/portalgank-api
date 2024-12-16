package com.portalgank.portalgank_api.dto;

public class FeedbackResponse {
    private ReportDto report;
    private String content;

    public FeedbackResponse(ReportDto report, String content) {
        this.report = report;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ReportDto getReport() {
        return report;
    }

    public void setReport(ReportDto report) {
        this.report = report;
    }
}
