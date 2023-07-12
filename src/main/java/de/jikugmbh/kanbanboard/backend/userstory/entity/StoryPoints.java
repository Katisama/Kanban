package de.jikugmbh.kanbanboard.backend.userstory.entity;


import lombok.Getter;

@Getter
public enum StoryPoints {
    NO_POINTS(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FIVE(5),
    EIGHT(8),
    THIRTEEN(13),
    TWENTY_ONE(21);

    private final int displayValue;
    private StoryPoints(int value) {
        this.displayValue =value;
    }

}
