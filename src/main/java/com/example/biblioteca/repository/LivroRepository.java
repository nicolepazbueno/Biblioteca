package com.example.biblioteca.repository;

import com.example.biblioteca.connection.ConnectionFactory;
import com.example.biblioteca.domain.entities.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;


public class LivroRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public LivroRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

   public Livro create(Livro livro){
        transaction.begin();
        entityManager.persist(livro);
        transaction.commit();
        return livro;
   }

    public Livro findById(Integer id){
        Livro livro = entityManager.find(Livro.class, id);
        return livro;
    }

    public Livro update(Livro livro){
        transaction.begin();
        livro = entityManager.merge(livro);
        transaction.commit();
        return livro;

    }

    public Livro remove(Livro livro){
        if(livro == null){
            throw new RuntimeException("Livro não pode ser nulo");
        }
        transaction.begin();
        livro = entityManager.find(Livro.class, livro.getId());
        entityManager.remove(livro);
        transaction.commit();
        return livro;
    }

    public List<Livro> findAll() {
        return entityManager.createQuery("SELECT l FROM livro l", Livro.class)
                .getResultList();
    }


}
