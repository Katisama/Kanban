package de.jikugmbh.kanbanboard.backend.userstory.entity;

import lombok.Getter;

@Getter
public enum StoryStatus {
    NEW("new"),
    IN_PROGRESS("in progress"),
    IN_REVIEW("in review"),
    IN_TEST("in test"),
    DONE("done");

    private final String displayValue;

    private StoryStatus(String value) {
        this.displayValue =value;
    }
}
