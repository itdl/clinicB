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
        if (!Gvali.notBlankValue($("#code").val()))
            return;
        if (!Gvali.notBlankValue($("#name").val()))
            return;
        if (!Gvali.notBlankValue($("#type").val()))
            return;
        if (!Gvali.notBlankValue($("#attention").val()))
            return;
        if (!Gvali.notBlankValue($("#format").val()))
            return;
        if (!Gvali.notBlankValue($("#prd_date").val()))
            return;
        if (!Gvali.notBlankValue($("#valid_date").val()))
            return;
        if (!Gvali.notBlankValue($("#shape").val()))
            return;
        if (!Gvali.notBlankValue($("#counts").val()))
            return;
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