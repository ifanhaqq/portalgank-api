package com.portalgank.portalgank_api.repository;

import com.portalgank.portalgank_api.entity.Report;
import com.portalgank.portalgank_api.enumeration.ReportStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByUserId(Long userId);
    List<Report> findAllByReportStatus(ReportStatus reportStatus);

}
