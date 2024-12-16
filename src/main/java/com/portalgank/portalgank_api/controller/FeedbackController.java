package com.portalgank.portalgank_api.controller;

import com.portalgank.portalgank_api.dto.FeedbackRequest;
import com.portalgank.portalgank_api.dto.FeedbackResponse;
import com.portalgank.portalgank_api.service.FeedbackService;
import com.portalgank.portalgank_api.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;


    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponse>> getAllResponses() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @PostMapping
    public ResponseEntity<FeedbackResponse> saveFeedback(@RequestBody FeedbackRequest request) {
        return ResponseEntity.ok(feedbackService.saveFeedback(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackResponse> getFeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(id));
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<List<FeedbackResponse>> getFeedbackByReportId(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getAllFeedbackByReportId(id));
    }
}
