package ma.darconnect.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int idReservation;
    private int idLocataire;
    private int idBien;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nbMois;
    private double prixTotal;
    private StatutReservation statut;
    private LocalDate dateReservation;

    public Reservation(int idReservation, int idLocataire, int idBien, LocalDate dateDebut, LocalDate dateFin, double prixParMois) {
        this.idReservation = idReservation;
        this.idLocataire = idLocataire;
        this.idBien = idBien;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbMois = Math.max(1, (int) ChronoUnit.MONTHS.between(dateDebut.withDayOfMonth(1), dateFin.withDayOfMonth(1)));
        this.prixTotal = this.nbMois * prixParMois;
        this.statut = StatutReservation.EN_ATTENTE;
        this.dateReservation = LocalDate.now();
    }
    public void confirmer() { this.statut = StatutReservation.CONFIRMEE; }
    public void annuler() { this.statut = StatutReservation.ANNULEE; }
    public void terminer() { this.statut = StatutReservation.TERMINEE; }
    public int getIdReservation() { return idReservation; }
    public int getIdLocataire() { return idLocataire; }
    public int getIdBien() { return idBien; }
    public LocalDate getDateDebut() { return dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public int getNbMois() { return nbMois; }
    public double getPrixTotal() { return prixTotal; }
    public StatutReservation getStatut() { return statut; }
    public LocalDate getDateReservation() { return dateReservation; }
}
