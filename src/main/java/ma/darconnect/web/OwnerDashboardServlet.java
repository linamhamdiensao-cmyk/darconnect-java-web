package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import ma.darconnect.service.*;

@WebServlet("/proprietaire")
public class OwnerDashboardServlet extends BaseServlet {
    private final BienService bienService = new BienService();
    private final ReservationService reservationService = new ReservationService();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!requireOwner(req, resp)) return;
        req.setAttribute("biens", bienService.byOwner(currentUser(req).getIdUser()));
        req.setAttribute("reservations", reservationService.all());
        req.getRequestDispatcher("/WEB-INF/views/proprietaire.jsp").forward(req, resp);
    }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!requireOwner(req, resp)) return;
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("idReservation"));
        if ("confirmer".equals(action)) reservationService.confirmer(id);
        if ("annuler".equals(action)) reservationService.annuler(id);
        resp.sendRedirect(req.getContextPath() + "/proprietaire");
    }
}
