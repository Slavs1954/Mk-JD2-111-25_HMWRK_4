package by.it_academy.jd2.filter;

import by.it_academy.jd2.core.ContextFactory;
import by.it_academy.jd2.core.dto.AuthUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import by.it_academy.jd2.service.api.IAuthService;


import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    private final IAuthService authService = ContextFactory.getBean(IAuthService.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if(session != null && session.getAttribute("user") != null
                && authService.isAdmin(((AuthUser) session.getAttribute("user")))) {
            chain.doFilter(request, response);
        }
        else  {
            res.sendRedirect(req.getContextPath() + "/signIn");
        }
    }
}
