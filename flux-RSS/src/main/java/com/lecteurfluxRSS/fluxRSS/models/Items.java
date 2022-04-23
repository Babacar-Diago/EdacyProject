package com.lecteurfluxRSS.fluxRSS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String pubDate;
    @Column(length = 1024)
    private String description;
    @Column(length = 1024)
    private String link;
    @OneToOne
    private Media media;
    @JsonIgnoreProperties("items")
    @ManyToOne
    @JoinColumn(name = "id_chanel",nullable = true)
    private Channel channel;

    public Items(int id, String title, String pubDate, String description, String link, Media media, Channel channel) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.link = link;
        this.media = media;
        this.channel = channel;
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

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
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
