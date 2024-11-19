package com.TG.servlet;

import com.TG.pojo.User;
import com.TG.pojo.UserInfoPage;
import com.TG.service.UserService;
import com.TG.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet({"/user/add","/user/login","/user/checkEmail","/user/logout","/user/getAllInfo"})
public class UserServlet extends HttpServlet {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/user/add".equals(servletPath)){
            try {
                addUser(request,response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("/user/login".equals(servletPath)){
            userLogin(request,response);
        }else if ("/user/checkEmail".equals(servletPath)){
            checkEmail(request,response);
        }else if ("/user/logout".equals(servletPath)){
            userLogout(request,response);
        }else if ("/user/getAllInfo".equals(servletPath)){
            userGetAllInfo(request,response);
        }
    }

    private void userGetAllInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user_email="",user_password="";
        int allDam=0,userLevel=0;
        Cookie[] cookie = request.getCookies();

        for (Cookie cookie1:cookie){
            String name = cookie1.getName();
            if ("email".equals(name)){
                user_email = cookie1.getValue();
            }
            if ("password".equals(name)){
                user_password = cookie1.getValue();
            }
        }
        User user = new User(user_email,user_password);
        //根据用户邮箱和密码获取所有信息
        UserService service = new UserServiceImpl();
        List<User> userList = service.findUserByEmail(user);
        List<UserInfoPage> userInfoPageList = service.getAllUserInfo(user);
/*{user_id=3, tank_id=1, totalTimes=23, totalWinAvg=0.3478261, tankWinAvg=0.36363637, tankDamageAverage=2875.6365, tankExpAverage=493.4545, tankTotalTimes=11, tank_name='M1谢尔曼',
    user=User{user_id=3, user_name='user002', user_EmailAddr='123123@123.com', user_password='112233', user_coin=0, user_gold=0, user_exp=0, user_PremiumMin=0, user_registDate=Thu Sep 08 00:00:00 CST 2022, is_boughtStarterPak=false}*/
        if (userInfoPageList.get(0).getTank_id() != 0){
            allDam = service.getAllDam(userInfoPageList.get(0).getUser_id());
            userLevel = userInfoPageList.get(0).getTotalTimes()*(int)userInfoPageList.get(0).getTankExpAverage()*(int)userInfoPageList.get(0).getTankWinAvg();
        }
        request.setAttribute("userAllInfo",userInfoPageList);
        request.setAttribute("userLevel",userLevel);
        request.setAttribute("allDam",allDam);
        request.getRequestDispatcher("/userIndex.jsp").forward(request,response);
    }

    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            if ("name".equals(name) || "password".equals(name) || "email".equals(name)){
                cookie.setMaxAge(0);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);/*重要设置，否则不能移除*/
            }
        }
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user_email = request.getParameter("email");
        int result = 0;
        UserService service = new UserServiceImpl();
        System.out.println(user_email);

        if (user_email != null){
            result = service.checkEmail(user_email);
        }else if ("".equals(user_email)){
            result = -1;
        }
        response.getWriter().print(result);
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String user_email="",user_password="",userName="";
        //获取作用域对象中的值
        if (request.getParameter("email")!=null&&request.getParameter("password")!=null){
            user_email = request.getParameter("email");
            user_password = request.getParameter("password");
        }
        User user = new User(user_email,user_password);

        //调用接口实现类查询用户
        UserService service = new UserServiceImpl();
        int result = service.login(user);
        List<User> userList = service.findUserByEmail(user);

        //判断是否有用户
        response.setContentType("text/html;charset=utf-8");
        if (result == 1){
            userName = userList.get(0).getUser_name();
            HttpSession session = request.getSession();
            session.setAttribute("name",userName);
            /*创建cookie对象*/
            Cookie cookieUser = new Cookie("name",userName);
            Cookie cookiePwd = new Cookie("password",user_password);
            Cookie cookieEmail = new Cookie("email",user_email);

            /*10天内免登录*/
            String flag = request.getParameter("remember");
            if ("1".equals(flag)){
                /*设置cookie有效期为10天*/
                cookieUser.setMaxAge(60*60*24*10);
                cookiePwd.setMaxAge(60*60*24*10);
                cookieEmail.setMaxAge(60*60*24*10);
            }
            /*设置cookie的path（只要访问这个应用，浏览器就一定要携带这两个cookie*/
            cookieUser.setPath(request.getContextPath());
            cookiePwd.setPath(request.getContextPath());
            cookieEmail.setPath(request.getContextPath());
            /*相应cookie给浏览器*/

            response.addCookie(cookieUser);
            response.addCookie(cookiePwd);
            response.addCookie(cookieEmail);
            response.sendRedirect(request.getContextPath()+"/");
        }else {
            request.setAttribute("errorInfo","用户名或账号错误");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String user_name,user_emailAddr,user_password,user_createDate;
        user_name = request.getParameter("name");
        user_emailAddr = request.getParameter("email");
        user_password = request.getParameter("password");
        Date date = new Date();
        user_createDate = simpleDateFormat.format(date);

        //调用接口的方法增加用户
        UserService service = new UserServiceImpl();
        User user = new User(null,user_name,user_emailAddr,user_password,0,0,0,0,simpleDateFormat.parse(user_createDate),false);
        int result = service.registUser(user);

        response.setContentType("text/html;charset=UTF-8");
        if (result == 1){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
