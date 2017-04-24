var DrugAdd = (function($){
    var init = function(){
        var node = $("#drug input");
        Global.validNull(node);
    }

    var submit = function(){
        var param = {};
        var node = null;
        if(Gvali.notBlankValue(node = $("#code")))
            param.code = node.val();
        if(Gvali.notBlankValue(node = $("#name")))
            param.name = node.val();
        if(Gvali.notBlankValue(node = $("#type")))
            param.type = node.val();
        if(Gvali.notBlankValue(node = $("#attention")))
            param.attention = node.val();
        if(Gvali.notBlankValue(node = $("#format")))
            param.format = node.val();
        if(Gvali.notBlankValue(node = $("#prd_date")))
            param.prd_date = node.val();
        if(Gvali.notBlankValue(node = $("#valid_date")))
            param.valid_date = node.val();
        if(Gvali.notBlankValue(node = $("#shape")))
            param.shape = node.val();
        if(Gvali.notBlankValue(node = $("#counts")))
            param.counts = node.val();
        if(Gvali.notBlankValue(node = $("#prd_phone")))
            param.prd_phone = node.val();
        if(Gvali.notBlankValue(node = $("#prd_firm")))
            param.prd_firm = node.val();
        if(Gvali.notBlankValue(node = $("#uses")))
            param.uses = node.val();
        if(Gvali.notBlankValue(node = $("#dosage")))
            param.dosage = node.val();
        var form = $("#drug")[0];
        form.action="/drug/add";
        form.method="post";
        form.submit();
    }
    return{
        init:init,
        submit:submit
    }
})(jQuery)
$(function(){
    DrugAdd.init();
})