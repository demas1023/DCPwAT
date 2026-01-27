package com.demas.dcpa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

@Entity
public class ClientGame {
    @Id
    Date date;
    @Id
    @ManyToOne
    Client client;
    @Id
    @ManyToOne
    Game game;

    public ClientGame(Client client, Game game) {
        this.client = client;
        this.game = game;
        this.date = new Date(System.currentTimeMillis());
    }

    public ClientGame() {}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
