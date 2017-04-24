var Gvali = (function($){
    var reg = [];
    var init = function(){
        //是否手机
        reg["isMobile"]=/(^(13|14|15|17|18)\d{9}$)|(^0(([1,2]\d)|([3-9]\d{2}))\d{7,8}$)/;
        //是否座机
        reg["isTel"]=/^\d{3,4}-?\d{7,9}$/;
        //是否真实用户名 ,纯中文或纯英文,2到10个字
        reg["isTrueName"]=/(^[a-zA-Z]{4,50}(\ [a-zA-Z]{2,})*$)|(^[\u2E80-\uFEFF]{2,}(\·[\u2E80-\uFEFF]{2,})*$)/;
        //是否正整数
        reg["isPositiveInt"]=/^[1-9]\d*$/;
        //不太严格通用证件号
        reg["isCommonCard"]=/^[a-zA-Z0-9\u4E00-\u9FA5]+$/;
        //军官证
        reg["isJunguan"]=/\S{8,10}/;
        //港澳通行证
        reg["isGangao"]=/\S{9,12}/;
        //台胞证
        reg["isTaibao"]=/\d{8,11}/;
        //护照
        reg["isPassport"]=/\S{8,14}/;
        //排除非法字符
        reg["isSpecialWord"]=/[_\w]+$/;
        //日期格式验证正则
        reg["isDate"]=/^(\d{4})-(\d{2})-(\d{2})$/;
    }
    var isPositiveInt = function(value){
        return reg["isPositiveInt"].test(value);
    };
    //是否重复的字符,支持中英文
    var isMobile = function(value){
        if(value == '13800138000'){
            return false;
        }
        return reg["isMobile"].test(value);
    };
    //是否重复的字符,支持中英文
    var isNotSameChar = function(value){
        var isSame = false;
        var count = findStr(value,value.charCodeAt(0));
        if(count == value.length){
            isSame = true;
        }
        if(false == isSame){
            return true;
        }else if (true == isSame){
            return false;
        }
    };
    //判断是否纯数字并非0开始
    var isNumber = function(value){
        return reg["isPositiveInt"].test(value);
    };

    //判断是否是正常的用户名
    var isName = function(value) {
        return reg["isTrueName"].test(value);
    };
    //含有特殊字符返回true
    var isSpecialWord = function(value) {
        return reg["isSpecialWord"].test(value);
    };
    //是否是日期yyyy-MM-dd
    var isDate = function(value) {
        return reg["isDate"].test(value);
    };

    //手机或座机均可
    var isPhone = function(value){
        var isok = false;
        if(isMobile(value)){
            isok = true;
        }
        if(reg["isTel"].test(value)){
            isok = true;
        }
        return isok;
    };

    //是否身份证
    var isIdCard = function(value){
        card_number = value.toLowerCase();
        var aCity = {11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"};
        if (!/^\d{17}(\d|x)$/i.test(card_number)) {
            //身份证不能为空
            return false;
        } else {
            card_number = card_number.replace(/x$/i, "a");
            if (aCity[parseInt(card_number.substr(0, 2))] == null) {
                //你的身份证地区非法
                return false;
            } else {
                var sBirthday = card_number.substr(6, 4) + "-" + Number(card_number.substr(10, 2)) + "-" + Number(card_number.substr(12, 2));
                var d = new Date(sBirthday.replace(/-/g, "/"));
                if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) {
                    //身份证上的出生日期非法
                    return false;
                } else {
                    var iSum = 0;
                    for (var i = 17; i >= 0; i--) {
                        iSum += (Math.pow(2, i) % 11) * parseInt(card_number.charAt(17 - i), 11);
                    }
                    if (iSum % 11 != 1) {
                        //你输入的身份证号非法
                        return false;
                    }
                    return true;
                }
            }
        }
    };
    //是否任意一种证件号,逐一判断各类证件
    var isAllId = function(value){
        var isok = false;
        if(isIdCard(value)){
            isok = true;
        }
        if(reg["isJunguan"].test(value)){
            isok = true;
        }
        if(reg["isGangao"].test(value)){
            isok = true;
        }
        if(reg["isTaibao"].test(value)){
            isok = true;
        }
        if(reg["isPassport"].test(value)){
            isok = true;
        }
        return isok;
    };
    //验证密码强度
    var passstrong = function(value) {
        var a = true;
        var d = new RegExp("(?![a-z]+$|[A-Z]+$|[0-9]+$|_+$)^[a-zA-Z0-9_]{6,12}$");
        if(d.test(value)){
            a = true;
        }else{
            a = false;
        }
        return a;
    };
    //验证值是否为空或空格.
    var notBlankValue = function(node) {
        var value = $.trim(node.val());
        if(typeof(value) == "undefined"||!value){
            node.focus();
            return false;
        }
        return true ;
    };
    //是否任意一种证件号,逐一判断各类证件
    var isSpecifyId = function(idType, idNo){
        var isok = false;
        if(idType == 1 && isIdCard(idNo)){
            isok = true;
        }
        if(idType == 2 && reg["isJunguan"].test(idNo)){
            isok = true;
        }
        if(idType == 4 && reg["isGangao"].test(idNo)){
            isok = true;
        }
        if(idType == 5 && reg["isTaibao"].test(idNo)){
            isok = true;
        }
        if(idType == 3 && reg["isPassport"].test(idNo)){
            isok = true;
        }
        return isok;
    };
    //计算某个字符在字符串中的个数,支持中文
    var findStr = function (str,word){
        var tem = 0;//用来计数;
        for(var i=0;i<str.length;i++){
            if(str.charCodeAt(i) == word){
                tem++;
            }
        }
        return tem;
    };
    //得到字符总数,支持中文,一个中文数量上算作2
    var getChars = function (str) {
        var i = 0;
        var c = 0.0;
        var unicode = 0;
        var len = 0;
        if (str == null || str == "") {
            return 0;
        }
        len = str.length;
        for (i = 0; i < len; i++) {
            unicode = str.charCodeAt(i);
            if (unicode < 127) { //判断是单字符还是双字符
                c += 1;
            } else { //chinese
                c += 2;
            }
        }
        return c;
    }
    //截取字符,支持中文
    var sb_substr = function (str, startp, endp) {
        var i = 0;
        c = 0;
        unicode = 0;
        rstr = '';
        var len = str.length;
        var sblen = sb_strlen(str);
        if (startp < 0) {
            startp = sblen + startp;
        }
        if (endp < 1) {
            endp = sblen + endp; // - ((str.charCodeAt(len-1) < 127) ? 1 : 2);
        }
        // 寻找起点
        for (i = 0; i < len; i++) {
            if (c >= startp) {
                break;
            }
            var unicode = str.charCodeAt(i);
            if (unicode < 127) {
                c += 1;
            } else {
                c += 2;
            }
        }
        // 开始取
        for (i = i; i < len; i++) {
            var unicode = str.charCodeAt(i);
            if (unicode < 127) {
                c += 1;
            } else {
                c += 2;
            }
            rstr += str.charAt(i);
            if (c >= endp) {
                break;
            }
        }
        return rstr;
    }
    //endDate 小于 startDate返回false
    var compareDate = function (startDate, endDate){
        var start = new Date(startDate.replace("-", "/").replace("-", "/"));
        var end = new Date(endDate.replace("-", "/").replace("-", "/"));
        if(end < start){
            return false;
        }
        return true;
    }
    // 根据身份证获取信息
    var IdCard = function (UUserCard,num){
        if(UUserCard != null){

            if(num==1){
                // 获取出生日期
                birth=UUserCard.substring(6, 10) + "-" + UUserCard.substring(10, 12) + "-" + UUserCard.substring(12, 14);
                return birth;
            }
            if(num==2){
                // 获取性别
                if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) {
                    // 男
                    return 1;
                } else {
                    // 女
                    return 2;
                }
            }
            if(num==3){
                // 获取年龄
                var myDate = new Date();
                var month = myDate.getMonth() + 1;
                var day = myDate.getDate();
                var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1;
                if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) {
                    age++;
                }
                return age;
            }
        }
    }
    return {
        init:init,
        IdCard:IdCard,
        compareDate:compareDate,
        sb_substr:sb_substr,
        getChars:getChars,
        findStr:findStr,
        isSpecifyId:isSpecifyId,
        notBlankValue:notBlankValue,
        passstrong:passstrong,
        isAllId:isAllId,
        isIdCard:isIdCard,
        isPhone:isPhone,
        isDate:isDate,
        isSpecialWord:isSpecialWord,
        isName:isName,
        isNumber:isNumber,
        isNotSameChar:isNotSameChar,
        isMobile:isMobile,
        isPositiveInt:isPositiveInt
    }
})(jQuery);
/**********************************在此添加验证函数*******************************/
$(function(){
    Gvali.init();
})