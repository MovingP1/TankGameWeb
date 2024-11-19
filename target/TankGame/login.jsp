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
    <title>登陆账号</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
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
    <div class="right">
        <div class="user"><a href="${pageContext.request.contextPath}/register.jsp">注册</a></div>
    </div>
</header>

<div class="form">
    <div class="img">
        <img src="img/bg_spg_3.jpg" alt="">
    </div>
    <div class="inside">
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <h1>登陆</h1>
            <p>此页面只用于登陆你的账号，你将可以登陆所有我们的网站。为避免风险，请勿在其他网站上输入你的账号和密码。</p>
            <p class="social">用社交账号登陆：</p>
            <a href="#" class="steam"></a>
            <a href="#" class="epic"></a><br>
            <input type="text" name="email" id="email" placeholder="输入邮箱地址"><br>
            <input type="password" name="password" id="password" placeholder="输入游戏密码"><br>
            <a href="reset.html" class="inviteCode">无法登陆？恢复账号</a><br>
            <input type="checkbox" class="checkbx" name="remember" value="1"><p class="remember">记住登陆状态</p><br>
            <p class="acceptWord">还没有模型战争ModelWar账号？<a href="${pageContext.request.contextPath}/register.jsp">创建账号</a></p><br>
            <input type="submit" value="登陆" class="submit">
        </form>
    </div>

</div>

<!--  底部 -->
<footer class="footer clearfix">
    <div class="copyright w">
        © 2009–2022 <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">动点D</a> 享有所有权. Powered by UnrealEngine™ ©
    </div>
</footer>
<script src="${pageContext.request.contextPath}/js/getUserdevice.js" charset="gbk"></script>
</body>
</html>

