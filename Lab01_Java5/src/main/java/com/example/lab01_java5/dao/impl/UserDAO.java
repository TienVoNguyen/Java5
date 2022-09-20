package com.example.lab01_java5.dao.impl;

import com.example.lab01_java5.dao.IUserDAO;
import com.example.lab01_java5.models.User;
import com.example.lab01_java5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements IUserDAO {
    @Override
    public Long save(User user) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            try {
                session.getTransaction().begin();
                session.save(user);
                session.getTransaction().commit();
                return (Long) session.getIdentifier(user);
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public User findById(Long id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public User getUserByEmailPass(User user) {
        String hql = "select u from User u where u.email = :email";
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", user.getEmail());
            return query.uniqueResult();
        }
        }

    @Override
    public List<User> findAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<User> query = session.createQuery("from User" );
            return query.getResultList(); /*userQuery.list();*/
        }
    }

    @Override
    public User update(User user) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            try {
                session.getTransaction().begin();
                session.update(user);
                session.getTransaction().commit();
                return (User) session.merge(user);
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        return null;
    }
}
