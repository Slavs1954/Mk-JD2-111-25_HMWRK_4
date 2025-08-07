package by.it_academy.jd2.controller;

import by.it_academy.jd2.service.api.IAuthService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(path = {"/ui/login", "/api/login"})
public class LoginServlet {

    private final IAuthService authService;

    LoginServlet(IAuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/ui/login")
    protected String doGet(){
        return "signIn";
    }

    @PostMapping("/api/login")
    protected String doPost(@RequestParam("username") String username, @RequestParam("password") String password, Model model, RedirectAttributes redirectAttributes){

        if(!authService.authenticate(username, password)) {
            redirectAttributes.addAttribute("errMsg", "Invalid username or password");
            return "error";
        }

        model.addAttribute("user", authService.getAuthUser(username, password));
        return "redirect:/ui/user/chats";

    }
}
