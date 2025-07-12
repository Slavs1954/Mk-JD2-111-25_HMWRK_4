package controller;

import dto.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceFactory;
import service.api.IMessageService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    private final IMessageService messageService = ServiceFactory.getMessageService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        messageService.getUserMessages(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String message = req.getParameter("message");
        String receiver = req.getParameter("receiver");
        messageService.sendMessage(Message.builder()
                .sender(username)
                .receiver(receiver)
                .message(message)
                .dtSend(LocalDateTime.now())
                .build());
    }
}
