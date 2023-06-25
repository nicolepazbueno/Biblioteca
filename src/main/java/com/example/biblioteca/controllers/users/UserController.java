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

@WebServlet (name = "UserServlet", value ="/users")
public class UserController extends HttpServlet {

    //listar usuarios
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.findAll();
        request.setAttribute("users", users);
        String mensagem = (String) request.getAttribute("mensagem");
        request.setAttribute("mensagem", mensagem);
        List<Type> type = Arrays.asList(Type.values());
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}


