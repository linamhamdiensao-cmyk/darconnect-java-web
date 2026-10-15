<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,ma.darconnect.model.*" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>DarConnect - Logements étudiants</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head>
<body><%
    ma.darconnect.model.Utilisateur user = (ma.darconnect.model.Utilisateur) session.getAttribute("user");
    String flash = (String) session.getAttribute("flash");
    if (flash != null) session.removeAttribute("flash");
%>
<nav class="navbar">
  <a class="brand" href="<%=request.getContextPath()%>/home"><span class="logo">D</span> DarConnect</a>
  <div class="navlinks">
    <a href="<%=request.getContextPath()%>/home">Logements</a>
    <% if (user != null && "LOCATAIRE".equals(user.getRole())) { %><a href="<%=request.getContextPath()%>/mes-reservations">Mes réservations</a><% } %>
    <% if (user != null && "PROPRIETAIRE".equals(user.getRole())) { %><a href="<%=request.getContextPath()%>/proprietaire">Espace propriétaire</a><% } %>
    <% if (user == null) { %>
      <a class="btn ghost" href="<%=request.getContextPath()%>/login">Connexion</a>
      <a class="btn primary" href="<%=request.getContextPath()%>/register">Inscription</a>
    <% } else { %>
      <span class="hello">👋 <%=user.getPrenom()%> · <%=user.getRole()%></span>
      <a class="btn ghost" href="<%=request.getContextPath()%>/logout">Déconnexion</a>
    <% } %>
  </div>
</nav>
<% if (flash != null) { %><div class="flash"><%=flash%></div><% } %>

<header class="hero">
  <div class="hero-text">
    <p class="badge">Plateforme Java Web · MVC · POO</p>
    <h1>Trouvez un logement étudiant facilement</h1>
    <p>Chambres, studios, appartements et maisons vérifiés. Recherche rapide par ville, type, prix et quartier.</p>
    <a class="btn primary big" href="#logements">Voir les logements</a>
  </div>
  <div class="hero-card"><h3>Pourquoi DarConnect ?</h3><ul><li>Interface simple et moderne</li><li>Réservation en ligne</li><li>Espace propriétaire</li><li>Architecture basée sur votre UML</li></ul></div>
</header>
<section class="search-panel">
<form method="get" action="<%=request.getContextPath()%>/home">
  <input name="q" placeholder="Quartier, ville, type..." value="<%=request.getParameter("q") != null ? request.getParameter("q") : ""%>">
  <select name="ville"><option value="">Toutes les villes</option><% for(Ville v: Ville.values()){ %><option value="<%=v.name()%>" <%=v.name().equals(request.getParameter("ville"))?"selected":""%>><%=v.label()%></option><% } %></select>
  <select name="type"><option value="">Tous les types</option><% for(String t: new String[]{"Chambre","Studio","Appartement","Maison"}){ %><option <%=t.equals(request.getParameter("type"))?"selected":""%>><%=t%></option><% } %></select>
  <input type="number" name="prixMax" placeholder="Prix max MAD" value="<%=request.getParameter("prixMax") != null ? request.getParameter("prixMax") : ""%>">
  <select name="meuble"><option value="">Meublé ?</option><option value="true">Oui</option><option value="false">Non</option></select>
  <button class="btn primary" type="submit">Rechercher</button>
</form>
</section>
<main class="container" id="logements">
  <div class="section-title"><h2>Logements disponibles</h2><p>Résultats selon vos critères.</p></div>
  <div class="cards">
  <% List<Bien> biens = (List<Bien>) request.getAttribute("biens"); if (biens == null || biens.isEmpty()) { %>
    <p class="empty">Aucun logement trouvé.</p>
  <% } else { for(Bien b: biens) { %>
    <article class="card">
      <img src="<%=b.getImageUrl()%>" alt="photo logement">
      <div class="card-body">
        <div class="card-top"><span class="tag"><%=b.getTypeBien()%></span><span class="price"><%=String.format("%.0f", b.getPrixParMois())%> MAD/mois</span></div>
        <h3><%=b.getTypeBien()%> à <%=b.getVille().label()%></h3>
        <p class="muted">📍 <%=b.getQuartier()%> · <%=b.getSurface()%> m² · <%=b.getNbPieces()%> pièce(s)</p>
        <p><%=b.getDetailsSpecifiques()%></p>
        <div class="actions"><a class="btn primary" href="<%=request.getContextPath()%>/bien?id=<%=b.getIdBien()%>">Détails</a><span class="mini"><%=b.isMeuble()?"Meublé":"Non meublé"%></span></div>
      </div>
    </article>
  <% }} %>
  </div>
</main>
<footer>© DarConnect · Projet Java Web pour gestion de logement étudiant</footer>
</body></html>
