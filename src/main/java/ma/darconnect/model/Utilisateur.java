package ma.darconnect.model;

import java.time.LocalDate;

public abstract class Utilisateur {
    private int idUser;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String motDePasse;
    private LocalDate dateInscription;

    protected Utilisateur(int idUser, String nom, String prenom, String email, String telephone, String motDePasse) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.dateInscription = LocalDate.now();
    }

    public abstract String getRole();

    public boolean seConnecter(String email, String motDePasse) {
        return this.email.equalsIgnoreCase(email) && this.motDePasse.equals(motDePasse);
    }

    public String getNomComplet() { return prenom + " " + nom; }
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { this.dateInscription = dateInscription; }
}
