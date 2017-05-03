var AdminAdd = (function ($) {
    var init = function () {
        var cla = $("#glypz").attr("class");
        $("#glypz").attr("class",cla==null?"active":"active "+cla);
        var node = $("#admin input");
        Global.validNull(node);
        if(_res==null)
            return;
        if(_res=='T')
            window.setTimeout('window.location.href="/cmgr/admins"',2000);
        Global.msg(_msg);
    }

    var addAdmin = function () {
        if (!Gvali.notBlankValue($("#name").val()))
            return;
        if (!Gvali.notBlankValue($("#power").val()))
            return;
        if ($("#pwd").val()!=$("#pwd2").val()){
            alert("两次输入密码不相同!");
            return;
        };
        var form = $("#admin")[0]
        form.action = "/cmgr/admins/addsub";
        form.method = "post";
        form.submit();
    }
    return {
        init: init,
        addAdmin: addAdmin
    }
})(jQuery)
$(function () {
    AdminAdd.init();
})