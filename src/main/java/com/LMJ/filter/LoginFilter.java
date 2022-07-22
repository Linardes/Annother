package com.LMJ.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getSession().getAttribute("name")==null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,servletResponse);
            //终止过滤器并执行响应
            return;
        }
        //若没有下一个过滤器，则访问目标资源
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
