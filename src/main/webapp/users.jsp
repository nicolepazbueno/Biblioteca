<%@ page import="java.util.List" %>
<%@ page import="com.example.biblioteca.domain.entities.User" %>
<html>
<head>
    <title>Usuários</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
    %>

    <%@include file="navbar.jsp"%>
    <br>

    <div class="container">
        <% if (isAdmin){%>
        <h1>Usuarios</h1>
        <br>
        <a href="/user/novo" class="btn btn-info btn-sm"><i class="bi bi-patch-plus"></i> Cadastrar Usuário</a>
        <br>
        <br>
            <table class="table table-bordered rounded">
                <thead class="table-light">
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Tipo</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (users != null && !users.isEmpty()) { %>
                    <% for (User user : users) { %>
                    <tr>
                        <td><%= user.getName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getType() %></td>
                        <td>

                            <a href="/user/delete?id=<%=user.getId()%>" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> Deletar</a>
                        </td>
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table>
    </div>
    <%}else{%>
    <div class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
        Você não tem permissão para visualizar os usuários.
    </div>
    <%}%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
