package ma.darconnect.model;

public class Appartement extends Bien {
    private int etage;
    private boolean avecBalcon;
    private boolean avecParking;
    private boolean avecAscenseur;

    public Appartement(int idBien, double surface, int nbPieces, int nbChambres, int nbSallesDeBain,
                       Ville ville, String quartier, int ageBien, boolean meuble,
                       double prixParMois, boolean disponible, int idProprietaire, String imageUrl,
                       int etage, boolean avecBalcon, boolean avecParking, boolean avecAscenseur) {
        super(idBien, surface, nbPieces, nbChambres, nbSallesDeBain, ville, quartier, ageBien, meuble, prixParMois, disponible, idProprietaire, imageUrl);
        this.etage = etage; this.avecBalcon = avecBalcon; this.avecParking = avecParking; this.avecAscenseur = avecAscenseur;
    }
    @Override public String getTypeBien() { return "Appartement"; }
    @Override public String getDetailsSpecifiques() {
        return "Étage " + etage + (avecBalcon ? ", balcon" : "") + (avecParking ? ", parking" : "") + (avecAscenseur ? ", ascenseur" : "");
    }
    public int getEtage() { return etage; }
    public boolean isAvecBalcon() { return avecBalcon; }
    public boolean isAvecParking() { return avecParking; }
    public boolean isAvecAscenseur() { return avecAscenseur; }
}
