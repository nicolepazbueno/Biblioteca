<%@ page import="com.example.biblioteca.domain.entities.Author" %>
<%@ page import="com.example.biblioteca.domain.enums.Status" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.biblioteca.domain.entities.Livro" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <title>Editar Livro</title>
</head>
<body>

<%
    List<Status> status = (List<Status>) request.getAttribute("status");
    Livro livroSelecionado = (Livro) request.getAttribute("livroSelecionado");
    Author authorSelecionado = (Author) request.getAttribute("authorSelecionado");
%>

<%@include file="navbar.jsp"%>
<br>

<div class="container">
    <% if (isAdmin){%>
    <h1><%= "Editar Livro" %></h1>

    <br>

    <div class="border rounded p-4">
        <h4 class="mb-3"></h4>
        <form action="/livro/edit?id=<%=livroSelecionado.getId()%>" method="POST">
            <div class="form-group">
                <label for="name">Nome do livro:</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Nome do livro" value="<%= livroSelecionado.getName() %>">
            </div>
            <br>
            <div class="form-group">
                <label for="nameAuthor">Autor</label>
                <input type="text" class="form-control" name="nameAuthor" id="nameAuthor" placeholder="Nome do Autor" value="<%= authorSelecionado.getName() %>">
            </div>
            <br>
            <div class="form-group">
                <label for="status">Status</label>
                <select class="custom-select" name="status" id="status">
                    <option selected="selected"><%= livroSelecionado.getStatus() %></option>
                    <% for (Status statusLivro : status) { %>

                    <% if (!statusLivro.equals(livroSelecionado.getStatus())){%>
                    <option value="<%= statusLivro %>"><%= statusLivro %></option>
                    <%}%>

                    <% } %>
                </select>
            </div>

            <br>

            <button type="submit" class="btn btn-success">Salvar</button>

        </form>
    </div>
    <%}else{%>
    <div class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
        Você não tem permissão para editar lviros.
    </div>
    <%}%>


</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>