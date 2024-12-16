package com.portalgank.portalgank_api.service;

import com.portalgank.portalgank_api.dto.*;
import com.portalgank.portalgank_api.entity.*;
import com.portalgank.portalgank_api.enumeration.ReportStatus;
import com.portalgank.portalgank_api.repository.*;
import com.portalgank.portalgank_api.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final ChronologyRepository chronologyRepository;
    private final ReporterRepository reporterRepository;
    private final SuspectRepository suspectRepository;
    private final UserRepository userRepository;

    public ReportService(ReportRepository reportRepository, ChronologyRepository chronologyRepository, ReporterRepository reporterRepository, SuspectRepository suspectRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.chronologyRepository = chronologyRepository;
        this.reporterRepository = reporterRepository;
        this.suspectRepository = suspectRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Report saveReport(ReportDto request) {
        ReporterDto reporterDto = request.getReporter();
        ChronologyDto chronologyDto = request.getChronology();
        SuspectDto suspectDto = request.getSuspect();
        SecurityUtil securityUtil = new SecurityUtil(this.userRepository);

        Reporter reporter = new Reporter(reporterDto.getAs(), reporterDto.getName(), reporterDto.getProfession(), reporterDto.getAddress(), reporterDto.getPhoneNumber());
        Reporter savedReporter = reporterRepository.save(reporter);

        Chronology chronology = new Chronology(chronologyDto.getEventDate(), chronologyDto.getEventDetail(), chronologyDto.getLocation(), chronologyDto.getSupportingEvidence());
        Chronology savedChronology = chronologyRepository.save(chronology);

        Suspect suspect = new Suspect(suspectDto.getName(), suspectDto.getProfession());
        Suspect savedSuspect = suspectRepository.save(suspect);

        Report report = new Report(securityUtil.getAuthenticatedUserId(), savedReporter, savedChronology, savedSuspect);

        return reportRepository.save(report);
    }

    public List<ReportDto> getAllReports() {
        List<Report> reports = this.reportRepository.findAll();
        return reports.stream()
                .map(report -> {
                    ChronologyDto chronology = new ChronologyDto(report.getChronology().getEventDate(), report.getChronology().getEventDetail(), report.getChronology().getLocation(), report.getChronology().getSupportingEvidence());
                    ReporterDto reporter = new ReporterDto(report.getReporter().getAs(), report.getReporter().getName(), report.getReporter().getProfession(), report.getReporter().getAddress(), report.getReporter().getPhoneNumber());
                    SuspectDto suspect = new SuspectDto(report.getSuspect().getName(), report.getSuspect().getProfession());

                    return new ReportDto(
                            report.getId(),
                            report.getUserId(),
                            chronology,
                            reporter,
                            suspect,
                            report.getReportStatus()
                    );
                })
                .toList();
    }

    public ReportDto getReportById(Long id) {
        Report report =  this.reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report does not exist!"));
        ChronologyDto chronology = new ChronologyDto(report.getChronology().getEventDate(), report.getChronology().getEventDetail(), report.getChronology().getLocation(), report.getChronology().getSupportingEvidence());
        ReporterDto reporter = new ReporterDto(report.getReporter().getAs(), report.getReporter().getName(), report.getReporter().getProfession(), report.getReporter().getAddress(), report.getReporter().getPhoneNumber());
        SuspectDto suspect = new SuspectDto(report.getSuspect().getName(), report.getSuspect().getProfession());

        return new ReportDto(report.getId(), report.getUserId(), chronology, reporter, suspect, report.getReportStatus());
    }

    @Transactional
    public List<ReportDto> getAllReportsByStatus(ReportStatus status) {
        List<Report> reports = this.reportRepository.findAllByReportStatus(status);
        return reports.stream()
                .map(report -> {
                    ChronologyDto chronology = new ChronologyDto(report.getChronology().getEventDate(), report.getChronology().getEventDetail(), report.getChronology().getLocation(), report.getChronology().getSupportingEvidence());
                    ReporterDto reporter = new ReporterDto(report.getReporter().getAs(), report.getReporter().getName(), report.getReporter().getProfession(), report.getReporter().getAddress(), report.getReporter().getPhoneNumber());
                    SuspectDto suspect = new SuspectDto(report.getSuspect().getName(), report.getSuspect().getProfession());

                    return new ReportDto(
                            report.getId(),
                            report.getUserId(),
                            chronology,
                            reporter,
                            suspect,
                            report.getReportStatus()
                    );
                })
                .toList();
    }

    public void updateStatusReport(Long id, ReportStatus status) {
        Report existingReport = this.reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report does not exist!") );

        existingReport.setReportStatus(status);

        this.reportRepository.save(existingReport);
    }

    public void deleteReport(Long id) {
        this.reportRepository.deleteById(id);
    }
}
