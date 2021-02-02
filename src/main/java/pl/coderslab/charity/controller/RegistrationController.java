package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "index";
    }
}
