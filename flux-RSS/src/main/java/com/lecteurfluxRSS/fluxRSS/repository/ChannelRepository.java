package com.lecteurfluxRSS.fluxRSS.repository;

import com.lecteurfluxRSS.fluxRSS.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    @Query(value = "select * from channel ORDER BY id DESC LIMIT 1", nativeQuery=true)
    public Channel getLastRss();

}
