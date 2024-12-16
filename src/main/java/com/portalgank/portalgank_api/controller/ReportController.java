package com.portalgank.portalgank_api.controller;

import com.portalgank.portalgank_api.dto.ReportDto;
import com.portalgank.portalgank_api.dto.ReportStatusRequest;
import com.portalgank.portalgank_api.entity.Report;
import com.portalgank.portalgank_api.enumeration.ReportStatus;
import com.portalgank.portalgank_api.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<List<ReportDto>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody ReportDto request) {
        return ResponseEntity.ok(reportService.saveReport(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.getReportById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ReportDto>> getAllReportsByStatus(@PathVariable ReportStatus status) {
        return ResponseEntity.ok(reportService.getAllReportsByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReportStatus(@PathVariable Long id, @RequestBody ReportStatusRequest request) {
        this.reportService.updateStatusReport(id, request.getStatus());

        return ResponseEntity.ok("Report with id " + id + " successfully updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        this.reportService.deleteReport(id);

        return ResponseEntity.noContent().build();
    }
}
