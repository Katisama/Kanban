package de.jikugmbh.kanbanboard.web.navbar;

import de.jikugmbh.kanbanboard.backend.userstory.boundary.UserStoryBoundary;
import de.jikugmbh.kanbanboard.backend.userstory.entity.*;
import de.jikugmbh.kanbanboard.web.userstory.model.UserStoryModel;
import de.jikugmbh.kanbanboard.web.view.ViewFragmentConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class NavBarController {

    private static final Logger log = LoggerFactory.getLogger(NavBarController.class);

    private final UserStoryBoundary userStoryBoundary;

    @RequestMapping("/new-project")
    public String getNewProject() {

        return ViewFragmentConstants.NEW_PROJECT;
    }
    @RequestMapping("/new-story")
    public String getNewUserStory(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        model.addAttribute("user", session.getAttribute("user") );

        model.addAttribute("userStoryModel", UserStoryModel
                .builder()
                .build());
        prepareGuiModel(model);

        updateView(model);

        return ViewFragmentConstants.CREATE_NEW_USER_STORY;
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


    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            session.invalidate();
        }
        return ViewFragmentConstants.LOGIN;
    }



    private void prepareGuiModel(Model model) {
        model.addAttribute("typeOpts", StoryType.values());
        model.addAttribute("storyPoints", StoryPoints.values());
        model.addAttribute("storyPrios", StoryPrio.values());
        model.addAttribute("storyStatus", StoryStatus.values());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String createdAt = dateTimeFormatter.format(LocalDate.now(ZoneId.systemDefault()));

        model.addAttribute("createdAt", createdAt);
        model.addAttribute("updatedAt", createdAt);
    }

}
