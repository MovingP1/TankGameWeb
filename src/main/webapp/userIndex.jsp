<%@ page import="com.TG.pojo.UserInfoPage" %>
<%@ page import="java.util.List" %>
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
    <title>个人中心</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userIndex.css">
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
        <div class="notes">
            <span>&#xe720;</span>
            <div class="num">1</div>
        </div>
        <div class="user"><a href="#">${cookie['name'].value}</a></div>
        <span>&#xe74a;</span>
    </div>
</header>
<%
    List<UserInfoPage> userInfoPageList = (List<UserInfoPage>) request.getAttribute("userAllInfo");
    UserInfoPage userInfoPage = userInfoPageList.get(0);
    request.setAttribute("userInfoPage",userInfoPage);
%>
<!-- 个人住要信息模块 -->
<div class="baseInfo clearfix">
    <div class="rgba clearfix">
        <div class="w">
            <h1 class="userName">${userInfoPage.user.user_name}</h1>
            <a href="${pageContext.request.contextPath}/store/getAll" class="premiumAccount">${userInfoPage.user.user_PremiumMin} 天</a>
            <a href="${pageContext.request.contextPath}/store/getAll" class="gold">${userInfoPage.user.user_gold}</a>
            <span class="coin">${userInfoPage.user.user_coin}</span>
            <span class="specialCoin">0</span>
            <span class="experience">${userInfoPage.user.user_exp}</span>
            <span class="createTime">账号创建于:${userInfoPage.user.user_registDate}</span>
            <input type="text" name="searchName" id="searchName" placeholder="查找其他玩家"><input type="button" name="search" id="search" value="&#xe61d;">
            <div class="logout">
                <a href="${pageContext.request.contextPath}/user/logout">登出</a>
            </div>
            <div class="bigInfo">
                <div class="left fl">
                    <div class="win fl">
                        <div class="img"></div>
                        <h2>${userInfoPage.totalWinAvg}%</h2>
                        <h4>胜率</h4>
                    </div>
                    <div class="battle fr">
                        <div class="img"></div>
                        <h2>${userInfoPage.totalTimes}</h2>
                        <h4>战斗</h4>
                    </div>
                </div>
                <div class="middle fl">
                    <div class="img"></div>
                    <h1>${userLevel}</h1>
                    <h3>个人评级</h3>
                </div>
                <div class="right fl">
                    <div class="damage fl">
                        <div class="img"></div>
                        <h2>${allDam}</h2>
                        <h4>总伤害</h4>
                    </div>
                    <div class="Totalexperience fr">
                        <div class="img"></div>
                        <h2>${userInfoPage.user.user_exp}</h2>
                        <h4>经验</h4>
                    </div>
                </div>
            </div>
            <div class="all">
                <table class="table table-hover">
                    <tr>
                        <th>名称</th>
                        <th>战斗场次</th>
                        <th>胜率</th>
                        <th>平均伤害</th>
                        <th>平均经验</th>
                    </tr>
                    <c:forEach items="${userAllInfo}" var="tankInfo">
                        <tr>
                            <td>${tankInfo.tank_name}</td>
                            <td>${tankInfo.tankTotalTimes}</td>
                            <td>${tankInfo.tankWinAvg}</td>
                            <td>${tankInfo.tankDamageAverage}</td>
                            <td>${tankInfo.tankExpAverage}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

</div>

<!--  底部 -->
<footer class="footer">
    <div class="copyright w">
        © 2009–2022 <a href="https://space.bilibili.com/50864610?spm_id_from=333.999.0.0">动点D</a> 享有所有权. Powered by UnrealEngine™ ©
    </div>
</footer>
</body>
</html>
