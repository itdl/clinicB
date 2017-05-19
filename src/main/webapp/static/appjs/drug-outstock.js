var DrugOutStock = (function ($) {
    var init = function () {
        var cla = $("#ypck").attr("class");
        $("#ypck").attr("class",cla==null?"active":"active "+cla);
        $("form").removeAttr("style");
        if(_res==null)
            return;
        Global.msg(_msg);
    }
    var drugOut = function(obj){
        var stockAct = $("#outAct").val();
        if(stockAct > obj.name.split('_')[1]){
            Global.msg("您输入的药品数量超库存了亲!");
            return;
        }
        var param = {};
        param.stockAct = stockAct;
        param.code = obj.name.split('_')[0];
        $.post("/drug/outstock",param,function(data){
            Global.msg(data.msg);
            if(data.flag=="T")
                window.setTimeout('window.location.reload()',2000);
        });
    }
    return {
        init: init,
        drugOut:drugOut
    }
})(jQuery)
$(function () {
    DrugOutStock.init();
})