package com.dao;

import com.entity.user.User;

public interface UserDao extends CrudDao<User, Integer>{

	  User findByUsername(String username);
}
