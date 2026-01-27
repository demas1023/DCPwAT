package com.demas.dcpa.data.dto;

import com.demas.dcpa.data.rol.PublicationRol;

import java.sql.Date;

public class PublicationDTO {
    String title;
    GameDTO game;
    ClientDTO author;
    String content;
    PublicationRol publicationRol;
    Date publicationDate;

    int rating;

    public PublicationDTO(String title, GameDTO game, ClientDTO author, String content, PublicationRol publicationRol, Date publicationDate, int rating) {
        this.title = title;
        this.game = game;
        this.author = author;
        this.content = content;
        this.publicationRol = publicationRol;
        this.publicationDate = publicationDate;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public ClientDTO getAuthor() {
        return author;
    }

    public void setAuthor(ClientDTO author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PublicationRol getPublicationRol() {
        return publicationRol;
    }

    public void setPublicationRol(PublicationRol publicationRol) {
        this.publicationRol = publicationRol;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
