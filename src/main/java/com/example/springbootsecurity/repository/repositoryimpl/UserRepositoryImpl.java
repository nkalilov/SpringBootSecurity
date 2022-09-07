package com.example.springbootsecurity.repository.repositoryimpl;

import com.example.springbootsecurity.entity.User;
import com.example.springbootsecurity.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public
class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByUsername(String name) {
        return entityManager.createQuery("select u from User u where u.username =: name", User.class)
                .setParameter("name", name).getSingleResult();
    }
}
