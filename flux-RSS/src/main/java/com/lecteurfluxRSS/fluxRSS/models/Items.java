package com.lecteurfluxRSS.fluxRSS.models;

import java.util.Date;

public class Items {

    private int id;
    private String title;
    private String pubDate;
    private String description;
    private String link;
    private Media media;

    public Items(int id, String title, String pubDate, String description, String link) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.link = link;
    }

    public Items() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "title='" + title + '\'' +
                ", pubDate=" + pubDate +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
