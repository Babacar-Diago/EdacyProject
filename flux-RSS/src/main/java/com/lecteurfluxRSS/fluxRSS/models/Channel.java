package com.lecteurfluxRSS.fluxRSS.models;

import com.fasterxml.jackson.annotation.JsonTypeId;

import java.util.Date;
import java.util.List;

public class Channel {

    private String title;
    private String description;
    private String copyright;
    private String link;
    private Date pubDate;
    private List<Items> items;

    public Channel(String title, String description, String copyright, String link, Date pubDate) {
        this.title = title;
        this.description = description;
        this.copyright = copyright;
        this.link = link;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", copyright='" + copyright + '\'' +
                ", link='" + link + '\'' +
                ", pubDate=" + pubDate +
                ", items=" + items +
                '}';
    }
}
