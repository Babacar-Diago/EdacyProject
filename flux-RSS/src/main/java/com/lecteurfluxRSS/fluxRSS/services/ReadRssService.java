package com.lecteurfluxRSS.fluxRSS.services;

import com.lecteurfluxRSS.fluxRSS.models.Channel;
import com.lecteurfluxRSS.fluxRSS.models.Items;
import com.lecteurfluxRSS.fluxRSS.repository.ItemRepository;
import com.sun.syndication.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public interface ReadRssService {
    
    public Channel readRss() throws IOException, FeedException;

    /*public Items getItemById(int id);

    public void modifierItem(Items item, String titre, String description);
*/
}
