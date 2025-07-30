package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.ContextFactory;
import by.it_academy.jd2.core.dto.ERole;
import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.it_academy.jd2.service.api.IAuthService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private final IAuthService authService = ContextFactory.getBean(IAuthService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/ui/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
        authService.add(User.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .fullName(req.getParameter("fullName"))
                .birthDate(LocalDate.parse(req.getParameter("dtBirth")))
                .registrationDate(LocalDateTime.now())
                .role(ERole.USER)
                .build());
        }
        catch(Exception e){
            resp.sendRedirect(req.getContextPath().concat("/ui/error?errMsg=").concat(e.getMessage()));
            return;
        }
        resp.sendRedirect(req.getContextPath().concat("/ui/signIn"));
    }
}
