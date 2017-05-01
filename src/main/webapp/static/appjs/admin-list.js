var AdminList = (function ($) {
    var init = function () {
        var cla = $("#zsgl").attr("class");
        $("#zsgl").attr("class",cla==null?"active":"active "+cla);
        if(_res==null)
            return;
        Global.msg(_msg);
        if(_res=='T')
            window.setTimeout('window.location.reload()',2000);
    }
    var del = function(obj){
        var node = $("#"+obj.name)[0];
        node.method = 'post';
        node.action = '/cmgr/admins/del';
        node.submit();
    }
    return {
        init: init,
        del:del
    }
})(jQuery)
$(function () {
    AdminList.init();
})