<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ma.darconnect.model.*" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>Détail logement</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body><%
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

<% Bien b = (Bien) request.getAttribute("bien"); %>
<main class="container detail">
  <img class="detail-img" src="<%=b.getImageUrl()%>" alt="photo logement">
  <section class="detail-info"><span class="tag"><%=b.getTypeBien()%></span><h1><%=b.getTypeBien()%> à <%=b.getVille().label()%></h1><p class="muted">📍 <%=b.getQuartier()%></p><h2><%=String.format("%.0f", b.getPrixParMois())%> MAD / mois</h2><div class="features"><span><%=b.getSurface()%> m²</span><span><%=b.getNbPieces()%> pièce(s)</span><span><%=b.getNbChambres()%> chambre(s)</span><span><%=b.getNbSallesDeBain()%> SDB</span><span><%=b.isMeuble()?"Meublé":"Non meublé"%></span><span><%=b.getAgeBien()%> an(s)</span></div><p><%=b.getDetailsSpecifiques()%></p>
  <form class="reserve-box" method="post" action="<%=request.getContextPath()%>/reserver"><h3>Demander une réservation</h3><input type="hidden" name="idBien" value="<%=b.getIdBien()%>"><div class="grid2"><div><label>Date début</label><input type="date" name="dateDebut" required></div><div><label>Date fin</label><input type="date" name="dateFin" required></div></div><button class="btn primary full">Réserver</button></form>
  </section>
</main>
</body></html>
