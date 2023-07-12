package de.jikugmbh.kanbanboard.web.navbar;

import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryPoints;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryPrio;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryStatus;
import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class NavBarController {
    @RequestMapping("/new-project")
    public String getNewProject() {

        return "new-project";
    }
    @RequestMapping("/new-story")
    public String getNewUserStory(Model model) {

        prepareGuiModel(model);

        return "createnewuserstory";
    }



    @RequestMapping("/logout")
    public String logout() {

        return "sayonara";
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
