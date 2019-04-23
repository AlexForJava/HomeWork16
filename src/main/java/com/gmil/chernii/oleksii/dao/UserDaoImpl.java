package com.gmil.chernii.oleksii.dao;

import com.gmil.chernii.oleksii.HibernateUtil;
import com.gmil.chernii.oleksii.entity.User;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Space on 23.04.2019.
 */
@Log4j
public class UserDaoImpl implements UserDao {
    private volatile static UserDaoImpl INSTANCE = null;

    @Override
    public void insert(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public User getById(Long id) {
        User user = new User();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.find(User.class, id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public void update(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = session.find(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            users = session.createQuery("SELECT u FROM users u", User.class).getResultList();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return users;
    }

    public static UserDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDaoImpl();
                }
            }
        }
        return INSTANCE;
    }


}
