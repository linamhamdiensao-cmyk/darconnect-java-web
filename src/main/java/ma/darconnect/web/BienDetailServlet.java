package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import ma.darconnect.service.BienService;

@WebServlet("/bien")
public class BienDetailServlet extends HttpServlet {
    private final BienService bienService = new BienService();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        var bien = bienService.find(id).orElse(null);
        if (bien == null) { resp.sendError(404); return; }
        req.setAttribute("bien", bien);
        req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
    }
}
