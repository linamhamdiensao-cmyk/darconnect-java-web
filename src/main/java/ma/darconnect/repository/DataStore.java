package ma.darconnect.repository;

import ma.darconnect.model.*;
import java.util.*;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataStore {
    private static final List<Utilisateur> utilisateurs = new ArrayList<>();
    private static final List<Bien> biens = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final AtomicInteger seqUser = new AtomicInteger(1);
    private static final AtomicInteger seqBien = new AtomicInteger(1);
    private static final AtomicInteger seqReservation = new AtomicInteger(1);

    static { initialiser(); }

    private static void initialiser() {
        Proprietaire p1 = new Proprietaire(seqUser.getAndIncrement(), "Bennani", "Karim", "karim.proprio@loc.ma", "0600000001", "admin123");
        Proprietaire p2 = new Proprietaire(seqUser.getAndIncrement(), "Alaoui", "Salma", "salma.proprio@loc.ma", "0600000002", "admin123");
        Locataire l1 = new Locataire(seqUser.getAndIncrement(), "Amrani", "Yassine", "yassine.client@loc.ma", "0600000003", "client123");
        Locataire l2 = new Locataire(seqUser.getAndIncrement(), "Fadili", "Imane", "imane.client@loc.ma", "0600000004", "client123");
        Collections.addAll(utilisateurs, p1, p2, l1, l2);

        biens.add(new Chambre(seqBien.getAndIncrement(), 18, Ville.OUJDA, "Al Qods", 5, true, 950, true, p1.getIdUser(),
                "https://images.unsplash.com/photo-1555854877-bab0e564b8d5?auto=format&fit=crop&w=1000&q=80", 2, false, false, true, true, true));
        biens.add(new Studio(seqBien.getAndIncrement(), 32, 1, 1, Ville.OUJDA, "Hay Al Fath", 2, true, 1800, true, p1.getIdUser(),
                "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=1000&q=80", 3, true, true, true));
        biens.add(new Appartement(seqBien.getAndIncrement(), 70, 3, 2, 1, Ville.RABAT, "Agdal", 8, false, 4200, true, p2.getIdUser(),
                "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=1000&q=80", 4, true, true, true));
        biens.add(new Maison(seqBien.getAndIncrement(), 120, 5, 3, 2, Ville.NADOR, "Centre", 12, false, 5500, true, p2.getIdUser(),
                "https://images.unsplash.com/photo-1564013799919-ab600027ffc6?auto=format&fit=crop&w=1000&q=80", 2, 40, 1));
        biens.add(new Chambre(seqBien.getAndIncrement(), 15, Ville.OUJDA, "Centre ville", 10, true, 800, true, p2.getIdUser(),
                "https://images.unsplash.com/photo-1586023492125-27b2c045efd7?auto=format&fit=crop&w=1000&q=80", 1, false, false, false, false, true));
        biens.add(new Studio(seqBien.getAndIncrement(), 28, 1, 1, Ville.CASABLANCA, "Maarif", 4, true, 2600, true, p1.getIdUser(),
                "https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?auto=format&fit=crop&w=1000&q=80", 5, true, false, true));

        Reservation r = new Reservation(seqReservation.getAndIncrement(), l1.getIdUser(), 1, LocalDate.now().plusDays(5), LocalDate.now().plusMonths(4), 950);
        reservations.add(r);
    }

    public static List<Utilisateur> getUtilisateurs() { return utilisateurs; }
    public static List<Bien> getBiens() { return biens; }
    public static List<Reservation> getReservations() { return reservations; }
    public static int nextUserId() { return seqUser.getAndIncrement(); }
    public static int nextBienId() { return seqBien.getAndIncrement(); }
    public static int nextReservationId() { return seqReservation.getAndIncrement(); }

    public static Optional<Utilisateur> findUserByEmail(String email) {
        return utilisateurs.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
    }
    public static Optional<Utilisateur> findUserById(int id) {
        return utilisateurs.stream().filter(u -> u.getIdUser()==id).findFirst();
    }
    public static Optional<Bien> findBienById(int id) {
        return biens.stream().filter(b -> b.getIdBien()==id).findFirst();
    }
    public static List<Reservation> reservationsByUser(int idUser) {
        return reservations.stream().filter(r -> r.getIdLocataire()==idUser).collect(Collectors.toList());
    }
    public static List<Bien> biensByOwner(int idUser) {
        return biens.stream().filter(b -> b.getIdProprietaire()==idUser).collect(Collectors.toList());
    }
}
