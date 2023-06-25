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
import java.util.Arrays;
import java.util.List;

@WebServlet (name="EditLivroServlet", value="/livro/edit")
public class EditLivroController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        LivroRepository livroRepository = new LivroRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        Livro livroSelecionado = livroRepository.findById(Integer.parseInt(id));
        request.setAttribute("livroSelecionado", livroSelecionado);

        Author authorSelecionado = authorRepository.findById(Integer.parseInt(id));
        request.setAttribute("authorSelecionado", authorSelecionado);

        List<Status> status= Arrays.asList(Status.values());

        request.setAttribute("status", status);

        request.getRequestDispatcher("/editLivro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String nameAuthor = request.getParameter("nameAuthor");

        LivroRepository livroRepository = new LivroRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        String statusSelecionado = request.getParameter("status");
        Status status = Status.valueOf(statusSelecionado);

        Author authorEdit = authorRepository.findById(Integer.parseInt(request.getParameter("id")));
        authorEdit.setName(nameAuthor);
        authorRepository.update(authorEdit);

        Livro livroEdit = livroRepository.findById(Integer.parseInt(request.getParameter("id")));
        livroEdit.setName(name);
        livroEdit.setAuthor(authorEdit);
        livroEdit.setStatus(status);

        livroRepository.update(livroEdit);

        response.sendRedirect("/livros");
    }

}
