package com.demas.dcpa.data.dto;

import javax.xml.crypto.Data;
import java.sql.Date;

public class GameDTO {
    String title;
    String description;
    String image;
    Date dateAdded;

    public GameDTO(String title, String description, String image, Date dateAdded) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dateAdded = dateAdded;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
