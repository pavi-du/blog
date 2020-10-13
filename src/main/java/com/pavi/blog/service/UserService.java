package com.pavi.blog.service;

import com.pavi.blog.po.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    Boolean checkUser(String userName,String password);



    Boolean logout();
}
