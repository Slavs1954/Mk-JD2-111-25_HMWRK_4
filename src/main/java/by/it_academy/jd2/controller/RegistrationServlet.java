package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.dto.ERole;
import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.http.HttpServlet;
import by.it_academy.jd2.service.api.IAuthService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = {"/ui/user", "/api/user"})
public class RegistrationServlet extends HttpServlet {

    private final IAuthService authService;

    RegistrationServlet(IAuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/ui/user")
    protected String doGet() {
        return "signUp";
    }

    @PostMapping("/api/user")
    protected String doPost(@RequestParam("username") String username, @RequestParam("password") String password,
                          @RequestParam("fullName") String fullName, @RequestParam("dtBirth") LocalDate dtBirth, RedirectAttributes redirectAttributes) {

        try{
        authService.add(User.builder()
                .username(username)
                .password(password)
                .fullName(fullName)
                .birthDate(dtBirth)
                .registrationDate(LocalDateTime.now())
                .role(ERole.USER)
                .build());
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("errMsg", e.getMessage());
            return "error";
        }

        return "redirect:/ui/signIn";
    }
}
