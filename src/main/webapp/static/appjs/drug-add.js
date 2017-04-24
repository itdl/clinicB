var DrugAdd = (function ($) {
    var init = function () {
        var node = $("#drug input");
        Global.validNull(node);
    }

    var addDrug = function () {
        var param = {};
        var node = null;
        if (!Gvali.notBlankValue(node = $("#code")))
            return;
        param.code = node.val();
        if (!Gvali.notBlankValue(node = $("#name")))
            return;
        param.name = node.val();
        if (!Gvali.notBlankValue(node = $("#type")))
            return;
        param.type = node.val();
        if (!Gvali.notBlankValue(node = $("#attention")))
            return;
        param.attention = node.val();
        if (!Gvali.notBlankValue(node = $("#format")))
            return;
        param.format = node.val();
        if (!Gvali.notBlankValue(node = $("#prd_date")))
            return;
        param.prd_date = node.val();
        if (!Gvali.notBlankValue(node = $("#valid_date")))
            return;
        param.valid_date = node.val();
        if (!Gvali.notBlankValue(node = $("#shape")))
            return;
        param.shape = node.val();
        if (!Gvali.notBlankValue(node = $("#counts")))
            return;
        param.counts = node.val();
        if (!Gvali.notBlankValue(node = $("#prd_phone")))
            return;
        param.prd_phone = node.val();
        if (!Gvali.notBlankValue(node = $("#prd_firm")))
            return;
        param.prd_firm = node.val();
        if (!Gvali.notBlankValue(node = $("#uses")))
            return;
        param.uses = node.val();
        if (!Gvali.notBlankValue(node = $("#dosage")))
            return;
        param.dosage = node.val();
        var form = $("#drug")[0];
        form.action = "/drug/add";
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