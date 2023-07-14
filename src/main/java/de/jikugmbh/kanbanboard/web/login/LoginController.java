package de.jikugmbh.kanbanboard.web.login;

import de.jikugmbh.kanbanboard.backend.user.boundary.UserBoundary;
import de.jikugmbh.kanbanboard.backend.user.entity.User;
import de.jikugmbh.kanbanboard.backend.userstory.boundary.UserStoryBoundary;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryStatus;
import de.jikugmbh.kanbanboard.backend.userstory.entity.UserStory;
import de.jikugmbh.kanbanboard.web.login.model.UserModel;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UserBoundary userBoundary;
    private final UserStoryBoundary userStoryBoundary;

    @RequestMapping("/login")
    public String getLogin() {
        return ViewFragmentConstants.LOGIN;
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute UserModel userModel, Model model, HttpServletRequest request) {

        logger.info("user: " + userModel);
        Optional<User> userByEmail = userBoundary.getUserByEmail(userModel.getEmail());
        HttpSession session = request.getSession();

        if(userByEmail.isPresent()) {
            addSessionAttributes(session, userByEmail);
            addSessionToModel(model, session);
            updateView(model);
        } else {
            logger.info("login not possible");
            return ViewFragmentConstants.LOGIN;
        }

        return ViewFragmentConstants.KANBAN;
    }

    private void addSessionAttributes(HttpSession session, Optional<User> userByEmail) {
        session.setAttribute("user", userByEmail.get());
        logger.info("session: " + session.getAttribute("user"));
    }

    private void addSessionToModel(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user") );
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
