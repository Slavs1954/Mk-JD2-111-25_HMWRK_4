package by.it_academy.jd2.controller;

import by.it_academy.jd2.service.api.IStatService;
import jakarta.servlet.http.HttpServlet;
import by.it_academy.jd2.service.api.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class StatServlet extends HttpServlet {

    private final IStatService statService;
    private final IMessageService messageService;

    StatServlet(IStatService statService, IMessageService messageService) {
        this.statService = statService;
        this.messageService = messageService;
    }

    @GetMapping("/ui/admin/statistics")
    protected String doGet(Model model) {

        model.addAttribute("userCount", statService.getUserCount());
        model.addAttribute("messageCount", messageService.getMessageCount());
        model.addAttribute("activeUserCount", statService.getActiveUsers());

        return "admin/statistics";
    }
}
