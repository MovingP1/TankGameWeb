package com.TG.servlet;

import com.TG.pojo.Store;
import com.TG.pojo.User;
import com.TG.pojo.UserGarage;
import com.TG.service.StoreService;
import com.TG.service.UserService;
import com.TG.service.impl.StoreServiceImpl;
import com.TG.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/store/getAll","/store/getById","/store/buy"})
public class StoreServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/store/getAll".equals(servletPath)){
            getAllItems(request,response);
        }else if ("/store/getById".equals(servletPath)){
            getItemById(request,response);
        }else if ("/store/buy".equals(servletPath)){
            userBuy(request,response);
        }
    }

    private void userBuy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String itemType="",payway,owner,itemName="",userEmail="",userPassword="",friendName="";
        int money,itemId,tankId,userId,result=0,goldPrice,premiumMin,userGold,userPrMin;

        //接受请求参数
        userPassword = request.getParameter("userPassword");
        userEmail = request.getParameter("userEmail");
        itemName = request.getParameter("itemName");
        itemId = Integer.valueOf(request.getParameter("itemId"));
        money = Integer.valueOf(request.getParameter("money"));
        owner = request.getParameter("owner");
        itemType = request.getParameter("itemType");
        friendName = request.getParameter("friendName");
        payway = request.getParameter("payway");
        UserService userService = new UserServiceImpl();
        StoreService storeService = new StoreServiceImpl();

        //如果玩家不是为自己购买，就要获取朋友的email和id
        if (friendName != ""){
            List<User> userFriendList = userService.findUserByName(friendName);
            userId = userFriendList.get(0).getUser_id();
        }else {
            List<User> userList = userService.findUserByEmail(new User(userEmail,userPassword));
            userId = userList.get(0).getUser_id();
        }

        if ("tank".equals(itemType)){
            tankId = storeService.getTankIdByName(itemName);

            //根据用户id和tankId查询车库中是由已经有了，如果有了就换算成等值的金币冲入账号
            int hasTank =userService.checkTank(new UserGarage(userId,tankId));
            if (hasTank == 0 ){
                //车库无坦克
                UserGarage userGarage = new UserGarage(null,userId,tankId,0);
                result = userService.BuyTank(userGarage);
            }else {
                //车库有，获取金币值充值
                goldPrice = storeService.getGoldPrice(itemId);
                userGold = userService.getOldGold(userId) + goldPrice;
                premiumMin = userService.getPrMin(userId);
                result = userService.buyGoldOrPrAccount(new User(userId,userGold,premiumMin));
            }
        }else if ("PremiumAccount".equals(itemType)){
            userGold = userService.getOldGold(userId);
            userPrMin = userService.getPrMin(userId);
            //根据itemId查询store表中商品对应的特殊值（高涨天数）
            int prDay = storeService.getAttribute(itemId);
            userPrMin += prDay*24*60;
            result = userService.buyGoldOrPrAccount(new User(userId,userGold,userPrMin));
        }else if ("gold".equals(itemType)){
            userGold = userService.getOldGold(userId);
            userPrMin = userService.getPrMin(userId);
            int gold = storeService.getAttribute(itemId);
            userGold += gold;
            result = userService.buyGoldOrPrAccount(new User(userId,userGold,userPrMin));
        }


        if (result == 1){
            //成功
            response.sendRedirect(request.getContextPath()+"/store/getAll");
        }else {
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    //根据商品id获取
    private void getItemById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        StoreService service = new StoreServiceImpl();
        List<Store> itemList = service.getItemById(Integer.valueOf(id));
        request.setAttribute("itemList",itemList);
        request.getRequestDispatcher("/shopDetail.jsp").forward(request,response);
    }

    //获取全部商品
    private void getAllItems(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StoreService service = new StoreServiceImpl();
        List<Store> storeList = service.getAll();
        request.setAttribute("storeList",storeList);
        request.getRequestDispatcher("/premiumShop.jsp").forward(request,response);
    }
}
