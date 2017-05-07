var StaffDetails = (function ($) {
    /**
     * 初始化
     */
    var init = function () {
        /** 菜单选中 */
        var cla = $("#ygpz").attr("class");
        $("#ygpz").attr("class",cla==null?"active":"active "+cla);
        if(_staff!=null){
            $("#sex option[value="+_staff.sex+"]").attr("selected","selected");
            $("#edu option[value="+_staff.edu+"]").attr("selected","selected");
            $("#isjob option[value="+_staff.isjob+"]").attr("selected","selected");
        }
        if(_res==null)
            return;
        Global.msg(_msg);
        if(_res=='T'){
            window.setTimeout('window.location.href="/cmgr/staff"',2000);
            return;
        }
    }
    /**
     * 添加员工
     * @param node
     */
    var update = function(node){
        var form = $("#staff")[0];
        switch(node.id) {
            case 'update':
                form.action = "/cmgr/staff/update";
                break;
            case 'add':
                form.action = "/cmgr/staff/add";
        }
        form.method = "post";
        form.submit();
    }
    var del = function(node){
        var form = $("#staff")[0];
        form.action = "/cmgr/staff/del";
        form.method = "post";
        form.submit();
    }
    return {
        init: init,
        update:update,
        del:del
    }
})(jQuery)
$(function () {
    StaffDetails.init();
})