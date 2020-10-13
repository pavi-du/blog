package com.pavi.blog.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 17:56
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if(request.getSession().getAttribute("user")!=null){
            return true;
        }
        response.sendRedirect("/admin/");
        return false;
    }
}
