package com.lecteurfluxRSS.fluxRSS.repository;


import com.lecteurfluxRSS.fluxRSS.models.Channel;
import com.lecteurfluxRSS.fluxRSS.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {



}
