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

    var subCfg = function () {
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
        $.post("")
    }
    return {
        init: init,
        subCfg: subCfg
    }
})(jQuery)
$(function () {
    YyCfg.init();
})