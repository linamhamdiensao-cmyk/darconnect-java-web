package ma.darconnect.model;

public class Maison extends Bien {
    private int nbEtages;
    private double surfaceJardin;
    private int nbGarages;

    public Maison(int idBien, double surface, int nbPieces, int nbChambres, int nbSallesDeBain,
                  Ville ville, String quartier, int ageBien, boolean meuble,
                  double prixParMois, boolean disponible, int idProprietaire, String imageUrl,
                  int nbEtages, double surfaceJardin, int nbGarages) {
        super(idBien, surface, nbPieces, nbChambres, nbSallesDeBain, ville, quartier, ageBien, meuble, prixParMois, disponible, idProprietaire, imageUrl);
        this.nbEtages = nbEtages; this.surfaceJardin = surfaceJardin; this.nbGarages = nbGarages;
    }
    @Override public String getTypeBien() { return "Maison"; }
    @Override public String getDetailsSpecifiques() { return nbEtages + " étage(s), jardin " + surfaceJardin + " m², " + nbGarages + " garage(s)"; }
    public int getNbEtages() { return nbEtages; }
    public double getSurfaceJardin() { return surfaceJardin; }
    public int getNbGarages() { return nbGarages; }
}
