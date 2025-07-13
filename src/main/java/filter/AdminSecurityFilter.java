package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ServiceFactory;
import service.api.IAuthService;


import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    private final IAuthService authService = ServiceFactory.getAuthService();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if(session != null && session.getAttribute("user") != null
                && authService.isAdmin(session.getAttribute("user").toString())) {
            chain.doFilter(request, response);
        }
        else  {
            res.sendRedirect(req.getContextPath() + "/signIn");
        }
    }
}
