package de.jikugmbh.kanbanboard.web.userstory.model;

import lombok.Data;

@Data
public class UserStory {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
