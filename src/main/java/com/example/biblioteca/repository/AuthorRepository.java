package com.example.biblioteca.repository;

import com.example.biblioteca.connection.ConnectionFactory;
import com.example.biblioteca.domain.entities.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class AuthorRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public AuthorRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Author create(Author author){
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        return author;
    }

    public Author findById(Integer id){
        Author author = entityManager.find(Author.class, id);
        return author;
    }

    public Author update(Author author){
        transaction.begin();
        author = entityManager.merge(author);
        transaction.commit();
        return author;
    }

    public Author remove(Author author){
        if(author == null){
            throw new RuntimeException("Autor não existe!");
        }
        transaction.begin();
        author = entityManager.find(Author.class, author.getId());
        entityManager.remove(author);
        transaction.commit();
        return author;
    }

    public List<Author> findAll(){
        return entityManager.createQuery("SELECT a FROM author a").getResultList();
    }

    public Author findByName(String name) {
        try {
            return entityManager.createQuery("SELECT a FROM author a WHERE a.name = :name", Author.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println("Nenhum autor encontrado." + e.getMessage());
            return null;
        }
    }

}
