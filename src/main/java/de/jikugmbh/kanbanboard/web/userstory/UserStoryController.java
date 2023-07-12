package de.jikugmbh.kanbanboard.web.userstory;

import de.jikugmbh.kanbanboard.web.userstory.model.UserStory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserStoryController {

    private static final Logger logger = LoggerFactory.getLogger(UserStoryController.class);

    @PostMapping("/save-story")
    public String createNew(@ModelAttribute UserStory userStory) {


            logger.info(userStory.getDescription());




        return "kanban";
    }

}