var OpToday = (function($){
    /**
     * 初始化信息
     */
    var init = function(){
        var cla = $("#jrmz").attr("class");
        $("#jrmz").attr("class",cla==null?"active":"active "+cla);
        if( _msg != null ){
            Global.msg(_msg);
            return;
        }
    }
    /**
     * 提交操作
     */
    var save = function(obj){
        Global.msg("asda");
        $.post("/op/save",{id:obj.id},function(data){
        },'json');
    }
    return{
        save:save,
        init:init
    }
})(jQuery)
$(function(){
    OpToday.init();
})