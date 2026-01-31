package com.demas.dcpa.data.entity;

import com.demas.dcpa.data.rol.ClientRoles;
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

    ClientRoles clientRol; //to keep developers withing scope of their own games

    public ClientGame(Client client, Game game) {
        this.client = client;
        this.game = game;
        this.date = new Date(System.currentTimeMillis());
        this.clientRol = ClientRoles.CLIENT;
    }

    public ClientGame(Client client, Game game, ClientRoles clientRol) {
        this.client = client;
        this.game = game;
        this.date = new Date(System.currentTimeMillis());
        this.clientRol = clientRol;
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
