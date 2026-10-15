# DarConnect — Site web Java pour logement étudiant

DarConnect est un site web Java basé sur votre diagramme UML/MCD : les étudiants peuvent chercher un logement, voir les détails et faire une réservation. Les propriétaires peuvent ajouter des logements et gérer les demandes.

## Technologies

- Java 17
- Jakarta Servlet 6
- JSP
- HTML / CSS moderne
- Architecture MVC + Service + Repository
- Données en mémoire pour le test rapide
- Script SQL inclus pour MySQL

## Comptes de démonstration

| Rôle | Email | Mot de passe |
|---|---|---|
| Locataire | `yassine.client@loc.ma` | `client123` |
| Locataire | `imane.client@loc.ma` | `client123` |
| Propriétaire | `karim.proprio@loc.ma` | `admin123` |
| Propriétaire | `salma.proprio@loc.ma` | `admin123` |

## Fonctionnalités

### Côté étudiant / locataire

- Consultation des logements disponibles
- Recherche par ville, type, prix maximum, meublé et mot-clé
- Page de détail du logement
- Demande de réservation avec date début et date fin
- Consultation de ses réservations

### Côté propriétaire

- Tableau de bord propriétaire
- Consultation de ses logements
- Ajout d'un nouveau logement
- Confirmation ou annulation des réservations

## Exécution avec Eclipse + Tomcat

1. Installer JDK 17.
2. Installer Apache Tomcat 10 ou 10.1.
3. Installer Eclipse IDE for Enterprise Java and Web Developers.
4. Importer le projet : `File > Import > Existing Maven Projects`.
5. Choisir le dossier `DarConnect_Java_Web`.
6. Clic droit sur le projet > `Run As > Run on Server`.
7. Choisir Tomcat 10.
8. Ouvrir : `http://localhost:8080/darconnect/`.

## Exécution avec Maven

```bash
mvn clean package
```

Le fichier généré sera :

```text
target/darconnect.war
```

Copiez ce fichier dans le dossier `webapps` de Tomcat puis lancez Tomcat.

## Structure importante

```text
src/main/java/ma/darconnect/model       Classes POO : Bien, Maison, Appartement, Studio, Chambre, Utilisateur...
src/main/java/ma/darconnect/service     Logique métier
src/main/java/ma/darconnect/repository  Données de démonstration
src/main/java/ma/darconnect/web         Servlets / Controllers
src/main/webapp/WEB-INF/views           Pages JSP
src/main/webapp/assets/css/style.css    Décoration du site
sql/schema.sql                          MLD SQL MySQL
```

## Remarque importante

La version actuelle utilise une liste en mémoire (`DataStore`) pour faciliter la démonstration devant le professeur. Le fichier SQL est fourni pour connecter MySQL plus tard avec JDBC.
