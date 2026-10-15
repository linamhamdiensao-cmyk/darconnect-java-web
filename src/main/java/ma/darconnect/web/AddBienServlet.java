package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import ma.darconnect.model.Ville;
import ma.darconnect.service.BienService;

@WebServlet("/ajouter-bien")
public class AddBienServlet extends BaseServlet {
    private final BienService bienService = new BienService();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!requireOwner(req, resp)) return;
        req.getRequestDispatcher("/WEB-INF/views/ajouter-bien.jsp").forward(req, resp);
    }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!requireOwner(req, resp)) return;
        try {
            bienService.ajouterSimple(req.getParameter("type"), Ville.valueOf(req.getParameter("ville")), req.getParameter("quartier"),
                    Double.parseDouble(req.getParameter("surface")), Integer.parseInt(req.getParameter("pieces")), Integer.parseInt(req.getParameter("chambres")),
                    Integer.parseInt(req.getParameter("sdb")), Integer.parseInt(req.getParameter("age")), "on".equals(req.getParameter("meuble")),
                    Double.parseDouble(req.getParameter("prix")), currentUser(req).getIdUser(), req.getParameter("imageUrl"));
            resp.sendRedirect(req.getContextPath() + "/proprietaire");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/ajouter-bien.jsp").forward(req, resp);
        }
    }
}
