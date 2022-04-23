package com.lecteurfluxRSS.fluxRSS.controllers;

import com.lecteurfluxRSS.fluxRSS.models.Channel;
import com.lecteurfluxRSS.fluxRSS.models.Items;
import com.lecteurfluxRSS.fluxRSS.services.ReadRssServiceImpl;
import com.sun.syndication.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
public class ReadRssController {

    @Autowired
    ReadRssServiceImpl readRssService;

    @GetMapping(value = "/rss", produces = MediaType.APPLICATION_JSON_VALUE)
    public Channel readRss() throws FeedException, IOException {
        return readRssService.readRss();
    }

    @GetMapping(value = "rss/all")
    public Channel getChannel(){
        return readRssService.getLastRss();
    }

    @PatchMapping(value = "edititem/{id}")
    public void editItem(@RequestBody Items item, @PathVariable Long id){
        item.setChannel(readRssService.getChannelByItemId(id));
        item.setTitle(item.getTitle());
        item.setDescription(item.getDescription());
        readRssService.saveItem(item);
    }

    @GetMapping(value = "/item/{id}")
    public Items getItem(@PathVariable Long id){
        return readRssService.getItemById(id);
    }

}
