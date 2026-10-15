package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import ma.darconnect.service.AuthService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final AuthService authService = new AuthService();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        authService.login(email, password).ifPresentOrElse(user -> {
            req.getSession().setAttribute("user", user);
            try { resp.sendRedirect(req.getContextPath() + "/"); } catch (IOException e) { throw new RuntimeException(e); }
        }, () -> {
            try {
                req.setAttribute("error", "Email ou mot de passe incorrect.");
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            } catch (Exception e) { throw new RuntimeException(e); }
        });
    }
}
