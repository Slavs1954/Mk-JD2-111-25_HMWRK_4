package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.service.AuthService;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.service.api.IMessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class MessageServlet {

    private final IMessageService messageService;
    private final IAuthService authService;

    MessageServlet(IMessageService messageService, IAuthService authService) {
        this.messageService = messageService;
        this.authService = authService;
    }

    @GetMapping("/ui/user/message")
    protected String getMessageForm(Model model, HttpSession session) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        model.addAttribute("receivers", authService.getOtherUsernames(user.getUsername()));
        return "user/message";
    }

    @GetMapping("/ui/user/chats")
    protected String showChats( HttpSession session, Model model) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        model.addAttribute("messages", messageService.getUserMessages(user.getUsername()));
        return "user/chats";
    }

    @PostMapping("/api/message")
    protected String doPost(@RequestParam("receiver") String receiver, @RequestParam("message") String message, HttpSession session) {
        messageService.sendMessage(Message.builder()
                .sender(((AuthUser) session.getAttribute("user")).getUsername())
                .receiver(receiver)
                .message(message)
                .dtSend(LocalDateTime.now())
                .build());
        return "redirect:/ui/user/message";
    }
}
