<%@ page import="java.util.List" %>
<%@ page import="com.example.biblioteca.domain.enums.Status" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

  <title>Cadastro de Usuarios</title>
</head>
<body>

<%
  List<Type> type = (List<Type>) request.getAttribute("type");
%>

<%@include file="navbar.jsp"%>
<div class="container">
  <% if (isAdmin){%>
  <br>
  <h1>Cadastrar Usuario</h1>
  <br>

  <div class="border rounded p-4">
    <h4 class="mb-3"></h4>
    <form action="/user/novo" method="POST">
      <div class="form-group">
        <label for="name">Nome do Usuario:</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="Nome do Usuario">
      </div>
      <br>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="text" class="form-control" name="email" id="email" placeholder="email@email.com">
      </div>
      <br>
      <div class="form-group">
        <label for="type">Tipo:</label>
        <select class="custom-select" name="type" id="type">
          <% for (Type tipos : type) { %>
          <option value="<%= tipos %>"><%= tipos %></option>
          <% } %>
        </select>
      </div>
      <br>
      <div class="form-group">
        <label for="password">Email:</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="password">
      </div>


      <br>

      <button type="submit" class="btn btn-success">Salvar</button>

    </form>
  </div>
  <%}else{%>
  <div class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
    Você não tem permissão para criar usuários.
  </div>
  <%}%>
</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>