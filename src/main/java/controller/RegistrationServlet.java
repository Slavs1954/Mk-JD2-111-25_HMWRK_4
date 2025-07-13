package controller;

import dto.ERole;
import dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceFactory;
import service.api.IAuthService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private final IAuthService authService = ServiceFactory.getAuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        req.getRequestDispatcher("/WEB-INF/ui/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullName");
        LocalDate birthDate = LocalDate.parse(req.getParameter("dtBirth"));

        authService.add(User.builder()
                .username(username)
                .password(password)
                .fullName(fullname)
                .birthDate(birthDate)
                .registrationDate(LocalDateTime.now())
                .role(ERole.USER)
                .build());
        resp.sendRedirect(req.getContextPath().concat("/ui/signIn"));
    }
}
