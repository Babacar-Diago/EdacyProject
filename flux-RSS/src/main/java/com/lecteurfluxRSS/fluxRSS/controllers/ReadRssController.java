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
    public Channel readRss() {
        return readRssService.readRss();
    }

    /*@PutMapping(value = "edititem")
    public void editTitle(@RequestBody Items item, String title, String description){
        readRssService.modifierItem(item, title, description);
    }*/

    /*@GetMapping(value = "/item/{id}")
    public Items getItem(@PathVariable int id){
        return readRssService.getItemById(id);
    }*/


}
