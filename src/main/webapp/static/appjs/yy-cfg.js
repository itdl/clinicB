var YyCfg = (function ($) {
    var init = function () {
        /** 菜单选中 */
        var cla = $("#yypz").attr("class");
        $("#yypz").attr("class",cla==null?"active":"active "+cla);
        if(_res==null)
            return;
        Global.msg(_msg);
        if(_res=='T'){
            window.setTimeout('window.location.href="/drug/check"',2000);
        }
    }

    var subCfg = function (node) {
        var param = {};
        var time = "";
        $('input:checkbox[name=times]:checked').each(function() {
            if ($(this).attr('checked')=='checked')
                time+= this.value+',';
        });
        if(time!='')
            param.time = time.substring(0,time.length-1);
        var used = $('input:radio[name=radios]:checked').val();
        if(used != "")
            param.used = used;
        param.date = node.id.substring(0,node.id.indexOf('.'));
        if(param.time!='1,2,3' && used!='0'){
            Global.msg(param.date+"有停诊信息,【是否停诊】选项请选择停诊!");
            return ;
        }
        $.post("/yy/chg",param,function(data){
            Global.msg(data.msg);
        },'json');
    }
    return {
        init: init,
        subCfg: subCfg
    }
})(jQuery)
$(function () {
    YyCfg.init();
})