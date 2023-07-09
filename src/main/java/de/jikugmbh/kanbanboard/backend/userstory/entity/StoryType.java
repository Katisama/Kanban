package de.jikugmbh.kanbanboard.backend.userstory.entity;

import lombok.Getter;

@Getter
public enum StoryType {
    STORY("Story"),
    DEFECT("Defect");

    private String value;

    private StoryType(String value) {
        this.value=value;
    }
}
