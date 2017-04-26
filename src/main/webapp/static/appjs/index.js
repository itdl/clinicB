var Index = (function($){
    var init = function(){
        var cla = $("#sy").attr("class");
        $("#sy").attr("class",cla==null?"active":"active "+cla);
    }
    var goPage = function(newURL){
        if (newURL != "") {
            if (newURL == "-") {
                resetMenu();
            }
            else {
                document.location.href = newURL;
            }
        }
    }
    /**
     * 菜单重新设置
     */
    var resetMenu = function(){
        document.gomenu.selector.selectedIndex = 2;
    }
    return {
        goPage:goPage,
        init:init
    }
})(jQuery)
$(function(){
    Index.init();
})
