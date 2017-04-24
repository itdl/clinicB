var OpToday = (function($){
    /**
     * 初始化信息
     */
    var init = function(){
        if( _msg != null )
            Global.msg(_msg);
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