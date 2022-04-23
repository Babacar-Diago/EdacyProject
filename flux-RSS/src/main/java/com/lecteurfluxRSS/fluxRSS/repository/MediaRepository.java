package com.lecteurfluxRSS.fluxRSS.repository;

import com.lecteurfluxRSS.fluxRSS.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {
}
