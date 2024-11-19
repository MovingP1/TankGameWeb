package com.TG.servlet;

import com.TG.pojo.News;
import com.TG.service.NewsService;
import com.TG.service.impl.NewsServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet({"/news/add","/news/get","/news/getById"})
public class NewsServlet extends HttpServlet {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/news/add".equals(servletPath)){
            try {
                addNews(request,response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("/news/get".equals(servletPath)){
            getNews(request,response);
        }else if ("/news/getById".equals(servletPath)){
            getNewsById(request,response);
        }
    }

    private void getNewsById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String title="",time="",detail="",img="";

        NewsService service = new NewsServiceImpl();
        List<News> newsList = service.getById(Integer.valueOf(id));

        title = newsList.get(0).getNews_title();
        time = simpleDateFormat.format(newsList.get(0).getCreate_date());
        detail = newsList.get(0).getNews_detail();
        img = newsList.get(0).getNews_imges();

        request.setAttribute("title",title);
        request.setAttribute("time",time);
        request.setAttribute("detail",detail);
        request.setAttribute("img",img);
        request.getRequestDispatcher("/News.jsp").forward(request,response);
    }

    private void getNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //List<News> newsList = new ArrayList<>();
        NewsService service = new NewsServiceImpl();
        List<News> newsList = service.getTop7();

        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        String jsonStr = JSON.toJSONString(newsList, SerializerFeature.WriteDateUseDateFormat);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonStr);
    }

    private void addNews(HttpServletRequest request,HttpServletResponse response) throws ParseException, ServletException, IOException {
        String news_type,news_title,news_shortcut,news_imges,news_detail;
        news_type = request.getParameter("news_type");
        news_title = request.getParameter("news_title");
        news_shortcut = request.getParameter("news_shortcut");
        news_imges = request.getParameter("news_imge");
        news_detail = request.getParameter("news_detail");

        News news = new News(new Date(),news_type,news_title,news_shortcut,news_imges,news_detail);
        NewsService service = new NewsServiceImpl();
        int result = service.addNews(news);

        request.setAttribute("result",result);
        request.getRequestDispatcher("/").forward(request,response);
    }
}
