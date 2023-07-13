package de.jikugmbh.kanbanboard.web.userstory.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserStoryModel {

    private Long storyId;
    private String description;
    private String summary;
    private String type;
    private String status;
    private Long assigneeId;
    private String estimation;
    private Long projectId;
    private String priority;

}
