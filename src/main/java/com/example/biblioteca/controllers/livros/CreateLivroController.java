package com.example.biblioteca.controllers.livros;

import com.example.biblioteca.domain.entities.Author;
import com.example.biblioteca.domain.entities.Livro;
import com.example.biblioteca.domain.enums.Status;
import com.example.biblioteca.repository.AuthorRepository;
import com.example.biblioteca.repository.LivroRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="CreateLivroServlet", value="/livro/novo")
public class CreateLivroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensagem = (String) request.getAttribute("mensagem");
        List<Status> status = Arrays.asList(Status.values());
        request.setAttribute("status", status);
        request.getRequestDispatcher("/createLivros.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String nameAuthor = request.getParameter("nameAuthor");
        String status = request.getParameter("status");

        try {
            LivroRepository livroRepository = new LivroRepository();
            AuthorRepository authorRepository = new AuthorRepository();
            Author author = new Author();
            author.setName(nameAuthor);
            authorRepository.create(author);
            Livro livro = new Livro();
            livro.setAuthor(author);
            livro.setName(name);
            livro.setStatus(Status.valueOf(status.toUpperCase()));
            livro.setDate(LocalDate.now());
            livroRepository.create(livro);
            response.sendRedirect("/livros");
        } catch (Exception e) {
            String mensagem = "Erro ao cadastrar livro: " + e.getMessage();
            response.sendRedirect("/livros?mensagem=" + URLEncoder.encode(mensagem, StandardCharsets.UTF_8));
        }
    }
}
