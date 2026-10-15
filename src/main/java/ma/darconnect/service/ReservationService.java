package ma.darconnect.service;

import ma.darconnect.model.*;
import ma.darconnect.repository.DataStore;
import java.time.LocalDate;
import java.util.*;

public class ReservationService {
    public Reservation reserver(int idLocataire, int idBien, LocalDate debut, LocalDate fin) {
        Bien bien = DataStore.findBienById(idBien).orElseThrow(() -> new IllegalArgumentException("Logement introuvable."));
        if (!bien.isDisponible()) throw new IllegalStateException("Ce logement n'est plus disponible.");
        if (debut == null || fin == null || !fin.isAfter(debut)) throw new IllegalArgumentException("Dates incorrectes.");
        Reservation r = new Reservation(DataStore.nextReservationId(), idLocataire, idBien, debut, fin, bien.getPrixParMois());
        DataStore.getReservations().add(r);
        return r;
    }

    public List<Reservation> all() { return DataStore.getReservations(); }
    public List<Reservation> byUser(int idUser) { return DataStore.reservationsByUser(idUser); }

    public void confirmer(int idReservation) {
        DataStore.getReservations().stream().filter(r -> r.getIdReservation()==idReservation).findFirst().ifPresent(r -> {
            r.confirmer();
            DataStore.findBienById(r.getIdBien()).ifPresent(b -> b.setDisponible(false));
        });
    }

    public void annuler(int idReservation) {
        DataStore.getReservations().stream().filter(r -> r.getIdReservation()==idReservation).findFirst().ifPresent(r -> {
            r.annuler();
            DataStore.findBienById(r.getIdBien()).ifPresent(b -> b.setDisponible(true));
        });
    }
}
