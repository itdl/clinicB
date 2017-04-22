/**
 * 格式化函数
 */
var fmt = {
		/**
		 * 格式化订单状态
		 * 
		 * @param v
		 */
		formatOrderStatus : function(source) {
			if (typeof source == 'undefined' || !source) {
				return "未知";
			}
			switch (source) {
			case '1':
				return "订单成功";
			case '2':
				return "取消订单";
			case '4':
				return "已就诊";
			case '8':
				return "订单失败";
			case '16':
				return "已入队";
			case '32':
				return "考虑排队";
			case '64':
				return "爽约";
			case '128':
				return "病人取号";
			case '256':
				return "不能替换停诊";
			case '512':
				return "同级替换停诊";
			case '1024':
				return "降级替换停诊";
			case '2048':
				return "升级替换停诊";
			case '4096':
				return "已过期";
			default:
				return "未知";
			}
		},
	formatFHPeriodUnit : function(source) {
		var fhPeriodUnit = [];
		fhPeriodUnit['1'] = "天";
		fhPeriodUnit['2'] = "周";
		fhPeriodUnit['3'] = "月";
		return typeof (fhPeriodUnit[source]) == "undefined" ? ""
				: fhPeriodUnit[source];
	},
	formatOrderType : function(source) {
        if (source == undefined||source==null){
            return "未知";
        }
        switch (source) {
            case 0:
                return "已预约";
            case 1:
                return "已就诊";
            case 2:
            	return "取消预约";
            case 3:
                return "爽约";
            default:
                return "未知";
        }
	},
	formatScheduleEditType : function(v) {
		var t = [];
		t["1"] = "号源数";
		t["2"] = "周停诊";
		t["3"] = "全停诊";
		return typeof (t[v]) == "undefined" ? "" : t[v];
	},
	/**
	 * 格式化就诊时间段(上下午晚上)
	 * 
	 * @param source
	 */
	formatDutyCode : function(source) {
		if (typeof source == 'undefined' || !source) {
			return "未知";
		}
		switch (source) {
		case '1':
			return "上午";
		case '2':
			return "下午";
		case '3':
			return "晚上";
		default:
			return "未知";
		}
	},
	/**
	 * 根据数字转换中文星期
	 * 
	 * @param source
	 * @returns {String}
	 */
	formatWeekDay : function(source) {
		if (typeof source == 'undefined' || !source) {
			return "未知";
		}
		switch (source) {
		case '1':
			return "星期一";
		case '2':
			return "星期二";
		case '3':
			return "星期三";
		case '4':
			return "星期四";
		case '5':
			return "星期五";
		case '6':
			return "星期六";
		case '7':
			return "星期日";
		default:
			return "未知";
		}
	},
	/**
	 * 格式化金额,默认保留两位小数
	 * 
	 * @param source
	 * @param point
	 * @returns
	 */
	formatMoney : function(source, point) {
		if (typeof source == 'undefined' || !source) {
			return "￥0.00";
		}
		var f_x = parseFloat(source);
		if (isNaN(f_x)) {
			alert('parameter error');
			return false;
		}
		if (!point) {
			point = 2;
		}
		f_x = Math.round(f_x * 100) / 100;
		var s_x = f_x.toString();
		var pos_decimal = s_x.indexOf('.');
		if (pos_decimal < 0) {
			pos_decimal = s_x.length;
			s_x += '.';
		}
		while (s_x.length <= pos_decimal + point) {
			s_x += '0';
		}
		return '￥' + s_x;
	},
	/**
	 * 格式化是否停诊
	 * 
	 * @param source
	 * @returns {String}
	 */
	formatIfDutyOff : function(source) {
		if (typeof source == 'undefined' || !source) {
			return "未知";
		}
		if (source == '1') {
			return "否";
		} else if (source == '2') {
			return "是";
		}
		return "未知";
	},
	/**
	 * 格式化性别
	 * 
	 * @param source
	 * @returns {String}
	 */
	formatGender : function(source) {
		if (typeof source == 'undefined' || !source) {
			return "未知";
		}
		switch (source) {
		case '1':
			return "男";
		case '2':
			return "女";
		default:
			return "未知";
		}
	},
	/**
	 * 格式化证件类型
	 * 
	 * @param source
	 * @returns {String}
	 */
	formatIdType : function(source) {
		if (typeof source == 'undefined' || !source) {
			return "未知";
		}
		switch (source) {
		case '1':
			return "身份证";
		case '2':
			return "军官证";
		case '3':
			return "护照";
		case '4':
			return "港澳通行证";
		case '5':
			return "台胞证";
		case '6':
			return "儿童其他证件";
		default:
			return "未知";
		}
	},
	/**
	 * 格式化排班修改类型
	 * 
	 * @param source
	 * @returns {String}
	 */
	formatScheduleEditType : function(source) {
		if (typeof source == 'undefined' || !source) {
			return "未知";
		}
		switch (source) {
		case '1':
			return "号源数";
		case '2':
			return "周停诊";
		case '3':
			return "全停诊";
		default:
			return "未知";
		}
	}
};