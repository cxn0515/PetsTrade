package com.core.dao;

import com.core.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by chengxiaonan on 2019/5/18.
 */
@Repository
public interface UserDao {

    public User login(User user);
}
