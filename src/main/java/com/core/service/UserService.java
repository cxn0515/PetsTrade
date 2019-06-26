package com.core.service;

import com.core.entity.User;

import java.util.List;

/**
 * Created by chengxiaonan on 2019/5/18.
 */
public interface UserService {

    public User login(User user);

    public List<User> main();
}
