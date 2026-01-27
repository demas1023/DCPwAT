package com.demas.dcpa.data.dto;

public class AchievementDTO {
    String title;
    String description;
    String icon;
    int condition;
    boolean completed;

    public AchievementDTO(String title, String description, String icon, int condition, boolean completed) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.condition = condition;
        this.completed = completed;
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
