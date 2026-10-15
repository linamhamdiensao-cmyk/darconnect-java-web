<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html><html lang="fr"><head><meta charset="UTF-8"><title>Connexion</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body><%
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

<main class="auth-wrap"><form class="auth-card" method="post"><h1>Connexion</h1><p class="muted">Comptes démo : yassine.client@loc.ma / client123 ou karim.proprio@loc.ma / admin123</p><% if(request.getAttribute("error")!=null){%><div class="error"><%=request.getAttribute("error")%></div><%}%><label>Email</label><input name="email" type="email" required><label>Mot de passe</label><input name="password" type="password" required><button class="btn primary full">Se connecter</button><p>Pas encore de compte ? <a href="<%=request.getContextPath()%>/register">Créer un compte locataire</a></p></form></main>
</body></html>
