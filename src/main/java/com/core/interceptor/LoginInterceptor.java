package com.core.interceptor;

import com.core.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:chengxiaonan
 * @Date:2019/7/9
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        if (url.contains("/login")) {
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            return true;
        }
        //httpServletRequest.getRequestDispatcher("/user/login.action").forward(httpServletRequest,httpServletResponse);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
