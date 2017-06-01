var DrugCheck = (function ($) {
    var init = function () {
        var cla = $("#yppd").attr("class");
        $("#yppd").attr("class",cla==null?"active":"active "+cla);
        $("form").removeAttr("style");
        if(_res==null)
            return;
        Global.msg(_msg);
    }
    var goDetail = function(obj){
        var node = $("#"+obj.name)[0];
        node.method = 'post';
        node.action = '/drug/details';
        node.submit();
    }

    var select = function(){
        var selform = $("#select")[0];
        if($("#ser_code").val().trim()=='')
            $("#ser_code").val(null);
        if($("#ser_name").val().trim()=='')
            $("#ser_name").val(null);
        selform.submit();
    }

    return {
        init: init,
        goDetail:goDetail,
        select:select
    }
})(jQuery)
$(function () {
    DrugCheck.init();
})