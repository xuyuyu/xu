package com.offcn.service.impl;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.dao.impl.UserDaoImpl;
import com.offcn.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }
}
