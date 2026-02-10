package com.demas.dcpa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    int id;
    @ManyToOne
    Client commenter;
    @ManyToOne
    Publication publication;
    String comment;
    Date commentDate;
    int rating;

    public Comment() {}

    public Comment(Client commenter, Publication publication, String comment, Date commentDate, int rating) {
        this.commenter = commenter;
        this.publication = publication;
        this.comment = comment;
        this.commentDate = commentDate;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getCommenter() {
        return commenter;
    }

    public void setCommenter(Client commenter) {
        this.commenter = commenter;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
