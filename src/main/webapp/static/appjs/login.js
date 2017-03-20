var Login = (function($){
    var init = function(){
        $("#recoverform").css('display',fg=="error"? 'block': 'none');
        $("#login").on('click',function(){
            login();
        })
        // document.onkeydown = function (event) {
        //     var e = event || window.event || arguments.callee.caller.arguments[0];
        //     if (e && e.keyCode == 13) {
        //         $("#loginBtn").click();
        //     }
        // };
    };
    /**
     * 登录
     */
    var login = function(){
        var form = $("#loginform")[0];
        form.action = "/main";
        form.method = "post";
        form.submit();
    }
    /**
     * 回车事件
     */
    var keyLogin = function(){
        if (event.keyCode==13)
            $("#login").click(); //调用登录按钮的登录事件
    }
    return {
        init:init,
        keyLogin:keyLogin
    }
})(jQuery)
$(function(){
    Login.init();
})