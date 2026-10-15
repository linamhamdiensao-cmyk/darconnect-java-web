package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import ma.darconnect.service.BienService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final BienService bienService = new BienService();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("biens", bienService.rechercher(req.getParameter("ville"), req.getParameter("type"), req.getParameter("prixMax"), req.getParameter("meuble"), req.getParameter("q")));
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}
