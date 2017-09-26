var Resume = (function($){
    var init = function(){
        var cla = $("#blck").attr("class");
        $("#blck").attr("class",cla==null?"active":"active "+cla);
        if(_res==null)
            return;
        Global.msg(_msg);
    }

    /**
     * 查看病历详细
     * @param node
     */
    var detail = function(node){
        var node = $("#"+node.name)[0];
        node.method = 'post';
        node.action = '/op/resume/detail';
        node.submit();
    }
    return {
        init:init,
        detail:detail
    }
})(jQuery)
$(function(){
    Resume.init();
})