package com.core.admin;

import com.core.entity.User;
import com.core.service.UserService;
import com.core.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chengxiaonan on 2019/5/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        String md5Pwd = MD5Util.MD5Encode(user.getPassword(),"UTF-8");
        user.setPassword(md5Pwd);

        User resultUser = userService.login(user);
        if(resultUser == null){
            request.setAttribute("user",user);
            request.setAttribute("errMsg","请认真核对账号、密码！");
            return "login";
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",resultUser);
            return "redirect:/main.jsp";
        }
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
