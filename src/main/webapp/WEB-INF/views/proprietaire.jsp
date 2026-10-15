<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,ma.darconnect.model.*,ma.darconnect.repository.DataStore" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>Espace propriétaire</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body><%
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
    <% if (user == null) { %><a class="btn ghost" href="<%=request.getContextPath()%>/login">Connexion</a><a class="btn primary" href="<%=request.getContextPath()%>/register">Inscription</a><% } else { %><span class="hello">👋 <%=user.getPrenom()%> · <%=user.getRole()%></span><a class="btn ghost" href="<%=request.getContextPath()%>/logout">Déconnexion</a><% } %>
  </div>
</nav>
<% if (flash != null) { %><div class="flash"><%=flash%></div><% } %>

<main class="container"><div class="dashboard-head"><div><h1>Espace propriétaire</h1><p class="muted">Gérez vos annonces et les demandes de réservation.</p></div><a class="btn primary" href="<%=request.getContextPath()%>/ajouter-bien">+ Ajouter un logement</a></div>
<section class="panel"><h2>Mes logements</h2><div class="cards small-cards"><% List<Bien> biens=(List<Bien>)request.getAttribute("biens"); for(Bien b: biens){ %><article class="mini-card"><img src="<%=b.getImageUrl()%>"><h3><%=b.getTypeBien()%> · <%=b.getVille().label()%></h3><p><%=b.getQuartier()%> · <%=String.format("%.0f", b.getPrixParMois())%> MAD</p><span class="status"><%=b.isDisponible()?"Disponible":"Réservé"%></span></article><% } %></div></section>
<section class="panel"><h2>Demandes de réservation</h2><table class="table"><thead><tr><th>Client</th><th>Logement</th><th>Période</th><th>Total</th><th>Statut</th><th>Action</th></tr></thead><tbody><% List<Reservation> reservations=(List<Reservation>)request.getAttribute("reservations"); for(Reservation r: reservations){ Bien b=DataStore.findBienById(r.getIdBien()).orElse(null); Utilisateur u=DataStore.findUserById(r.getIdLocataire()).orElse(null); if(b!=null && b.getIdProprietaire()==user.getIdUser()){ %><tr><td><%=u!=null?u.getNomComplet():"Client"%></td><td><%=b.getTypeBien()%> - <%=b.getQuartier()%></td><td><%=r.getDateDebut()%> → <%=r.getDateFin()%></td><td><%=String.format("%.0f", r.getPrixTotal())%> MAD</td><td><span class="status"><%=r.getStatut()%></span></td><td><form class="inline" method="post"><input type="hidden" name="idReservation" value="<%=r.getIdReservation()%>"><button name="action" value="confirmer" class="btn small primary">Confirmer</button><button name="action" value="annuler" class="btn small ghost">Annuler</button></form></td></tr><% }} %></tbody></table></section>
</main></body></html>
