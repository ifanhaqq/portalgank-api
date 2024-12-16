package com.portalgank.portalgank_api.repository;

import com.portalgank.portalgank_api.entity.Feedback;
import com.portalgank.portalgank_api.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("SELECT f FROM Feedback f WHERE f.report.id = :reportId")
    List<Feedback> findAllByReportId(@Param("reportId") Long reportId);

}
