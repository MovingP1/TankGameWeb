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
    <title>注册账号</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
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
        <div class="user"><a href="${pageContext.request.contextPath}/login.jsp">登录</a></div>
    </div>
</header>

<div class="form">
    <div class="img">
        <img src="img/bg_spg_3.jpg" alt="">
    </div>
    <div class="inside">
        <form action="${pageContext.request.contextPath}/user/add" method="post">
            <h1>注册账号并开始游戏！</h1>
            <p>使用其他服务中已存在的账号来快速创建账号：</p>
            <a href="#" class="steam"></a>
            <a href="#" class="epic"></a><br>
            <input type="text" name="email" id="email" placeholder="输入邮箱地址"><br><span id="emailTip"></span>
            <input type="text" name="name" id="name" placeholder="请输入游戏内的昵称"><br>
            <input type="password" name="password" id="password" placeholder="输入游戏密码"><br>
            <input type="password" name="check" id="check" placeholder="确认密码"><span id="passwordTip"></span><br>
            <a href="#" class="inviteCode">已经有邀请码</a><br>
            <input type="checkbox" class="checkbx" name="accept" id="checkbx"><p class="acceptWord">我接受 <a href="legalDocument.html">最终用户许可协议</a> 并承认我已经阅读理解了<a href="legalDocument.html">隐私政策</a></p><br>
            <input type="checkbox" class="checkbx" name="wantInfo" id="wantInfo"><p class="wantWord">我想收到更多来自 <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">动点D</a> 的定向消息</p><br>
            <input type="button" value="继续>>" class="submit" id="submit">
            <span id="noPwd">密码不能为空</span><span id="noEmail">邮箱不能为空</span><span id="eUsed">邮箱已注册过，请勿重复使用</span><span id="pwdNotRight">两次密码输入不一致，请从新输入</span>
            <input type="submit" id="realSub">
        </form>
    </div>

</div>

<!--  底部 -->
<footer class="footer clearfix">
    <div class="copyright w">
        © 2009–2022 <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">动点D</a> 享有所有权. Powered by UnrealEngine™ ©
    </div>
</footer>

<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js" charset="gbk"></script>
<script src="${pageContext.request.contextPath}/js/register.js" charset="gbk"></script>
<script src="${pageContext.request.contextPath}/js/getUserdevice.js" charset="gbk"></script>
</body>
</html>
