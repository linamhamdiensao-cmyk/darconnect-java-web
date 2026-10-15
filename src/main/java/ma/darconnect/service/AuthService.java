package ma.darconnect.service;

import ma.darconnect.model.*;
import ma.darconnect.repository.DataStore;
import java.util.Optional;

public class AuthService {
    public Optional<Utilisateur> login(String email, String password) {
        return DataStore.findUserByEmail(email).filter(u -> u.seConnecter(email, password));
    }

    public Locataire inscrireLocataire(String nom, String prenom, String email, String telephone, String password) {
        if (DataStore.findUserByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Cet email existe déjà.");
        }
        Locataire l = new Locataire(DataStore.nextUserId(), nom, prenom, email, telephone, password);
        DataStore.getUtilisateurs().add(l);
        return l;
    }
}
