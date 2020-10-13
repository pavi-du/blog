package com.pavi.blog.web.admin;

import com.pavi.blog.po.User;
import com.pavi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 17:13
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;



    @GetMapping("/admin")
    public String toLoginPage(){
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam(name = "userName") String userName,@RequestParam(name = "password") String password, HttpSession session,
                        RedirectAttributes redirectAttributes){

        // user 和 boolean
        Boolean checkUserRes  = userService.checkUser(userName,password);

        if(checkUserRes){

            //session.setAttribute("user",user);
            return "redirect:/admin/index";
        }
        redirectAttributes.addAttribute("message","用户名密码不匹配");
        return "redirect:/admin/";
    }

    @GetMapping("/admin/index")
    public String indexPage(){
        return "admin/index";
    }



    @GetMapping("/admin/logout")
    public String logout(RedirectAttributes redirectAttributes){

        Boolean logoutRes = userService.logout();
        //redirectAttributes.addAttribute("message","退出系统");
        return "redirect:/admin/";
    }
}
