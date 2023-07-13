package de.jikugmbh.kanbanboard.web.register;

import de.jikugmbh.kanbanboard.backend.user.boundary.UserBoundary;
import de.jikugmbh.kanbanboard.backend.user.control.UserRegisterModelToUserMapper;
import de.jikugmbh.kanbanboard.web.register.model.UserRegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final UserBoundary userBoundary;
    @RequestMapping("/register" )
    public String getRegister(Model model) {
        model.addAttribute("userRegisterModel", UserRegisterModel.builder().build());
        return "register";
    }

    @PostMapping("/register" )
    public String doRegister(@ModelAttribute UserRegisterModel userRegisterModel) {

        userBoundary.saveUser(new UserRegisterModelToUserMapper().apply(userRegisterModel));
        return "login";
    }
}

