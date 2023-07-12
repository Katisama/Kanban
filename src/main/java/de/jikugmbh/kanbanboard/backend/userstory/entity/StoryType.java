package de.jikugmbh.kanbanboard.backend.userstory.entity;

import lombok.Getter;

@Getter
public enum StoryType {
    STORY("Story"),
    DEFECT("Defect");

    private final String displayValue;

    private StoryType(String displayValue) {
        this.displayValue = displayValue;
    }
}
