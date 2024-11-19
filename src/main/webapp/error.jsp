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
    <title>错误</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/service.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font/font.css">
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
    <h1>啊哦 出现了什么错误 ${errorInfo}</h1>
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
</body>
</html>