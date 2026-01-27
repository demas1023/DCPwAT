package com.demas.dcpa.data.entity;

import com.demas.dcpa.data.rol.PublicationRol;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

@Entity
public class Publication {

    @Id
    @GeneratedValue
    int id;
    @ManyToOne
    Client author;
    @ManyToOne
    Game game;
    String title;
    String content;
    PublicationRol publicationRol;
    Date publicationDate;
    int rating;

    public Publication() {}

    public Publication(Client author, Game game, String title, String content, PublicationRol publicationRol, Date publicationDate, int rating) {
        this.author = author;
        this.game = game;
        this.title = title;
        this.content = content;
        this.publicationRol = publicationRol;
        this.publicationDate = publicationDate;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getAuthor() {
        return author;
    }

    public void setAuthor(Client author) {
        this.author = author;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
