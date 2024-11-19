var title = $("#title");
var time = $("#time");
var detail = $("#detail");

urlinfo=window.location.href; //获取当前页面的
len=urlinfo.length;//获取url的长度
offset=urlinfo.indexOf("?");//设置参数字符串开始的位置
newsidinfo=urlinfo.substr(offset,len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
newsids=newsidinfo.split("=");//对获得的参数字符串按照“=”进行分割
newsid=newsids[1];
newsname=newsids[0];
$(function () {
    console.log(newsname+"="+newsid);
    $.ajax({
        type:"GET",
        url:"/TankGame/news/getById",
        data:newsname+"="+newsid,
        async:false,
        //响应后要拿数据回来
        success : function (json){
            var newJson = eval(json);
            var news = newJson[0];
            title.html(news.news_title);
            time.html(news.create_date);
            detail.html(news.news_detail);
        }
    })
})