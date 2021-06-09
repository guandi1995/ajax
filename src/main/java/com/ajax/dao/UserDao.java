package com.ajax.dao;

import com.ajax.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Map> fetchUser(User user);
}
