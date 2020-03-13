package com.easyyu.web;

import com.easyyu.security.TokenProvider;
import com.easyyu.users.User;
import com.easyyu.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, User user) {
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping(value = "/dashboard")
    public String getToken(Model model, Authentication auth) {
        User user = userService.findByUsername(auth.getName());

        // check if token is generated, if not generate it for the user
        if (user.getToken() == null) {
            String token = tokenProvider.generateToken(user.getUsername());
            userService.setToken(token, user.getUsername());
            model.addAttribute("user", user);
        } else {
            System.out.println("User already has a token");
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String user(Model model, Authentication auth) {
        User user = userService.findByUsername(auth.getName());
        model.addAttribute("user", user);
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/signup")
    public String signUpView(Model model, User user) {
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(Model model, User user) {
        userService.save(user);
        return "success";
    }
}
