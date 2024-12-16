package com.portalgank.portalgank_api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.portalgank.portalgank_api.enumeration.ReportStatus;

public class ReportStatusRequest {
    @JsonProperty("report_status")
    private ReportStatus status;

    @JsonCreator
    public ReportStatusRequest(@JsonProperty("report_status") ReportStatus status) {
        this.status = status;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }
}
