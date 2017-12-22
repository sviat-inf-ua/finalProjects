package com.service;


/**
 * Created by Sviatoslav on 25.03.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
