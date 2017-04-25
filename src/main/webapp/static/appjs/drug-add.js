var DrugAdd = (function ($) {
    var init = function () {
        var node = $("#drug input");
        Global.validNull(node);
        if(_res==null)
            return;
        Global.msg(_msg);
        if(_res=='T'){
            window.setTimeout('window.location.href="/drug/check"',2000);
            return;
        }
    }

    var addDrug = function () {
        if (!Gvali.notBlankValue($("#code").val())){
            return;
        }
        if (!Gvali.notBlankValue($("#name"))){
            return;
        }
        if (!Gvali.notBlankValue($("#type"))){
            return;
        }
        if (!Gvali.notBlankValue($("#attention"))){
            return;
        }
        if (!Gvali.notBlankValue($("#format"))){
            Global.msg("药品规格不能为空");
        }
        if (!Gvali.notBlankValue($("#prd_date"))){
            Global.msg("药品生产日期不能为空");
        }
        if (!Gvali.notBlankValue($("#valid_date"))){
            Global.msg("药品有效日期不能为空");
        }
        if (!Gvali.notBlankValue($("#shape"))){
            Global.msg("药品性状不能为空");
        }
        if (!Gvali.notBlankValue($("#counts"))){
            Global.msg("药品数量不能为空");
        }
        var form = $("#drug")[0];
        form.action = "/drug/addDrug";
        form.method = "post";
        form.submit();
    }
    return {
        init: init,
        addDrug: addDrug
    }
})(jQuery)
$(function () {
    DrugAdd.init();
})