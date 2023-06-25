<%@ page import="com.example.biblioteca.domain.entities.User" %>
<%@ page import="com.example.biblioteca.domain.enums.Type" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  User currentUser = (User) request.getSession().getAttribute("user");
  boolean isAdmin = false;
  if (currentUser.getType().equals(Type.ADMIN)) {
    isAdmin = true;
  }

  String mensagem = (String) request.getAttribute("mensagem");
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="/livros"><img width="200px" src="https://littlefreelibrary.org/wp-content/uploads/2022/07/LFL_RGB_VerticalLogo@1x-1.png" alt="Inicio"></a>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">

        <li class="nav-item">
          <a class="nav-link" href="/livros">Livros</a>
        </li>
        <% if (isAdmin){%>
        <li class="nav-item">
          <a class="nav-link" href="/users">Usuários</a>
        </li>
        <%}%>
      </ul>
    </div>


    <div class="navbar-collapse justify-content-end">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link"><%= currentUser.getName()%></a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i> Sair</a>
        </li>

      </ul>
    </div>
  </div>
</nav>

<% if (mensagem != null && !mensagem.isEmpty()) { %>
<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="myModalLabel">Aviso</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <%= mensagem %>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script>
  $(document).ready(function() {
    $('#myModal').modal('show');
  });
</script>
<% } %>
