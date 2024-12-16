package com.portalgank.portalgank_api.service;

import com.portalgank.portalgank_api.dto.*;
import com.portalgank.portalgank_api.entity.Feedback;
import com.portalgank.portalgank_api.entity.Report;
import com.portalgank.portalgank_api.repository.FeedbackRepository;
import com.portalgank.portalgank_api.repository.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final ReportRepository reportRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, ReportRepository reportRepository) {
        this.feedbackRepository = feedbackRepository;
        this.reportRepository = reportRepository;
    }

    public FeedbackResponse saveFeedback(FeedbackRequest request) {
        Report report = this.reportRepository.findById(request.getReportId()).orElseThrow(() -> new RuntimeException("Report not found!"));
        ReportDto reportDto = getReportDto(report);
        Feedback newFeedback = new Feedback(report, request.getContent());

        this.feedbackRepository.save(newFeedback);
        return new FeedbackResponse(reportDto, request.getContent());
    }

    public List<FeedbackResponse> getAllFeedback() {
        List<Feedback> feedbacks = this.feedbackRepository.findAll();

        return feedbacks.stream().map(feedback -> {
            ReportDto reportDto = getReportDto(feedback.getReport());
            return new FeedbackResponse(reportDto, feedback.getContent());
        }).toList();
    }

    public FeedbackResponse getFeedbackById(Long id) {
        Feedback feedback = this.feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));

        ReportDto reportDto = getReportDto(feedback.getReport());
        return new FeedbackResponse(reportDto, feedback.getContent());
    }

    @Transactional
    public List<FeedbackResponse> getAllFeedbackByReportId(Long id) {
        List<Feedback> feedbacks = this.feedbackRepository.findAllByReportId(id);

        return feedbacks.stream().map(feedback -> {
            ReportDto reportDto = getReportDto(feedback.getReport());
            return new FeedbackResponse(reportDto, feedback.getContent());
        }).toList();
    }

    private static ReportDto getReportDto(Report report) {
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
    }
}
