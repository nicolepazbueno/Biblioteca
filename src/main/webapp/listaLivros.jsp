<%@ page import="com.example.biblioteca.domain.entities.Livro" %>
<%@ page import="com.example.biblioteca.domain.enums.Status" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.biblioteca.domain.entities.Author" %><%--
  Created by IntelliJ IDEA.
  User: nicol
  Date: 25/06/2023
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <title>Biblioteca</title>
</head>
<body>

<%
    List<Livro> livros = (List<Livro>) request.getAttribute("livros");
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<%@include file="navbar.jsp"%>

<br>

<div class="container">

    <h1>Biblioteca</h1>
    <br>
    <% if (isAdmin){%>
    <a href="/livro/novo" class="btn btn-info btn-sm"><i class="bi bi-patch-plus"></i> Cadastrar Livro</a>
    <br><br>
    <%}%>
    <table class="table table-bordered rounded">
        <thead class="table-light">
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Data</th>
            <th>Autor</th>
            <th>Status</th>
            <% if (isAdmin){%><th>Ações</th><%}%>
        </tr>
        </thead>
        <tbody>
        <% for (Livro livro : livros) { %>
        <tr>
            <td><%=livro.getId()%></td>
            <td><%=livro.getName()%></td>
            <td><%=livro.getDate()%></td>
            <td><%=livro.getAuthor().getName()%></td>
            <td><%=livro.getStatus()%></td>

            <% if (isAdmin){%>
            <td>


                <button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#confirmDeleteModal<%= livro.getId() %>"><i class="fa fa-trash"></i> Deletar</button>
                <div class="modal fade" id="confirmDeleteModal<%= livro.getId() %>" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel<%= livro.getId() %>" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="confirmDeleteModalLabel<%= livro.getId() %>">Confirmar Exclusão</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p>Tem certeza de que deseja excluir esse livro?</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <a href="/livro/delete?id=<%=livro.getId()%>" class="btn btn-danger">Excluir</a>
                            </div>
                        </div>
                    </div>
                </div>


                <a href="/livro/edit?id=<%=livro.getId()%>" class="btn btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Editar</a>
                <%}%>


            </td>
        </tr>
        <%}%>

        </tbody>
    </table>

</div>





<!-- Scripts -->

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>

</html>