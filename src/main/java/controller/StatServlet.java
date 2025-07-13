package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.UserCounterListener;
import service.ServiceFactory;
import service.api.IAuthService;
import service.api.IMessageService;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatServlet extends HttpServlet {

    private final IAuthService authService = ServiceFactory.getAuthService();
    private final IMessageService messageService = ServiceFactory.getMessageService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("userCount", authService.getUserCount());
        req.setAttribute("messageCount", messageService.getMessageCount());
        req.setAttribute("activeUserCount", UserCounterListener.getActiveUsers());

        req.getRequestDispatcher("/WEB-INF/ui/admin/statistics.jsp").forward(req, resp);
    }
}
