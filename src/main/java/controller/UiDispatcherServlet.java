package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceFactory;
import service.api.IAuthService;
import service.api.IMessageService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/ui/*"})
public class UiDispatcherServlet extends HttpServlet {

    private final IAuthService authService = ServiceFactory.getAuthService();
    private final IMessageService messageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path == null || path.isEmpty() || path.equals("/")) {
            path = "/";
        }
        String jspPath = "index.jsp";

        switch (path) {
            case "/":
                resp.sendRedirect(req.getContextPath().concat("/ui"));
                return;
            case "/ui":
                break;
            case "/signIn":
                jspPath = "signIn.jsp";
                break;
            case "/signUp":
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
            default:
                req.setAttribute("errMsg", "404 - Unknown page");
                jspPath = "error.jsp";
                break;
        }
        req.getRequestDispatcher("/WEB-INF/ui/".concat(jspPath)).forward(req, resp);

    }
}
