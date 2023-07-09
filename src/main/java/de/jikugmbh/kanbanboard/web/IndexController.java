package de.jikugmbh.kanbanboard.web;

import de.jikugmbh.kanbanboard.backend.user.boundary.UserBoundary;
import de.jikugmbh.kanbanboard.backend.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserBoundary userBoundary;

    @RequestMapping("/")
    public String getIndex(Model model) {

        Optional<User> optionalUser = userBoundary.getUserById(1L);
        if(!optionalUser.isEmpty()) {
            User user = optionalUser.get();
            model.addAttribute("User", user);
        }


        return "index";
    }

    @RequestMapping("/product")
    public String getProduct() {

        return "product";
    }
}
