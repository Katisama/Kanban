package de.jikugmbh.kanbanboard.web.userstory;

import de.jikugmbh.kanbanboard.backend.userstory.boundary.UserStoryBoundary;
import de.jikugmbh.kanbanboard.backend.userstory.control.UserStoryModelToEntityMapper;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryStatus;
import de.jikugmbh.kanbanboard.backend.userstory.entity.UserStory;
import de.jikugmbh.kanbanboard.web.userstory.model.UserStoryModel;
import de.jikugmbh.kanbanboard.web.view.ViewFragmentConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserStoryController {

    private static final Logger log = LoggerFactory.getLogger(UserStoryController.class);

    private final UserStoryBoundary userStoryBoundary;

    @PostMapping("/save-story")
    public String createNew(@ModelAttribute("userStoryModel") UserStoryModel userStoryModel, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        model.addAttribute("user", session.getAttribute("user") );

        saveNew(userStoryModel);
        updateView(model);

        return ViewFragmentConstants.KANBAN;
    }

    private void saveNew(UserStoryModel userStoryModel) {
        userStoryBoundary.save(
                new UserStoryModelToEntityMapper().apply(userStoryModel)
        );
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
