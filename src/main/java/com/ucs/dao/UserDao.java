package com.ucs.dao;

import com.ucs.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Timur Babich on 25.10.2017.
 */

@Repository
public class UserDao {

    private static SessionFactory sessionFactory = HibernateUnit.getSessionfactory();

    public List<User> getUsers(String login, String password){
        String stringQuery = "SELECT * FROM users WHERE login = '" + login +
                "' and password = '" + password + "'";
        List<User> userList = null;

        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery(stringQuery);
            query.addEntity(User.class);
            userList = query.list();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return userList;
    }
}
