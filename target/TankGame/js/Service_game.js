var title = $("#title");
var info = $("#info");
var titleAfter = "";

function ajaxInfo(afterInfo){
    $.ajax({
        type:"GET",
        url:"/",
        data:"title="+afterInfo,
        async:true,
        //响应后要拿数据回来
        success : function (infotext){
            info.text(infotext)
        }
    });
    title.text(afterInfo);
}

// game
$("#baseInfo").click(function(){
    titleAfter = $("#baseInfo").text();
    ajaxInfo(titleAfter);
});
$("#coin").click(function(){
    titleAfter = $("#coin").text();
    ajaxInfo(titleAfter);
});
$("#premiumAccount").click(function(){
    titleAfter = $("#premiumAccount").text();
    ajaxInfo(titleAfter);
});
$("#exp").click(function(){
    titleAfter = $("#exp").text();
    ajaxInfo(titleAfter);
});
$("#problem").click(function(){
    titleAfter = $("#problem").text();
    ajaxInfo(titleAfter);
});

// payment
$("#howtopay").click(function(){
    titleAfter = $("#howtopay").text();
    ajaxInfo(titleAfter);
});
$("#cupon").click(function(){
    titleAfter = $("#cupon").text();
    ajaxInfo(titleAfter);
});
$("#payback").click(function(){
    titleAfter = $("#payback").text();
    ajaxInfo(titleAfter);
});
$("#purchaseVoucher").click(function(){
    titleAfter = $("#purchaseVoucher").text();
    ajaxInfo(titleAfter);
});

// report
$("#aboutTK").click(function(){
    titleAfter = $("#aboutTK").text();
    ajaxInfo(titleAfter);
});
$("#idRule").click(function(){
    titleAfter = $("#idRule").text();
    ajaxInfo(titleAfter);
});
$("#whyBan").click(function(){
    titleAfter = $("#whyBan").text();
    ajaxInfo(titleAfter);
});
$("#howtoReport").click(function(){
    titleAfter = $("#howtoReport").text();
    ajaxInfo(titleAfter);
});
$("#fareRule").click(function(){
    titleAfter = $("#fareRule").text();
    ajaxInfo(titleAfter);
});

// tec
$("#notEnoughDisk").click(function(){
    titleAfter = $("#notEnoughDisk").text();
    ajaxInfo(titleAfter);
});
$("#howtoUnist").click(function(){
    titleAfter = $("#howtoUnist").text();
    ajaxInfo(titleAfter);
});
$("#systemRequire").click(function(){
    titleAfter = $("#systemRequire").text();
    ajaxInfo(titleAfter);
});
$("#lowFPS").click(function(){
    titleAfter = $("#lowFPS").text();
    ajaxInfo(titleAfter);
});
$("#cantVisit").click(function(){
    titleAfter = $("#cantVisit").text();
    ajaxInfo(titleAfter);
});

// user
$("#deleteAccount").click(function(){
    titleAfter = $("#deleteAccount").text();
    ajaxInfo(titleAfter);
});
$("#changeUsername").click(function(){
    titleAfter = $("#changeUsername").text();
    ajaxInfo(titleAfter);
});
$("#changeEmail").click(function(){
    titleAfter = $("#changeEmail").text();
    ajaxInfo(titleAfter);
});
$("#resetPassword").click(function(){
    titleAfter = $("#resetPassword").text();
    ajaxInfo(titleAfter);
});
$("#bindTele").click(function(){
    titleAfter = $("#bindTele").text();
    ajaxInfo(titleAfter);
});
