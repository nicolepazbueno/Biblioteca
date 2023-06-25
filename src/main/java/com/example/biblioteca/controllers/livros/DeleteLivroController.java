package com.example.biblioteca.controllers.livros;

import com.example.biblioteca.domain.entities.Livro;
import com.example.biblioteca.repository.LivroRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name="DeleteLivroServlet", value="/livro/delete")
public class DeleteLivroController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        LivroRepository livroRepository = new LivroRepository();
        Livro livro = livroRepository.findById(Integer.parseInt(id));
        livroRepository.remove(livro);

        response.sendRedirect("/livros");
    }
}
