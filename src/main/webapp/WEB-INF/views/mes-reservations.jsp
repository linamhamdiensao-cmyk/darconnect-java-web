<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,ma.darconnect.model.*,ma.darconnect.repository.DataStore" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>Mes réservations</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body><%
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

<main class="container"><div class="section-title"><h1>Mes réservations</h1><p>Suivez les demandes envoyées aux propriétaires.</p></div>
<table class="table"><thead><tr><th>Logement</th><th>Période</th><th>Mois</th><th>Total</th><th>Statut</th></tr></thead><tbody>
<% List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations"); for(Reservation r: reservations){ Bien b=DataStore.findBienById(r.getIdBien()).orElse(null); %>
<tr><td><%=b!=null?b.getTypeBien()+" - "+b.getQuartier():"Logement"%></td><td><%=r.getDateDebut()%> → <%=r.getDateFin()%></td><td><%=r.getNbMois()%></td><td><%=String.format("%.0f", r.getPrixTotal())%> MAD</td><td><span class="status"><%=r.getStatut()%></span></td></tr>
<% } %>
</tbody></table></main></body></html>
