package com.example.biblioteca.repository;

import com.example.biblioteca.connection.ConnectionFactory;
import com.example.biblioteca.domain.entities.Author;
import com.example.biblioteca.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class UserRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public UserRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public User create(User user){
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    public User update(User user){
        transaction.begin();
        user = entityManager.merge(user);
        transaction.commit();
        return user;
    }

    public User remove(User user){
        if(user == null){
            throw new RuntimeException("Usuário não existe.");
        }
        transaction.begin();
        user = entityManager.find(User.class, user.getId());
        entityManager.remove(user);
        transaction.commit();
        return user;
    }

    public List<User> findAll(){
        return entityManager.createQuery("SELECT u FROM user u").getResultList();
    }

    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }


    public User findByEmail(String email) throws NoResultException {
        return entityManager.createQuery("SELECT u FROM user u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

}
