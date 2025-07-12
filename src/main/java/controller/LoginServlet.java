package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceFactory;
import service.api.IAuthService;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private final IAuthService authService = ServiceFactory.getAuthService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        req.getRequestDispatcher("../WEB-INF/ui/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(authService.authenticateUser(username, password)) {
            req.getSession().setAttribute("user", username);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/ui/login_fail.jsp").forward(req, resp);
        }

    }
}
