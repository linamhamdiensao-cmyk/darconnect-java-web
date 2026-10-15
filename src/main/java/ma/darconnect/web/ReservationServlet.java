package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import ma.darconnect.service.ReservationService;
import ma.darconnect.model.Locataire;

@WebServlet("/reserver")
public class ReservationServlet extends BaseServlet {
    private final ReservationService reservationService = new ReservationService();
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!requireLogin(req, resp)) return;
        if (!(currentUser(req) instanceof Locataire)) {
            req.getSession().setAttribute("flash", "Seul un locataire peut faire une réservation.");
            resp.sendRedirect(req.getContextPath() + "/bien?id=" + req.getParameter("idBien"));
            return;
        }
        try {
            int idBien = Integer.parseInt(req.getParameter("idBien"));
            reservationService.reserver(currentUser(req).getIdUser(), idBien, LocalDate.parse(req.getParameter("dateDebut")), LocalDate.parse(req.getParameter("dateFin")));
            req.getSession().setAttribute("flash", "Réservation envoyée au propriétaire.");
            resp.sendRedirect(req.getContextPath() + "/mes-reservations");
        } catch (Exception e) {
            req.getSession().setAttribute("flash", e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/bien?id=" + req.getParameter("idBien"));
        }
    }
}
