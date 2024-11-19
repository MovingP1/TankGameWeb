var src = "img/";
var bigImg = $("#bigImg");
var bigTitle = $("#bigTitle");
var bigDetail = $("#bigDetail");
var bigType = $("#bigType");
var bigTime = $("#bigTime");
var newsbd = $("#news-bd");
var bigId = $("#bigId");

var bigVideoImg = $("#BigVideoImg");
var bigVideoName = $("#bigVideoName");
var bigVideoLink = $("#bigVideoLink");
var videobd = $("#videobd");

var wrapperbd = $("#wrapper");
$(function(){
    $.ajax({
        type:"GET",
        url:"/TankGame/news/get",
        // news=true就返回7个新闻[{"create_date":"2022-09-15","news_detail":"nothing new here and 看看中文是否安好~ :)","news_id":15,"news_imges":"nhb_frontline_2022_1920x900.jpeg","news_shortcut":"Just test if it is work","news_title":"FirstTest","news_type":"TEST"} ,{},{},{},{},{},{}]
        // 倒序查询，第一个是最新的
        data:"",
        async:false,
        //响应后要拿数据回来
        success : function (json){
            var newJson = eval(json)
            var news = newJson[0];
            src += news.news_imges;
            var href = "/TankGame/news/getById?id="+news.news_id
            bigImg.attr("src",src);
            bigTitle.text(news.news_title);
            bigDetail.text(news.news_shortcut);
            bigType.text(news.news_type);
            bigTime.html(news.create_date);
            document.getElementById("bigId").href=href;

            var wrapper = '';
            for(var w = 0; w<3;w++){
                var wrapperJson = newJson[w];

                wrapper += '<div class="swiper-slide">';

                wrapper += '<h3>';
                wrapper += wrapperJson.news_title;
                wrapper += '</h3>';

                wrapper += '<img src="';
                src = "img/" + wrapperJson.news_imges;
                wrapper += src;
                wrapper += '" alt="">';
                wrapper += '</div>';
            }
            wrapperbd.append(wrapper);

            var html = '<div class="row1">';
            for (var i=1 ; i < 4 ; i++){
                var smallNews = newJson[i];
                html += '<a href="/TankGame/news/getById?id=';
                html += smallNews.news_id;
                html += '"><div class="smallNews"><div class="imges"><img src="';
                src = "img/" + smallNews.news_imges;
                html += src;
                html += '" alt=""></div><div class="words"><h2>';
                html += smallNews.news_title;
                html += '</h2><span class="detail">';
                html += smallNews.news_shortcut;
                html += '</span><span class="type">';
                html += smallNews.news_type;
                html += '</span><span class="time">';
                html += smallNews.create_date;
                html += '</span></div></div></a>';
            }
            html += '</div>'
            newsbd.append(html);

            var html = '<div class="row1">';
            for (var i=4 ; i < 7 ; i++){
                var smallNews = newJson[i];
                html += '<a href="/TankGame/news/getById?id=';
                html += smallNews.news_id;
                html += '"><div class="smallNews"><div class="imges"><img src="';
                src = "img/" + smallNews.news_imges;
                html += src;
                html += '" alt=""></div><div class="words"><h2>';
                html += smallNews.news_title;
                html += '</h2><span class="detail">';
                html += smallNews.news_shortcut;
                html += '</span><span class="type">';
                html += smallNews.news_type;
                html += '</span><span class="time">';
                html += smallNews.create_date;
                html += '</span></div></div></a>';
            }
            html += '</div>'
            newsbd.append(html);
        }
    })
    $.ajax({
        type:"GET",
        url:"/TankGame/video/get",
        // news=true就返回7个视频[{} ,{},{},{},{},{},{}]
        // 倒序查询，第一个是最新的
        data:"",
        async:false,
        //响应后要拿数据回来
        success : function (json){
            var newJson = eval(json)
            var video = newJson[0];
            var href = video.video_link;
            document.getElementById("BigVideoImg").setAttribute("src",video.video_img);
            bigVideoName.text(video.video_name);
            document.getElementById("bigVideoLink").href = href;


            var html = '<div class="row1">';
            for (var i = 1; i < 4 ; i++){
                var smallVideos = newJson[i];
                html += '<div class="smallVideo"><div class="imges"><a href="'
                html += smallVideos.video_link;
                html += '"><div class="play"></div><img src=';
                html += smallVideos.video_img;
                html += ' alt=""></div><div class="words"><h2>';
                html += smallVideos.video_name;
                html += '</h2><span class="type">视频</span></a></div></div>';
            }
            html += '</div>'
            videobd.append(html);
            var html = '<div class="row1">';
            for (var i = 4; i < 7 ; i++){
                var smallVideos = newJson[i];
                html += '<div class="smallVideo"><div class="imges"><a href="'
                html += smallVideos.video_link;
                html += '"><div class="play"></div><img src=';
                html += smallVideos.video_img;
                html += ' alt=""></div><div class="words"><h2>';
                html += smallVideos.video_name;
                html += '</h2><span class="type">视频</span></a></div></div>';
            }
            html += '</div>'
            videobd.append(html);
        }
    })
})