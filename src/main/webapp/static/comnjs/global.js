var Global = (function ($) {
    var validNull = function(node){
        node.on("blur",function(){
            if(this.value.trim()=='')
                $("#"+this.id).focus();
        });
    }
    /**
     * 消息提示
     * @param msg
     * @param time
     */
    var msg = function(msg,time,isConfirm,close,cancel){
        swal({
            text: msg,
            timer: time==null?2000:time,
            showConfirmButton: isConfirm==null?false:true,
            showCloseButton: close==null?true:close,
            showCancelButton:cancel==null?false:cancel
        });
    }
    //退出
    var exit = function(){
        $.ajax({
            method:'get',
            url:'/exit',
            complete:function(data){
                location.reload();
            }
        })
    }
    return {
        exit:exit,
        msg:msg,
        validNull:validNull
    }
})(jQuery)