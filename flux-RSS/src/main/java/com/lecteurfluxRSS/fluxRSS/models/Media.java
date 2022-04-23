package com.lecteurfluxRSS.fluxRSS.models;

import javax.persistence.*;

@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 1024)
    private String content;
    @Column(length = 1024)
    private String description;
    private String credit;
    @OneToOne
    private Items item;

    public Media() {
    }

    public Media(String content, String description, String credit) {
        this.content = content;
        this.description = description;
        this.credit = credit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Media{" +
                "content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }

}
