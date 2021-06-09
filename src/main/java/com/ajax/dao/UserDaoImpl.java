package com.ajax.dao;

import com.ajax.pojo.User;
import com.ajax.utils.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * fetch account information given username and password
 * @author Di Guan on 6/8/2021 8:06 PM
 */

public class UserDaoImpl implements UserDao{
    @Override
    public List<Map> fetchUser(User user) {
        String SQL = "SELECT * FROM adminlogin WHERE username = ? AND password = ?";
        return JDBCUtils.executeQuery(SQL, user.getUsername(), user.getPassword());
    }
}
