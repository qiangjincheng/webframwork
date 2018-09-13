package com.controller;


import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login.do")
    public ModelAndView login(String username, String password, ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            mav.setViewName("error");
            return mav;
        }
        if (username.equals("zhangsan") && password.equals("123"))
            mav.setViewName("success");
            request.getSession().setAttribute("user", "zhangsan");
            return mav;

    }
}
