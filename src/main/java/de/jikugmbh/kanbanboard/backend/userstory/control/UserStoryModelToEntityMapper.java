package de.jikugmbh.kanbanboard.backend.userstory.control;

import de.jikugmbh.kanbanboard.backend.userstory.entity.*;
import de.jikugmbh.kanbanboard.web.userstory.model.UserStoryModel;

import java.util.function.Function;

public class UserStoryModelToEntityMapper implements Function<UserStoryModel, UserStory> {

    @Override
    public UserStory apply(UserStoryModel userStoryModel) {

        return UserStory.builder()
                .description(userStoryModel.getDescription())
                .summary(userStoryModel.getSummary())
                .type(
                        StoryType.fromString(
                                userStoryModel.getType()
                        )
                )
                .status(
                        StoryStatus.valueOf(
                                userStoryModel.getStatus()
                        )
                )
                .estimation(
                        StoryPoints.fromString(
                                userStoryModel.getEstimation()
                        )
                )
                .priority(
                        StoryPrio.fromString(
                                userStoryModel.getPriority()
                        )
                )
                .build();


    }
}
