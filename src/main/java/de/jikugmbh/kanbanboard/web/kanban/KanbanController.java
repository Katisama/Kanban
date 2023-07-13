package de.jikugmbh.kanbanboard.web.kanban;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KanbanController {

    @RequestMapping("/kanban")
    public String getKanban() {
        return "kanban";
    }
}
