package com.lecteurfluxRSS.fluxRSS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String title;
    @Column(length = 1024)
    private String description;
    @Column(length = 1024)
    private String copyright;
    @Column(length = 1024)
    private String link;
    private Date pubDate;
    @JsonIgnoreProperties("channel")
    @OneToMany(mappedBy = "channel")
    private Collection<Items> items;

    public Channel(String title, String description, String copyright, String link, Date pubDate) {
        this.title = title;
        this.description = description;
        this.copyright = copyright;
        this.link = link;
        this.pubDate = pubDate;
    }

    public Channel() {

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

    public Collection<Items> getItems() {
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
