package com.service;

import com.entity.user.User;

/**
 * Created by Sviatoslav on 25.03.2017.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
