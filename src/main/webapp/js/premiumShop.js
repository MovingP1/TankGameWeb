var specialItems = $("#specialItems");
var vehicles = $("#tank");
var premiumAccounts = $("#coin");
var golds = $("#gold");

$("#goldClick").click(function(){
    golds.css("display","block");
    premiumAccounts.css("display","none");
    vehicles.css("display","none");
    specialItems.css("display","none");
})
$("#prAccountClick").click(function(){
    golds.css("display","none");
    premiumAccounts.css("display","block");
    vehicles.css("display","none");
    specialItems.css("display","none");
})
$("#vehicleClick").click(function(){
    golds.css("display","none");
    premiumAccounts.css("display","none");
    vehicles.css("display","block");
    specialItems.css("display","none");
})
$("#specialClick").click(function(){
    golds.css("display","none");
    premiumAccounts.css("display","none");
    vehicles.css("display","none");
    specialItems.css("display","block");
})

// var html = "";
//
// $(function (){
//     $.ajax({
//         type:"GET",
//         url:"",
//         // shop=true就返回所有商品[{"itemType":itemType, "itemId":itemId, "detailImg":detailImg, "num":num, "discount":discount, "itemName":itemName, "oldPrice":oldPrice, "newPrice":newPrice} ,"news2":{},{},{},{},{},{}]
//         data:"shop",
//         async:true,
//         //响应后要拿数据回来
//         success : function (json){
//             for(var i=0; i<json.length; i++){
//                 html = "";
//                 var items = json[i];
//                 src = "img/upload/";
//                 if(items.itemType == 'specialItems'){
//                     src += items.detailImg;
//                     html += '<a href="?itemId=';
//                     html += items.itemId;
//                     html += '"><li><div class="item"><div class="img"><img src="';
//                     html += src;
//                     html += '" alt=""></div><div class="num">';
//                     html += items.num;
//                     html += 'ITEMS</div>';
//
//                     html += '<div class="special" id="isSepecialOffeer">SPECIAL OFFER</div><div class="discount" id="discount">';
//                     // -100%off
//                     html += discount;
//                     html += '</div>';
//
//
//                     html += '<div class="itemName">';
//                     html += items.itemName;
//
//                     html += '<div class="oldPrice" id="oldPrice">¥';
//                     html += '</div>';
//
//                     html += '</div><div class="newPrice">¥';
//                     html += items.newPrice;
//                     html += '</div></div></li> </a>';
//
//                     specialItems.append(html);
//                 }
//                 if(items.itemType == 'tank'){
//                     src += items.detailImg;
//                     html += '<a href="?itemId=';
//                     html += items.itemId;
//                     html += '"><li><div class="item"><div class="img"><img src="';
//                     html += src;
//                     html += '" alt=""></div><div class="num">';
//                     html += items.num;
//                     html += 'ITEMS</div>';
//                     html += '<div class="itemName">';
//                     html += items.itemName;
//                     html += '</div><div class="newPrice">¥';
//                     html += items.newPrice;
//                     html += '</div></div></li></a>';
//
//                     vehicles.append(html)
//                 }
//                 if(items.itemType == 'coin'){
//                     src += items.detailImg;
//                     html += '<a href="?itemId=';
//                     html += items.itemId;
//                     html += '"><li><div class="item"><div class="img"><img src="';
//                     html += src;
//                     html += '" alt=""></div><div class="num">';
//                     html += items.num;
//                     html += 'ITEMS</div>';
//                     html += '<div class="itemName">';
//                     html += items.itemName;
//                     html += '</div><div class="newPrice">¥';
//                     html += items.newPrice;
//                     html += '</div></div></li></a>';
//
//                     premiumAccounts.append(html)
//                 }
//                 if(items.itemType == 'gold'){
//                     src += items.detailImg;
//                     html += '<a href="?itemId=';
//                     html += items.itemId;
//                     html += '"><li><div class="item"><div class="img"><img src="';
//                     html += src;
//                     html += '" alt=""></div><div class="num">';
//                     html += items.num;
//                     html += 'ITEMS</div>';
//                     html += '<div class="itemName">';
//                     html += items.itemName;
//                     html += '</div><div class="newPrice">¥';
//                     html += items.newPrice;
//                     html += '</div></div></li></a>';
//
//                     golds.append(html)
//                 }
//             }
//         }
//     })
// })