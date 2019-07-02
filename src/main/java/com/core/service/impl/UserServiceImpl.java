package com.core.service.impl;

import com.core.dao.UserDao;
import com.core.entity.User;
import com.core.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chengxiaonan on 2019/5/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> main() {
        return userDao.main();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getList() {
        return userDao.getList();
    }
}
