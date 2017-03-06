var Login = (function($){
    var init = function(){
        if (window != top) {
            top.location.href = location.href;
        }
        $('#loginBtn').on('click',function(){
            if($('#userId').val().trim() == ''){
                $('#errorMsg').html('请输入用户名');
                return;
            }
            if($('#passWord').val().trim() == ''){
                $('#errorMsg').html('请输入密码');
                return;
            }
            $('#loginForm').submit();
        });
    };

    var keyLogin = function(){
        if (event.keyCode==13)
            $("#loginBtn").click(); //调用登录按钮的登录事件
    }
    return {
        init:init,
        keyLogin:keyLogin
    }
})(jQuery)
$(function(){
    Login.init();
})