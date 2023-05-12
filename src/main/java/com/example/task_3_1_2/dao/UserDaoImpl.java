package com.example.task_3_1_2.dao;

import com.example.task_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void remove(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        User detachedUser = entityManager.find(User.class, user.getId());
        detachedUser.setName(user.getName());
        detachedUser.setLastName(user.getLastName());
        detachedUser.setAge(user.getAge());
        entityManager.merge(detachedUser);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
