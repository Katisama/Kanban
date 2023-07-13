package de.jikugmbh.kanbanboard.web.login;

import de.jikugmbh.kanbanboard.backend.user.boundary.UserBoundary;
import de.jikugmbh.kanbanboard.backend.user.entity.User;
import de.jikugmbh.kanbanboard.web.login.model.UserModel;
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

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UserBoundary userBoundary;

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute UserModel userModel, Model model, HttpServletRequest request) {

        logger.info("user: " + userModel);

        Optional<User> userByEmail = userBoundary.getUserByEmail(userModel.getEmail());

        if(userByEmail.isPresent()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userByEmail.get());
            logger.info("session: " + session.getAttribute("user"));

        } else {
            return "login";
        }

        return "kanban";
    }
}
