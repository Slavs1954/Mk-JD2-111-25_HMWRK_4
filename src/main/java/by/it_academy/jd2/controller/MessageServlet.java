package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.service.api.IMessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = {"/ui/message", "/api/message"})
public class MessageServlet {

    private final IMessageService messageService;

    MessageServlet(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/ui/message")
    protected String doGet(@RequestParam("user") AuthUser user, Model model) {
        model.addAttribute("messages", messageService.getUserMessages(user.getUsername()));
        return "chats";
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
