package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.ContextFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.service.api.IMessageService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/ui/*"})
public class UiDispatcherServlet extends HttpServlet {

    private final IAuthService authService = ContextFactory.getBean(IAuthService.class);
    private final IMessageService messageService = ContextFactory.getBean(IMessageService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String servletPath = req.getServletPath();


        if (path == null || path.isEmpty()) {
            path = "/";
        }
        if (servletPath.equals("/")) {
            resp.sendRedirect(req.getContextPath().concat("/ui"));
            return;
        }


        String jspPath = "index.jsp";

        switch (path) {
            case "/", "/ui":
                break;
            case "/signIn":
                req.setAttribute("errMsg", req.getParameter("errMsg"));
                jspPath = "signIn.jsp";
                break;
            case "/signUp":
                req.setAttribute("errMsg", req.getParameter("errMsg"));
                jspPath = "signUp.jsp";
                break;
            case "/user/message":
                req.setAttribute("receivers", authService.getOtherUsernames(req.getSession()
                        .getAttribute("user").toString()));
                jspPath = "user/message.jsp";
                break;
            case "/user/chats":
                req.getRequestDispatcher("/api/message").forward(req, resp);
                return;
            case "/admin/statistics":
                req.getRequestDispatcher("/api/admin/statistics").forward(req, resp);
                return;
            case "/error":
                req.setAttribute("errMsg", req.getParameter("errMsg"));
                jspPath = "error.jsp";
                break;
            default:
                req.setAttribute("errMsg", "404 - Unknown page");
                jspPath = "error.jsp";
                break;
        }
        req.getRequestDispatcher("/WEB-INF/ui/".concat(jspPath)).forward(req, resp);

    }
}
