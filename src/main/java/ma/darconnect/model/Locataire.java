package ma.darconnect.model;

public class Locataire extends Utilisateur {
    public Locataire(int idUser, String nom, String prenom, String email, String telephone, String motDePasse) {
        super(idUser, nom, prenom, email, telephone, motDePasse);
    }
    @Override public String getRole() { return "LOCATAIRE"; }
}
