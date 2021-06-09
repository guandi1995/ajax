package com.ajax.dao;

import com.ajax.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/8/2021 11:09 PM
 */

public class test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setId(10);
        user.setUsername("dguan@purdue.edu");
        user.setPassword("123456");
        List<Map> maps = userDao.fetchUser(user);
        System.out.println(maps);
    }
}
