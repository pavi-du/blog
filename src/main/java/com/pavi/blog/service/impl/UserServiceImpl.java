package com.pavi.blog.service.impl;

import com.pavi.blog.mapper.UserMapper;
import com.pavi.blog.po.User;
import com.pavi.blog.service.UserService;
import com.pavi.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 17:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public Boolean checkUser(String userName, String password) {

        password = MD5Utils.code(password);
        User user = userMapper.findUserByUserNameAndPassword(userName,password);

        if(user != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean logout() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return true;
    }


}
