package de.jikugmbh.kanbanboard.backend.userstory.entity;

import lombok.Getter;

@Getter
public enum StoryStatus {
    NEW("New"),
    BLOCKED("Blocked"),
    IN_PROGRESS("In Progress"),
    IN_REVIEW("In Review"),
    IN_TEST("In Test"),
    DONE("Done");

    private final String displayValue;

    private StoryStatus(String value) {
        this.displayValue =value;
    }

    public static StoryStatus fromString(String enumTypeString) {
        return StoryStatus.valueOf(enumTypeString);
    }
}
