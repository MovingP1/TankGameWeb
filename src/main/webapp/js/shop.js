var purchase = document.getElementById("purchase");
var quit = document.getElementById("quit");
var payme = document.getElementById("payme");
var payfriend = document.getElementById("payfriend");
var meSub = document.getElementById("paymeSub");
var friendSub = document.getElementById("payfriendSub");
var owner = document.getElementById("owner");
var friendName = document.getElementById("friendName");
var bg = document.getElementById("namebg");
var realpay = document.getElementById("Realpayfriend");
var bgquit = document.getElementById("bgquit");

pay.onclick = function(){
    purchase.style.display = "block";
}
quit.onclick = function(){
    purchase.style.display = "none";
}

payfriend.onclick = function(){
    owner.value = "friend";
    bg.style.display = "block";
    friendName.style.display = "block";
    realpay.style.display = "block";
    bgquit.style.display = "block";
    payme.style.display = "none";
    payfriend.style.display = "none";
}
// form提交
realpay.onclick = function(){
    friendSub.click();
}
payme.onclick = function(){
    owner.value = 'me';
    meSub.click();
}
bgquit.onclick = function(){
    bg.style.display = "none";
    bgquit.style.display = "none";
    realpay.style.display = "none";
    payme.style.display = "block";
    payfriend.style.display = "block";
}