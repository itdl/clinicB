var OpToday = (function($){
    /**
     * 提交操作
     */
    var save = function(obj){
        Global.msg("asda");
        $.post("/op/save",{id:obj.id},function(data){
        },'json');
    }
    return{
        save:save
    }
})(jQuery)