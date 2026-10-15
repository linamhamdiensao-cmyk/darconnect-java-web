package ma.darconnect.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import ma.darconnect.service.ReservationService;

@WebServlet("/mes-reservations")
public class MesReservationsServlet extends BaseServlet {
    private final ReservationService reservationService = new ReservationService();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!requireLogin(req, resp)) return;
        req.setAttribute("reservations", reservationService.byUser(currentUser(req).getIdUser()));
        req.getRequestDispatcher("/WEB-INF/views/mes-reservations.jsp").forward(req, resp);
    }
}
