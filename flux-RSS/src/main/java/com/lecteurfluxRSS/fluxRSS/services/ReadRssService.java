package com.lecteurfluxRSS.fluxRSS.services;

import com.lecteurfluxRSS.fluxRSS.models.Channel;
import com.lecteurfluxRSS.fluxRSS.models.Items;
import com.lecteurfluxRSS.fluxRSS.models.Media;
import com.lecteurfluxRSS.fluxRSS.repository.ItemRepository;
import com.sun.syndication.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.List;

public interface ReadRssService {
    
    public Channel readRss() throws IOException, FeedException;

    public void saveRss() throws IOException, FeedException;

    public Channel getLastRss();

    public Items getItemById(Long id);

    public void saveItem(Items item);

    public Channel getChannelByItemId(Long id);



}
