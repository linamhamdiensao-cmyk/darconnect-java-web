package ma.darconnect.service;

import ma.darconnect.model.*;
import ma.darconnect.repository.DataStore;
import java.util.*;
import java.util.stream.Collectors;

public class BienService {
    public List<Bien> rechercher(String ville, String type, String prixMax, String meuble, String q) {
        return DataStore.getBiens().stream()
                .filter(Bien::isDisponible)
                .filter(b -> ville == null || ville.isBlank() || b.getVille().name().equalsIgnoreCase(ville))
                .filter(b -> type == null || type.isBlank() || b.getTypeBien().equalsIgnoreCase(type))
                .filter(b -> prixMax == null || prixMax.isBlank() || b.getPrixParMois() <= Double.parseDouble(prixMax))
                .filter(b -> meuble == null || meuble.isBlank() || Boolean.toString(b.isMeuble()).equals(meuble))
                .filter(b -> q == null || q.isBlank() || (b.getQuartier() + " " + b.getVille().name() + " " + b.getTypeBien()).toLowerCase().contains(q.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Bien> all() { return DataStore.getBiens(); }
    public Optional<Bien> find(int id) { return DataStore.findBienById(id); }
    public List<Bien> byOwner(int ownerId) { return DataStore.biensByOwner(ownerId); }

    public Bien ajouterSimple(String type, Ville ville, String quartier, double surface, int pieces, int chambres, int sdb,
                              int age, boolean meuble, double prix, int ownerId, String imageUrl) {
        int id = DataStore.nextBienId();
        Bien b;
        if ("Maison".equalsIgnoreCase(type)) {
            b = new Maison(id, surface, pieces, chambres, sdb, ville, quartier, age, meuble, prix, true, ownerId, imageUrl, 1, 20, 0);
        } else if ("Chambre".equalsIgnoreCase(type)) {
            b = new Chambre(id, surface, ville, quartier, age, meuble, prix, true, ownerId, imageUrl, 1, false, false, false, true, true);
        } else if ("Studio".equalsIgnoreCase(type)) {
            b = new Studio(id, surface, 1, 1, ville, quartier, age, meuble, prix, true, ownerId, imageUrl, 1, true, false, true);
        } else {
            b = new Appartement(id, surface, pieces, chambres, sdb, ville, quartier, age, meuble, prix, true, ownerId, imageUrl, 1, true, true, true);
        }
        DataStore.getBiens().add(b);
        return b;
    }
}
