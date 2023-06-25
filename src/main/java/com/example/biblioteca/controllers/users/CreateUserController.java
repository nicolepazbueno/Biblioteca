package com.example.biblioteca.controllers.users;

import com.example.biblioteca.domain.entities.User;
import com.example.biblioteca.domain.enums.Status;
import com.example.biblioteca.domain.enums.Type;
import com.example.biblioteca.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@WebServlet (name = "CreateUserServlet", value ="/user/novo")
public class CreateUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> type = Arrays.asList(Type.values());
        request.setAttribute("type", type);
        request.getRequestDispatcher("/createUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserRepository userRepository = new UserRepository();
        User user = new User();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        try{
            user.setName(name);
            user.setEmail(email);
            user.setType(Type.valueOf(type.toUpperCase()));
            user.setPassword(password);
            userRepository.create(user);
            response.sendRedirect("/users");
        } catch (Exception e) {
            String mensagem = "Erro ao criar o usuário: " + e.getMessage();
            response.sendRedirect("/users?mensagem=" + URLEncoder.encode(mensagem, StandardCharsets.UTF_8));
        }
    }
}


