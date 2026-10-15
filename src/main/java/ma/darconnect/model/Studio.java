package ma.darconnect.model;

public class Studio extends Appartement {
    public Studio(int idBien, double surface, int nbChambres, int nbSallesDeBain, Ville ville, String quartier,
                  int ageBien, boolean meuble, double prixParMois, boolean disponible, int idProprietaire,
                  String imageUrl, int etage, boolean avecBalcon, boolean avecParking, boolean avecAscenseur) {
        super(idBien, surface, 1, nbChambres, nbSallesDeBain, ville, quartier, ageBien, meuble,
              prixParMois, disponible, idProprietaire, imageUrl, etage, avecBalcon, avecParking, avecAscenseur);
    }
    @Override public String getTypeBien() { return "Studio"; }
}
