package com.portalgank.portalgank_api.repository;

import com.portalgank.portalgank_api.entity.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuspectRepository extends JpaRepository<Suspect, Long> {
}
