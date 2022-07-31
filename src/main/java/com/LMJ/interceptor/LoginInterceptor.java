package com.LMJ.interceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object Handler)
    throws Exception{
        String uri=request.getRequestURI();
        if(uri.indexOf("/login")>=0||uri.indexOf("/captcha")>=0) {
            return true;
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("name")!=null){
            return true;
        }
        else {
            request.setAttribute("msg","您还未登录，请先登录！");
            request.getRequestDispatcher("src/main/webapp/jsp/login.jsp").forward(request,response);
            return false;
        }
    }
}
