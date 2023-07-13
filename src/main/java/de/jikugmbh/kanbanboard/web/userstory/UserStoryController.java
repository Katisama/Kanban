package de.jikugmbh.kanbanboard.web.userstory;

import de.jikugmbh.kanbanboard.backend.userstory.boundary.UserStoryBoundary;
import de.jikugmbh.kanbanboard.backend.userstory.control.UserStoryModelToEntityMapper;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


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

    @RequestMapping("/edit-user-story")
    public String editStory(@ModelAttribute UserStoryModel userStoryModel, Model model, HttpServletRequest request) {

        Long storyId = userStoryModel.getStoryId();
        Optional<UserStory> userStoryById = userStoryBoundary.getUserStoryById(storyId);
        if (userStoryById.isPresent()) {
            log.info("edit story: " + userStoryById.get());
            model.addAttribute("userStory", userStoryById.get());
        }
        HttpSession session = request.getSession();
        model.addAttribute("user", session.getAttribute("user"));

        prepareGuiModel(model);

        return ViewFragmentConstants.EDIT_USER_STORY;
    }

    @PostMapping("/update-story")
    public String updateStory(@ModelAttribute UserStory userStory, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        log.info("to update: " + userStory);
        UserStory saved = userStoryBoundary.save(userStory);
        log.info("updated: " + saved);
        model.addAttribute("user", session.getAttribute("user"));
        updateView(model);

        return ViewFragmentConstants.KANBAN;
    }

    @RequestMapping("/cancel")
    public String cancel(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.addAttribute("user", session.getAttribute("user"));
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
