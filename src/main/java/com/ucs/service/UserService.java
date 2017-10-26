package com.ucs.service;

import com.ucs.dao.UserDao;
import com.ucs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timur Babich on 25.10.2017.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsersList(String login, String password){
        List<User> list = userDao.getUsers(login, password);
        return userDao.getUsers(login, password);
    }
}
