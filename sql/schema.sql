CREATE DATABASE IF NOT EXISTS darconnect CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE darconnect;

CREATE TABLE utilisateur (
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(80) NOT NULL,
  prenom VARCHAR(80) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  telephone VARCHAR(30),
  mot_de_passe VARCHAR(255) NOT NULL,
  date_inscription DATE NOT NULL,
  role ENUM('LOCATAIRE','PROPRIETAIRE') NOT NULL
);

CREATE TABLE bien (
  id_bien INT PRIMARY KEY AUTO_INCREMENT,
  surface DOUBLE NOT NULL,
  nb_pieces INT NOT NULL,
  nb_chambres INT NOT NULL,
  nb_salles_de_bain INT NOT NULL,
  ville ENUM('CASABLANCA','RABAT','NADOR','OUJDA') NOT NULL,
  quartier VARCHAR(120) NOT NULL,
  age_bien INT NOT NULL,
  meuble BOOLEAN NOT NULL,
  prix_par_mois DOUBLE NOT NULL,
  type_bien ENUM('MAISON','APPARTEMENT','STUDIO','CHAMBRE') NOT NULL,
  disponible BOOLEAN NOT NULL,
  image_url TEXT,
  id_proprietaire INT NOT NULL,
  nb_etages INT,
  surface_jardin DOUBLE,
  nb_garages INT,
  etage INT,
  avec_balcon BOOLEAN,
  avec_parking BOOLEAN,
  avec_ascenseur BOOLEAN,
  salle_de_bain_privee BOOLEAN,
  charges_incluses BOOLEAN,
  CONSTRAINT fk_bien_proprietaire FOREIGN KEY (id_proprietaire) REFERENCES utilisateur(id_user)
);

CREATE TABLE reservation (
  id_reservation INT PRIMARY KEY AUTO_INCREMENT,
  id_locataire INT NOT NULL,
  id_bien INT NOT NULL,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  nb_mois INT NOT NULL,
  prix_total DOUBLE NOT NULL,
  statut ENUM('EN_ATTENTE','CONFIRMEE','ANNULEE','TERMINEE') NOT NULL,
  date_reservation DATE NOT NULL,
  CONSTRAINT fk_res_locataire FOREIGN KEY (id_locataire) REFERENCES utilisateur(id_user),
  CONSTRAINT fk_res_bien FOREIGN KEY (id_bien) REFERENCES bien(id_bien)
);
