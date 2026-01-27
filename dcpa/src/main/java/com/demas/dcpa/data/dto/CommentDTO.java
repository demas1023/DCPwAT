package com.demas.dcpa.data.dto;

import java.sql.Date;

public class CommentDTO {
    PublicationDTO publication;
    ClientDTO client;
    String comment;
    Date commentDate;
    int rating;

    public CommentDTO(PublicationDTO publication, ClientDTO client, String comment, Date commentDate, int rating) {
        this.publication = publication;
        this.client = client;
        this.comment = comment;
        this.commentDate = commentDate;
        this.rating = rating;
    }

    public PublicationDTO getPublication() {
        return publication;
    }

    public void setPublication(PublicationDTO publication) {
        this.publication = publication;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
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
