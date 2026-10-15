package ma.darconnect.model;

public abstract class Bien {
    private int idBien;
    private double surface;
    private int nbPieces;
    private int nbChambres;
    private int nbSallesDeBain;
    private Ville ville;
    private String quartier;
    private int ageBien;
    private boolean meuble;
    private double prixParMois;
    private boolean disponible;
    private int idProprietaire;
    private String imageUrl;

    protected Bien(int idBien, double surface, int nbPieces, int nbChambres, int nbSallesDeBain,
                   Ville ville, String quartier, int ageBien, boolean meuble,
                   double prixParMois, boolean disponible, int idProprietaire, String imageUrl) {
        this.idBien = idBien;
        this.surface = surface;
        this.nbPieces = nbPieces;
        this.nbChambres = nbChambres;
        this.nbSallesDeBain = nbSallesDeBain;
        this.ville = ville;
        this.quartier = quartier;
        this.ageBien = ageBien;
        this.meuble = meuble;
        this.prixParMois = prixParMois;
        this.disponible = disponible;
        this.idProprietaire = idProprietaire;
        this.imageUrl = imageUrl;
    }

    public abstract String getTypeBien();
    public abstract String getDetailsSpecifiques();

    public int getIdBien() { return idBien; }
    public void setIdBien(int idBien) { this.idBien = idBien; }
    public double getSurface() { return surface; }
    public void setSurface(double surface) { this.surface = surface; }
    public int getNbPieces() { return nbPieces; }
    public void setNbPieces(int nbPieces) { this.nbPieces = nbPieces; }
    public int getNbChambres() { return nbChambres; }
    public void setNbChambres(int nbChambres) { this.nbChambres = nbChambres; }
    public int getNbSallesDeBain() { return nbSallesDeBain; }
    public void setNbSallesDeBain(int nbSallesDeBain) { this.nbSallesDeBain = nbSallesDeBain; }
    public Ville getVille() { return ville; }
    public void setVille(Ville ville) { this.ville = ville; }
    public String getQuartier() { return quartier; }
    public void setQuartier(String quartier) { this.quartier = quartier; }
    public int getAgeBien() { return ageBien; }
    public void setAgeBien(int ageBien) { this.ageBien = ageBien; }
    public boolean isMeuble() { return meuble; }
    public void setMeuble(boolean meuble) { this.meuble = meuble; }
    public double getPrixParMois() { return prixParMois; }
    public void setPrixParMois(double prixParMois) { this.prixParMois = prixParMois; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public int getIdProprietaire() { return idProprietaire; }
    public void setIdProprietaire(int idProprietaire) { this.idProprietaire = idProprietaire; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
