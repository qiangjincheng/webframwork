package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpInterceptor implements HandlerInterceptor {
 /*   public static void main(String[] args) {
        String reg="192\\.168\\..*";
        //客户端的ip
        String remoteAddr = "192.168.1.1";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(remoteAddr);
        boolean result = matcher.matches();
        System.out.println(result);
    }*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String reg="192\\.168\\..*";
       //客户端的ip
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(remoteAddr);
        boolean result = matcher.matches();
       if (result){
           return true;
       }else {
           return false;
       }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
