package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.ContextFactory;
import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.it_academy.jd2.service.api.IMessageService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    private final IMessageService messageService = ContextFactory.getBean(IMessageService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser user = (AuthUser) req.getSession().getAttribute("user");
        req.setAttribute("messages", messageService.getUserMessages(user.getUsername()));
        req.getRequestDispatcher("/WEB-INF/ui/user/chats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        messageService.sendMessage(Message.builder()
                .sender(((AuthUser) req.getSession().getAttribute("user")).getUsername())
                .receiver(req.getParameter("receiver"))
                .message(req.getParameter("message"))
                .dtSend(LocalDateTime.now())
                .build());
        resp.sendRedirect(req.getContextPath().concat("/ui/user/message"));
    }
}
