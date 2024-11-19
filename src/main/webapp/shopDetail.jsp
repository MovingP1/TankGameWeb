<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>详情</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopDetail.css">
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

<!-- 详情 -->
<div class="detail clearfix">
    <div class="img">
        <img src="${pageContext.request.contextPath}/${itemList[0].item_img}" alt="">
    </div>
    <div class="w">
        <h1>${itemList[0].item_name}</h1>
        <div class="oldPrice fl">¥${itemList[0].item_price+50}</div>
        <div class="newPrice ">¥${itemList[0].item_price}</div>
        <div class="pay" id="pay">购买</div>
        <div class="info">
            <div class="info-hd">组合包内容</div>
            <div class="info-bd">
                <span class="items">${itemList[0].item_name}</span>
                <c:if test="${itemList[0].item_type == 'gold'}">
                <span class="gold">${itemList[0].item_name}</span>
                </c:if>
                <span class="items">${itemList[0].item_detail}</span>
            </div>
        </div>
    </div>
    <div class="purchase clearfix" id="purchase">
        <form action="${pageContext.request.contextPath}/store/buy" method="get">
            <div class="w">
                <h1>订购选项</h1>
                <h2 id="money">¥${itemList[0].item_price}</h2>
                <!-- 提交的内容 -->
                <input type="text" name="userPassword" value="${cookie['password'].value}">
                <input type="text" name="userEmail" value="${cookie['email'].value}">
                <input type="text" name="itemName" value="${itemList[0].item_name}">
                <input type="text" name="itemId" value="${itemList[0].item_id}">
                <input type="text" name="money" class="money" value="${itemList[0].item_price}">
                <input type="text" name="owner" id="owner" value="me">
                <c:if test="${itemList[0].item_type == 'gold'}"><input type="text" name="itemType" value="gold"></c:if>
                <c:if test="${itemList[0].item_type == 'tank'}"><input type="text" name="itemType" value="tank"></c:if>
                <c:if test="${itemList[0].item_type == 'coin'}"><input type="text" name="itemType" value="PremiumAccount"></c:if>

                <div id="namebg">
                    <span id="bgquit"></span>
                    <input type="text" name="friendName" class="friendName" id="friendName" placeholder="请输入对方的账号名称">
                </div>
                <h3>选择付款方式</h3>
                <input type="radio" class="payway" name="payway" value="wechat" id="wechatbtn" checked><label for="wechatbtn" class="wechat"></label>
                <input type="radio" class="payway" name="payway" value="alipay" id="alipaybtn"><label for="alipaybtn" class="alipay"></label>
                <input type="radio" class="payway" name="payway" value="ICBC" id="ICBCbtn"><label for="ICBCbtn" class="ICBC"></label>
                <input type="radio" class="payway" name="payway" value="CMB" id="CMBbtn"><label for="CMBbtn" class="CMB"></label>
                <div class="payme fl" id="payme">为自己购买</div><input type="submit" id="paymeSub">
                <div class="payfriend fl" id="payfriend">为朋友购买</div>
                <div class="Realpayfriend fl" id="Realpayfriend">购买</div><input type="submit" id="payfriendSub">
                <div class="quit" id="quit"></div>
            </div>
        </form>
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
<script src="${pageContext.request.contextPath}/js/shop.js"></script>
</body>
</html>
