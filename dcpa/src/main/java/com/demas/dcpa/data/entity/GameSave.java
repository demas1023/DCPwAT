package com.demas.dcpa.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tools.jackson.databind.JsonNode;

import java.sql.Date;

@Entity
@Table(name = "gamesave")
public class GameSave {
    @Id
    @GeneratedValue
    int id;
    Date dateUploaded;
    @ManyToOne
    Game game;
    @ManyToOne
    Client client;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    JsonNode save;

    public GameSave() {}

    public GameSave(Game game, Client client, JsonNode save) {
        this.game = game;
        this.client = client;
        this.save = save;
        this.dateUploaded = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JsonNode getSave() {
        return save;
    }

    public void setSave(JsonNode save) {
        this.save = save;
    }
}
