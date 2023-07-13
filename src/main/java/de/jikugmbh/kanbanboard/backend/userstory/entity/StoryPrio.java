package de.jikugmbh.kanbanboard.backend.userstory.entity;

import lombok.Getter;

@Getter
public enum StoryPrio {
    LOW("low"),
    MIDDLE("middle"),
    HIGH("high");

    private final String displayValue;
    private StoryPrio(String value) {
        this.displayValue = value;
    }

    public static StoryPrio fromString(String enumTypeString) {
        return StoryPrio.valueOf(enumTypeString);
    }
}
