<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>Ajouter logement</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body><%
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

<main class="auth-wrap wide"><form class="auth-card" method="post"><h1>Ajouter un logement</h1><p class="muted">Formulaire simplifié. Les attributs spécifiques sont remplis par défaut selon le type.</p><% if(request.getAttribute("error")!=null){%><div class="error"><%=request.getAttribute("error")%></div><%}%>
<div class="grid2"><div><label>Type</label><select name="type"><option>Chambre</option><option>Studio</option><option>Appartement</option><option>Maison</option></select></div><div><label>Ville</label><select name="ville"><option>OUJDA</option><option>RABAT</option><option>CASABLANCA</option><option>NADOR</option></select></div></div>
<label>Quartier</label><input name="quartier" required><div class="grid2"><div><label>Surface</label><input name="surface" type="number" step="0.1" required></div><div><label>Prix/mois</label><input name="prix" type="number" required></div></div><div class="grid3"><div><label>Pièces</label><input name="pieces" type="number" value="1"></div><div><label>Chambres</label><input name="chambres" type="number" value="1"></div><div><label>SDB</label><input name="sdb" type="number" value="1"></div></div><label>Âge du bien</label><input name="age" type="number" value="0"><label>Image URL</label><input name="imageUrl" value="https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=1000&q=80"><label class="check"><input type="checkbox" name="meuble" checked> Meublé</label><button class="btn primary full">Enregistrer</button></form></main>
</body></html>
