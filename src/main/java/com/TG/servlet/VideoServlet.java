package com.TG.servlet;

import com.TG.pojo.Videos;
import com.TG.service.VideoService;
import com.TG.service.impl.VideoServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/video/add","/video/get"})
public class VideoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/video/add".equals(path)){
            addVideo(request,response);
        }else if ("/video/get".equals(path)){
            getTop7(request,response);
        }
    }

    private void getTop7(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VideoService service = new VideoServiceImpl();
        List<Videos> videosList = service.videoList();

        String jsonStr = JSON.toJSONString(videosList);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonStr);
    }

    private void addVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String video_name,video_img,video_link;
        video_name = request.getParameter("video_name");
        video_img = request.getParameter("video_img");
        video_link = request.getParameter("video_link");

        Videos videos = new Videos(null,video_name,video_img,video_link);
        VideoService service = new VideoServiceImpl();
        int result = service.addVideo(videos);

        request.setAttribute("result",result);
        request.getRequestDispatcher("/").forward(request,response);
    }
}
