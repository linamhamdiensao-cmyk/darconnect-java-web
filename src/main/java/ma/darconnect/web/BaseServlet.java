package ma.darconnect.web;

import jakarta.servlet.http.*;
import java.io.IOException;
import ma.darconnect.model.Utilisateur;

public abstract class BaseServlet extends HttpServlet {
    protected Utilisateur currentUser(HttpServletRequest req) {
        return (Utilisateur) req.getSession().getAttribute("user");
    }
    protected boolean requireLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (currentUser(req) == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return false;
        }
        return true;
    }
    protected boolean requireOwner(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!requireLogin(req, resp)) return false;
        if (!"PROPRIETAIRE".equals(currentUser(req).getRole())) {
            resp.sendRedirect(req.getContextPath() + "/");
            return false;
        }
        return true;
    }
}
