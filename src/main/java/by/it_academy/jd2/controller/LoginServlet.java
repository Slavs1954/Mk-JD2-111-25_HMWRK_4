package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.ContextFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.it_academy.jd2.service.api.IAuthService;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private final IAuthService authService = ContextFactory.getBean(IAuthService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/ui/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(!authService.authenticate(username, password)) {
            resp.sendRedirect(req.getContextPath().concat("/ui/signIn?errMsg=Invalid%20username%20or%20password"));
            return;
        }

        req.getSession().setAttribute("user", authService.getAuthUser(username, password));

        resp.sendRedirect(req.getContextPath().concat("/ui/user/chats"));

    }
}
