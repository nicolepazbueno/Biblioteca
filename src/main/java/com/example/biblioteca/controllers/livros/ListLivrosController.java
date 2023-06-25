package com.example.biblioteca.controllers.livros;

import com.example.biblioteca.domain.entities.Author;
import com.example.biblioteca.domain.entities.Livro;
import com.example.biblioteca.repository.AuthorRepository;
import com.example.biblioteca.repository.LivroRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListLivrosController", value = "/livros")
public class ListLivrosController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        LivroRepository livroRepository = new LivroRepository();
        List<Livro> livros = livroRepository.findAll();

        String mensagem = (String) request.getParameter("mensagem");
        request.setAttribute("mensagem", mensagem);

        AuthorRepository authorRepository = new AuthorRepository();
        List<Author> authors = authorRepository.findAll();

        request.setAttribute("livros", livros);
        request.setAttribute("authors", authors);

        request.getRequestDispatcher("/listaLivros.jsp").forward(request, response);
    }
}
