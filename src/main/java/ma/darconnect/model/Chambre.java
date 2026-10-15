package ma.darconnect.model;

public class Chambre extends Studio {
    private boolean salleDeBainPrivee;
    private boolean chargesIncluses;

    public Chambre(int idBien, double surface, Ville ville, String quartier, int ageBien, boolean meuble,
                   double prixParMois, boolean disponible, int idProprietaire, String imageUrl,
                   int etage, boolean avecBalcon, boolean avecParking, boolean avecAscenseur,
                   boolean salleDeBainPrivee, boolean chargesIncluses) {
        super(idBien, surface, 1, salleDeBainPrivee ? 1 : 0, ville, quartier, ageBien, meuble,
              prixParMois, disponible, idProprietaire, imageUrl, etage, avecBalcon, avecParking, avecAscenseur);
        this.salleDeBainPrivee = salleDeBainPrivee; this.chargesIncluses = chargesIncluses;
    }
    @Override public String getTypeBien() { return "Chambre"; }
    @Override public String getDetailsSpecifiques() {
        return "Chambre étudiant" + (salleDeBainPrivee ? ", salle de bain privée" : ", salle de bain partagée") + (chargesIncluses ? ", charges incluses" : "");
    }
    public boolean isSalleDeBainPrivee() { return salleDeBainPrivee; }
    public boolean isChargesIncluses() { return chargesIncluses; }
}
