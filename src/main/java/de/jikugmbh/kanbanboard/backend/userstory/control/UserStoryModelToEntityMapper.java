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
                .type(userStoryModel.getType()
//                        StoryType.fromString(
//                                userStoryModel.getType()
//                        )
                )
                .status(userStoryModel.getStatus()
//                        StoryStatus.valueOf(
//                                userStoryModel.getStatus()
//                        )
                )
                .estimation(userStoryModel.getEstimation()
//                        StoryPoints.fromString(
//                                userStoryModel.getEstimation()
//                        )
                )
                .priority(userStoryModel.getPriority()
//                        StoryPrio.fromString(
//                                userStoryModel.getPriority()
//                        )
                )
                .build();


    }
}
