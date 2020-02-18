package com.example.cs5200sp20jannunziserverjava.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class YouTubeWidget extends Widget {
    private String url;
    private Boolean embeddable;
    private Date published;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }
}
