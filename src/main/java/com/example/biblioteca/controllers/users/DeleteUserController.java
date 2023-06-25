package com.example.biblioteca.controllers.users;

import com.example.biblioteca.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ServletDeleteUser", value="/user/delete")
public class DeleteUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            UserRepository userRepository = new UserRepository();
            userRepository.remove(userRepository.findById(Integer.parseInt(id)));
            request.setAttribute("mensagem", "Usuário excluído com sucesso!");
            response.sendRedirect("/users");
        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao excluir o usuário: " + e.getMessage());
            response.sendRedirect("/users");
        }
    }
}
