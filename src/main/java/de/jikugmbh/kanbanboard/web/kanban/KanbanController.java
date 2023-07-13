package de.jikugmbh.kanbanboard.web.kanban;

import de.jikugmbh.kanbanboard.backend.userstory.boundary.UserStoryBoundary;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryStatus;
import de.jikugmbh.kanbanboard.backend.userstory.entity.UserStory;
import de.jikugmbh.kanbanboard.web.view.ViewFragmentConstants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class KanbanController {

    private static final Logger log = LoggerFactory.getLogger(KanbanController.class);

    private final UserStoryBoundary userStoryBoundary;

    @RequestMapping("/kanban")
    public String getKanban(Model model) {

        /**
         * read stories grouped by stotus from db and insert into view model
         */

        updateView(model);

        return ViewFragmentConstants.KANBAN;
    }

    private void updateView(Model model) {
        List<UserStory> newStories = userStoryBoundary.getUserStoriesByStatus(StoryStatus.NEW);
        List<UserStory> blockedStories = userStoryBoundary.getUserStoriesByStatus(StoryStatus.BLOCKED);
        List<UserStory> inProgressStories = userStoryBoundary.getUserStoriesByStatus(StoryStatus.IN_PROGRESS);
        List<UserStory> inReviewStories = userStoryBoundary.getUserStoriesByStatus(StoryStatus.IN_REVIEW);
        List<UserStory> inTestStories = userStoryBoundary.getUserStoriesByStatus(StoryStatus.IN_TEST);
        List<UserStory> doneStories = userStoryBoundary.getUserStoriesByStatus(StoryStatus.DONE);

        log.info("new: " + newStories);
        log.info("blocked: " + blockedStories);

        model.addAttribute("newStories", newStories);
        model.addAttribute("blocked", blockedStories);
        model.addAttribute("inProgress", inProgressStories);
        model.addAttribute("inReview", inReviewStories);
        model.addAttribute("inTest", inTestStories);
        model.addAttribute("done", doneStories);
    }
}

