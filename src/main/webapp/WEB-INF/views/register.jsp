<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>Inscription</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body><%
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

<main class="auth-wrap"><form class="auth-card" method="post"><h1>Créer un compte étudiant</h1><% if(request.getAttribute("error")!=null){%><div class="error"><%=request.getAttribute("error")%></div><%}%><div class="grid2"><div><label>Nom</label><input name="nom" required></div><div><label>Prénom</label><input name="prenom" required></div></div><label>Email</label><input name="email" type="email" required><label>Téléphone</label><input name="telephone" required><label>Mot de passe</label><input name="password" type="password" required><button class="btn primary full">S'inscrire</button></form></main>
</body></html>
