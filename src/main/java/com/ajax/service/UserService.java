package com.ajax.service;

import com.ajax.pojo.Message;
import com.ajax.pojo.User;

public interface UserService {
    Message fetchUser(User user);
}
