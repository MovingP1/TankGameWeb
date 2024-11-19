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
    <title>游戏内容帮助</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/service.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userService.css" type="text/css">
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
        <li class="goldShop">
            <a href="${pageContext.request.contextPath}/store/getAll">高级商城<span></span></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/service.jsp">玩家支持<span></span></a>
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

<!-- 支持选项 -->
<div class="Userservice clearfix">
    <h1>服务项目</h1>
    <div class="w">
        <ul>
            <li>
                <p id="baseInfo">游戏简介</p>
            </li>
            <li>
                <p id="coin">银币</p>
            </li>
            <li>
                <p id="premiumAccount">高级账号</p>
            </li>
            <li>
                <p id="exp">全局经验</p>
            </li>
            <li>
                <p id="problem">常见问题</p>
            </li>
        </ul>
    </div>
    <!-- 显示区域 -->
    <div class="show">
        <div class="w">
            <h1 id="title"></h1>
            <p id="info"></p>
            <div class="useful">
                <p class="isUseful">这篇文章是否有帮助？</p>
                <input type="button" value="是">
                <input type="button" value="否">
            </div>
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
                    <p>JOIN US</p>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="" alt="">
                    <p>FOLLOW US</p>
                </a>
            </li>
            <li>
                <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">
                    <img src="" alt="">
                    <p>FOLLOW OUR CHANNEL</p>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="" alt="">
                    <p>BE ONE OF US</p>
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

<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js" charset="gbk"></script>
<script src="${pageContext.request.contextPath}/js/Service_game.js" charset="gbk"></script>
</body>
</html>