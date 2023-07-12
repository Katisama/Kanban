package de.jikugmbh.kanbanboard.backend.userstory.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StoryPointsTest {

    @Test
    void fromString() {
        StoryPoints resultEnum = StoryPoints.fromString("THIRTEEN");
        assertThat(resultEnum).isEqualTo(StoryPoints.THIRTEEN);
    }

    @Test
    void getDisplayValue() {
        int displayValue = StoryPoints.TWENTY_ONE.getDisplayValue();
        assertThat(displayValue).isEqualTo(21);
    }
}