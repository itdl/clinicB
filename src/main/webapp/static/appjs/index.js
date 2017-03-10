var Index = (function($){
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
        goPage:goPage
    }
})(jQuery)
$(function(){

})
