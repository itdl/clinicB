var Staff = (function ($) {
    /**
     * 初始化
     */
    var init = function () {
        /** 菜单选中 */
        var cla = $("#ygpz").attr("class");
        $("#ygpz").attr("class",cla==null?"active":"active "+cla);
        if(_res==null)
            return;
        Global.msg(_msg);
        if(_res=='T'){
            window.setTimeout('window.location.href="/cmgr/staff"',2000);
            return;
        }
    }
    /**
     * 进入详情页面
     * @param node
     */
    var details = function(node){
        var form = $("#"+node.name)[0];
        form.action = "/cmgr/staff/details";
        form.method = "post";
        form.submit();
    }
    return {
        init: init,
        details:details
    }
})(jQuery)
$(function () {
    Staff.init();
})