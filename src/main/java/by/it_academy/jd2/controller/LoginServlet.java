package by.it_academy.jd2.controller;

import by.it_academy.jd2.service.api.IAuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginServlet {

    private final IAuthService authService;

    LoginServlet(IAuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/ui/signIn")
    protected String doGet(){
        return "signIn";
    }

    @PostMapping("/api/login")
    protected String doPost(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){

        if(!authService.authenticate(username, password)) {
            model.addAttribute("errMsg", "Invalid username or password");
            return "signIn";
        }

        session.setAttribute("user", authService.getAuthUser(username, password));

        return "redirect:/ui/user/chats";

    }
}
