package de.jikugmbh.kanbanboard.web.userstory.model;

import de.jikugmbh.kanbanboard.backend.user.entity.User;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryPoints;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryPrio;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryStatus;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserStoryModel {

    private Long storyId;
    private String description;
    private String summary;
    private StoryType type;
    private StoryStatus status;
    private User assignee;
    private StoryPoints estimation;
    private Long projectId;
    private StoryPrio priority;

}
