package de.jikugmbh.kanbanboard.backend.userstory.entity;


import lombok.Getter;

@Getter
public enum StoryPoints {
    ONE(1),
    TWO(2),
    THREE(3),
    FIVE(5),
    EIGHT(8),
    THIRTEEN(13),
    TWENTY_ONE(21);

    private int value;
    private StoryPoints(int value) {
        this.value=value;
    }

    public static int getValueByEnum(StoryPoints storyPoints) {
        return storyPoints.getValue();
    }
}
