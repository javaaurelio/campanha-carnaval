package com.campanha.carnaval.user.repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.campanha.carnaval.user.model.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class Users {
    @PersistenceContext
    EntityManager em;

    public List<User> list() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        query.from(User.class);
        return em.createQuery(query).getResultList();
    }

    public User create(User user) {
        if (Objects.nonNull(user.getId())) {
            throw new IllegalStateException("Id should be null !");
        }
        em.persist(user);
        em.detach(user);
        return user;
    }

    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst();
    }

    public User get(int userId) {
        return em.find(User.class, userId);
    }
}
