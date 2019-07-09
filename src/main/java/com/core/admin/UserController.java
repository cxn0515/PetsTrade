package com.core.admin;

import com.alibaba.fastjson.JSON;
import com.core.entity.User;
import com.core.service.UserService;
import com.core.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by chengxiaonan on 2019/5/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        String md5Pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
        user.setPassword(md5Pwd);

        User resultUser = userService.login(user);
        if (resultUser == null) {
            request.setAttribute("user", user);
            request.setAttribute("errMsg", "请认真核对账号、密码！");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultUser);
            return "redirect:main.action";
        }
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/addUser")
    public String addUser(){
        return "addUser";
    }

    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String roleName = request.getParameter("roleName");
        if (StringUtils.isEmpty(roleName)) {
            roleName = "user";
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(MD5Util.MD5Encode(password, "UTF-8"));
        user.setRoleName(roleName);
        int i = userService.addUser(user);
        if (i > 0) {
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(JSON.toJSONString("success"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                out.flush();
                out.close();
            }
        }
        return null;
    }

    @RequestMapping(value = "/list")
    public String list(){
        return "userList";
    }

    @RequestMapping(value = "/userList")
    public @ResponseBody List<User> userList(){
        List<User> list = userService.getList();
        return list;
    }
}
