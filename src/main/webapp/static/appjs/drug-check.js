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
    return {
        init: init,
        goDetail:goDetail
    }
})(jQuery)
$(function () {
    DrugCheck.init();
})