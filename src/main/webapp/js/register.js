var email = $("#email");
var password = $("#password");
var checkPassword = $("#check");
var submit = $("#submit");
var checkbx = $("#checkbx");
var realSub = document.getElementById("realSub");
var IsUsed = 110;

$(function () {
    realSub.style.display = "none";

    email.blur(function () {
        $.ajax({
            type:"POST",
            url:"/TankGame/user/checkEmail",
            data:"email="+email.val(),
            async:true,
            success:function (isUsed) {
                IsUsed = isUsed;
                if (IsUsed == 0){
                    $("#emailTip").html(" ");
                    $("#emailTip").html("&#xe610;");
                }else if (IsUsed != 0){
                    $("#emailTip").html(" ");
                    $("#emailTip").html("&#xe616;");
                }
            }
        })
    })
    email.focus(function () {
        $("#emailTip").html(" ");
    })

    checkPassword.blur(function () {
        if (password.val() !="" && checkPassword.val()!="" && (password.val() == checkPassword.val())){
            $("#passwordTip").html(" ");
            /*对*/
            $("#passwordTip").html("&#xe610;");
        }else {
            $("#passwordTip").html(" ");
            $("#passwordTip").html("&#xe616;");
        }
    })
    checkPassword.focus(function () {
        $("#passwordTip").html(" ");
    })

    submit.click(function () {
        /* && checkbx.attr('checked')*/
        if (checkPassword.val() != ""){
            if ( email.val() != ""){
                if (IsUsed != 0){
                    $("#noPwd").css("display","none");
                    $("#pwdNotRight").css("display","none");
                    $("#noEmail").css("display","none");
                    $("#eUsed").css("display","block");
                }else if (password.val() !="" && checkPassword.val()!="" && (password.val() == checkPassword.val())){
                    realSub.click();
                }else {
                    $("#noPwd").css("display","none");
                    $("#noEmail").css("display","none");
                    $("#eUsed").css("display","none");
                    $("#pwdNotRight").css("display","block");
                }
            }else {
                $("#noPwd").css("display","none");
                $("#pwdNotRight").css("display","none");
                $("#eUsed").css("display","none");
                $("#noEmail").css("display","block");
            }
        }else {
            $("#noEmail").css("display","none");
            $("#pwdNotRight").css("display","none");
            $("#eUsed").css("display","none");
            $("#noPwd").css("display","block");
        }
    })
})