<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="referrer" content="no-referrer">
    <title>模型战争ModelWar</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font/font.css" type="text/css">
</head>
<body>
<!-- 顶部导航栏模块 -->
<header class="header">
    <div class="logo">
        <img src="" alt="">
    </div>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/">所有游戏<span></span></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/service.jsp">玩家服务<span></span></a>
        </li>
        <li class="goldShop">
            <a href="${pageContext.request.contextPath}/store/getAll">高级商城<span></span></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/Service_user.jsp">玩家支持<span></span></a>
        </li>
    </ul>
    <div class="right">
        <c:if test="${empty cookie['name'].value}">
            <div class="user"><a href="${pageContext.request.contextPath}/register.jsp">登陆&注册</a></div>
        </c:if>
        <c:if test="${not empty cookie['name'].value}">
            <div class="notes">
                <span>&#xe720;</span>
                <div class="num">1</div>
            </div>
            <div class="user"><a href="${pageContext.request.contextPath}/user/getAllInfo">${cookie['name'].value}</a></div>
            <span>&#xe74a;</span>
        </c:if>
    </div>
</header>

<!-- 半透明导航栏模块 -->
<div class="banner">
    <div class="daohang">
        <div class="w">
            <div class="logo">
                <h1><a href="${pageContext.request.contextPath}/" title="模型战争ModelWar">模型战争ModelWar</a></h1>
            </div>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/">游戏</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/Service_game.jsp">指引</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/Service_user.jsp">快速上手</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/Service_report.jsp">联系我们</a>
                </li>
            </ul>
            <div class="download">下载游戏</div>
        </div>

    </div>
    <div class="main">
        <img src="img/bg_index.png" alt="">
    </div>
</div>

<!-- 轮播图模块 -->
<div class="w">
    <div class="strip">
        <div class="leftStrip">
            <!-- Swiper -->
            <div class="swiper mySwiper">
                <div class="swiper-wrapper" id="wrapper">
                </div>
                <div class="swiper-pagination"></div>
            </div>
        </div>

        <a href="${pageContext.request.contextPath}/store/getAll">
            <div class="rightShop hidden-ms">
                <img src="img/wot_premshop-banner_en_65pjn3d.jpeg" alt="">
            </div>
        </a>
    </div>
</div>

<!-- 新闻模块 -->
<div class="news w">
    <div class="news-hd clearfix w">
        <h2>最新资讯</h2>
        <a href="#">查看所有</a>
    </div>
    <div class="news-bd w" id="news-bd">
        <div class="bigNews">
            <a href="" id="bigId">
                <img id="bigImg" src="img/" alt="">
                <div class="words">
                    <h2 id="bigTitle"></h2>
                    <span class="detail" id="bigDetail"></span>
                    <span class="type" id="bigType"></span>
                    <span class="time" id="bigTime"></span>
                </div>
            </a>
        </div>

    </div>
</div>

<!-- 视频模块 -->
<div class="video">
    <div class="video-hd clearfix w">
        <h2>介绍视频</h2>
        <a href="#">所有视频</a>
    </div>
    <div class="video-bd">
        <div class="news-bd w" id="videobd">
            <a href="" id="bigVideoLink">
                <div class="bigVideo">
                    <div class="imges">
                        <div class="play"></div>
                        <img src="" alt="" id="BigVideoImg">
                    </div>
                    <div class="words">
                        <h2 id="bigVideoName"></h2>
                        <span class="type">视频</span>
                    </div>
                </div>
            </a>
        </div>
    </div>
</div>

<!-- 底部 -->
<footer class="footer">
    <div class="follow w">
        <ul>
            <li>
                <a href="#">
                    <img src="" alt="">
                    <p>加入我们</p>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="" alt="">
                    <p>关于作者</p>
                </a>
            </li>
            <li>
                <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">
                    <img src="" alt="">
                    <p>关注作者</p>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="" alt="">
                    <p>敬请期待</p>
                </a>
            </li>
        </ul>
    </div>
    <div class="service w">
        <ul>
            <li>
                <a href="#">
                    <img src="" alt="">
                </a>
            </li>
        </ul>
        <ul>
            <li><a href="#">玩家支持</a></li>
            <li><a href="#">合作伙伴</a></li>
            <li><a href="#">EULA</a></li>
        </ul>
        <ul>
            <li><a href="#">玩家支持</a></li>
            <li><a href="#">合作伙伴</a></li>
            <li><a href="#">EULA</a></li>
        </ul>
        <ul>
            <li><a href="Service_user.html">玩家支持</a></li>
            <li><a href="#">语言</a></li>
        </ul>
    </div>
    <div class="copyright w">
        © 2009–2022 <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">动点D</a> 享有所有权. Powered by UnrealEngine™ ©
    </div>
</footer>


<script src="${pageContext.request.contextPath}/js/swiper.min.js" charset="gbk"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js" charset="gbk"></script>
<script src="${pageContext.request.contextPath}/js/index.js" charset="gbk"></script>
<script>
    (function() {
        var swiper = new Swiper(".mySwiper", {
            cssMode: true,
            navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
            },
            pagination: {
                el: ".swiper-pagination",
                clickable: true,
            },
            mousewheel: true,
            keyboard: true,
        });
    })();
</script>
</body>
</html>
