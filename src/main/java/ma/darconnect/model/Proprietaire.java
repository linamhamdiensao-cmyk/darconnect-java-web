package ma.darconnect.model;

public class Proprietaire extends Utilisateur {
    public Proprietaire(int idUser, String nom, String prenom, String email, String telephone, String motDePasse) {
        super(idUser, nom, prenom, email, telephone, motDePasse);
    }
    @Override public String getRole() { return "PROPRIETAIRE"; }
}
