package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.ContextFactory;

import by.it_academy.jd2.service.api.IStatService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.it_academy.jd2.service.api.IMessageService;


import java.io.IOException;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatServlet extends HttpServlet {

    private static final IStatService statService = ContextFactory.getBean(IStatService.class);
    private final IMessageService messageService = ContextFactory.getBean(IMessageService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("userCount", statService.getUserCount());
        req.setAttribute("messageCount", messageService.getMessageCount());
        req.setAttribute("activeUserCount", statService.getActiveUsers());

        req.getRequestDispatcher("/WEB-INF/ui/admin/statistics.jsp").forward(req, resp);
    }
}
