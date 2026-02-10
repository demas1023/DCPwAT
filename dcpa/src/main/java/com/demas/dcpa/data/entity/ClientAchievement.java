package com.demas.dcpa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "client_achievement")
public class ClientAchievement {

    @Id
    Date date;
    @Id
    @ManyToOne
    Client client;
    @Id
    @ManyToOne
    Achievement achievement;

    public ClientAchievement() {}

    public ClientAchievement(Client client, Achievement achievement) {
        this.client = client;
        this.achievement = achievement;
        this.date = new Date(System.currentTimeMillis());
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
