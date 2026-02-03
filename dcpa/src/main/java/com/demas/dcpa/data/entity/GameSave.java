package com.demas.dcpa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Type;
import tools.jackson.databind.JsonNode;

import java.sql.Date;

@Entity
public class GameSave {
    @Id
    @GeneratedValue
    int id;
    Date dateUploaded;
    @ManyToOne
    Game game;
    @ManyToOne
    Client client;
    @Type(JsonType.class)
    JsonNode save;
}
