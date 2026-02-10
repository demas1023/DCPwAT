package com.demas.dcpa.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "achievement")
public class Achievement {
    @Id
    @GeneratedValue
    int id;
    String title;
    String description;
    String icon;
    @ManyToOne
    Game game;
    String element; //as found in the JSON
    int condition; //necessary amount for completion
    private boolean completed;

    public Achievement() {}
    public Achievement(String title, String description, String icon, Game game, String element, int condition, boolean completed) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.game = game;
        this.element = element;
        this.condition = condition;
        this.completed = completed;
    }

    public Achievement(String title, String description, String icon, int condition, boolean completed) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.condition = condition;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
