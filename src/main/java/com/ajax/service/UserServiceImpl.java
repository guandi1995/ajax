package com.ajax.service;

import com.ajax.dao.UserDao;
import com.ajax.dao.UserDaoImpl;
import com.ajax.pojo.Message;
import com.ajax.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/8/2021 11:19 PM
 */

public class UserServiceImpl implements UserService{

    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public Message fetchUser(User user) {
        List<Map> maps = userDao.fetchUser(user);
        //如果返回的maps不为空，说明登陆成功
        if (maps != null && maps.size() > 0)
            return new Message("Login Successfully", true, maps.get(0));
        //否则，登陆失败
        return new Message("Fail to login", false);
    }
}
