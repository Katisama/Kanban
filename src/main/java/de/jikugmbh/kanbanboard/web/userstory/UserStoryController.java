package de.jikugmbh.kanbanboard.web.userstory;

import de.jikugmbh.kanbanboard.backend.userstory.boundary.UserStoryBoundary;
import de.jikugmbh.kanbanboard.backend.userstory.control.UserStoryModelToEntityMapper;
import de.jikugmbh.kanbanboard.web.userstory.model.UserStoryModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserStoryController {

    private static final Logger logger = LoggerFactory.getLogger(UserStoryController.class);

    private final UserStoryBoundary userStoryBoundary;

    @PostMapping("/save-story")
    public String createNew(@ModelAttribute("userStoryModel") UserStoryModel userStory) {


            userStoryBoundary.save(
                    new UserStoryModelToEntityMapper().apply(userStory)
            );




        return "kanban";
    }

}
