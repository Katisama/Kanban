package de.jikugmbh.kanbanboard.backend.userstory.entity;

import lombok.Getter;

@Getter
public enum StoryPrio {
    LOW("low"),
    MIDDLE("middle"),
    HIGH("high");

    private String value;
    private StoryPrio(String value) {
        this.value = value;
    }
}
