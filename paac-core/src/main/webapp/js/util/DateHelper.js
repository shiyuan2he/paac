/**
 * 
 * @description <p>时间格式化</p>
 * @param format
 * @returns {String}
 * @returnType String
 * 方法名:format
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月2日 下午3:48:37
 * @price ￥:三毛三
 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
Date.prototype.format = function(format) {
	if (!format) {
		format = "yyyy-MM-dd hh:mm:ss";
	}
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	// millisecond
	};
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};
var DateHelper = {
	/**
	 * 
	 * @description <p>获取当前年份和月份</p>
	 * @returns
	 * @returnType any
	 * 方法名:getYearAndMonth
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月2日 下午4:10:17
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	getYearAndMonth : function(){
		 var date = new Date;
		 var year = date.getFullYear(); 
		 var month = date.getMonth() + 1;
		 month = (month<10 ? "0"+month:month); 
		 return year.toString() + "." + month.toString();
	},
	/**
	 * @description <p>请在这里输入方法的作用</p>
	 * @param str
	 * @param format
	 * @returnType void
	 * 方法名:formatDateTime
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月2日 下午3:49:40
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	formatDateTime : function(str, format){
		if (str == null)
			return "";
		else {
			// 如果未传入格式化格式默认转成"yyyy-MM-dd hh:mm:ss"
			if (format == '' || format == null || format == undefined) {
				format = "yyyy-MM-dd hh:mm:ss";
			}
			if (str instanceof Date)
				return str.format(format);
			var array = str.split("T");
			var date = new Date();
			str = array[0].split('-');
			date.setUTCFullYear(parseInt(str[0]), parseInt(str[1]) - 1,parseInt(str[2]));
			if (array.length > 1) {
				str = array[1].split(':');
				date.setUTCHours(parseInt(str[0]) - 8, parseInt(str[1]),parseInt(str[2]), 0);
			}
			return date.format(format);
		}
	}
} ;
function getDateForStr(str) {
	if (str instanceof Date) {
		return str;
	}
	var array = str.split("T");
	var date = new Date();
	str = array[0].split('-');
	date.setUTCFullYear(parseInt(str[0]), parseInt(str[1]) - 1,
			parseInt(str[2]));
	if (array.length > 1) {
		str = array[1].split(':');
		date.setUTCHours(parseInt(str[0]) - 8, parseInt(str[1]),
				parseInt(str[2]), 0);
	}
	return date;
}

function formatDateTime(str) {
	if (str == null || str == '') {
		return "";
	} else {
		return getDateForStr(str).format();
	}
}
// 处理时间格式带.0的
function formatDateTimeSub(str) {
	if (str == null || str == '') {
		return "";
	} else {
		return str.split('.')[0];
	}
}

function formatDate(str, format) {
	if (str == null) {
		return "";
	} else {
		if (format == undefined) {
			return getDateForStr(str).format("yyyy-MM-dd");
		} else {
			return getDateForStr(str).format(format);
		}
	}
}

function toDate(obj) {
	var date = new Date();
	date.setTime(obj.time);
	date.setHours(obj.hours);
	date.setMinutes(obj.minutes);
	date.setSeconds(obj.seconds);
	return date.format("yyyy-MM-dd hh:mm:ss");
}