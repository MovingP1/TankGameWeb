package com.TG.filter;

import com.TG.pojo.User;
import com.TG.service.UserService;
import com.TG.service.impl.UserServiceImpl;
import com.TG.servlet.UserServlet;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Loginfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //拿session后面判断是否已经登陆过
        HttpSession session = request.getSession(false);
        String servletPath = request.getServletPath();

        Cookie[] cookies = request.getCookies();
        String email = null;
        String password = null;
        int result = 0;

        if (cookies != null){
            /*循环遍历cookie*/
            for (Cookie cookie:cookies){
                /*cookie中的键值对，拿到key（name）来看是什么*/
                String name = cookie.getName();
                if ("email".equals(name)){
                    email = cookie.getValue();
                }else if ("password".equals(name)){
                    password = cookie.getValue();
                }
            }
        }
        if (email !=null && password != null){
            UserService service = new UserServiceImpl();
            result = service.login(new User(email,password));
        }else {
            result = 0;
        }
        if ((session != null && session.getAttribute("email") != null)){
            result = 1;
        }

//        if ("/index.jsp".equals(servletPath)||"/user/login".equals(servletPath)||(session != null && session.getAttribute("username") != null)||result == 1){
//            filterChain.doFilter(request,response);
//        }else {
//            response.sendRedirect(request.getContextPath()+"/index.jsp");
//        }"/user/checkEmail".equals(servletPath)||"/user/add".equals(servletPath)||
        if ("/user/logout".equals(servletPath)||"/user/getAllInfo".equals(servletPath)||"/store/buy".equals(servletPath)){
            if (result == 0){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }else {
                filterChain.doFilter(request,response);
            }
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
