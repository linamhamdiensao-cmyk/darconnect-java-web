# Architecture DarConnect Java Web

Projet basé sur le diagramme fourni :

- `Utilisateur` est une classe abstraite.
  - `Locataire` hérite de `Utilisateur`.
  - `Proprietaire` hérite de `Utilisateur`.
- `Bien` est une classe abstraite.
  - `Maison` hérite de `Bien`.
  - `Appartement` hérite de `Bien`.
  - `Studio` hérite de `Appartement`.
  - `Chambre` hérite de `Studio`.
- `Reservation` relie un locataire à un bien.

Architecture du site :

```text
JSP Views  ->  Servlets Controllers  ->  Services  ->  Repository en mémoire  ->  Models
```

Le repository est en mémoire pour que le projet soit facile à lancer. Le fichier `sql/schema.sql` prépare la migration vers MySQL.
