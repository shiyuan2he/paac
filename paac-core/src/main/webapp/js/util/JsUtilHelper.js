//说　明：项目使用的JS公共方法
//创建人：lzchina
//值为null的不序列化
$.fn.serializeNotNull = function(){
	var o = "";
	var a = this.serializeArray();
	var form = $(this).attr("id");
	$.each(a, function() {
		if(this.value != null && this.value != undefined ){
			if( this.value == ""){
				return true;
			}
			o+=this.name+"="+encodeURIComponent(this.value)+"&";
		}
	});
	return o;
};

//阻止事件冒泡
function stopPropagation(e) {
	e = e || window.event;
    if(e.stopPropagation) { //W3C阻止冒泡方法  
        e.stopPropagation();
    } else {
        window.event.cancelBubble = true; //IE阻止冒泡方法  
    }
}  

/**
 * 说　明：添加replaceAll公用方法
 * str1 该正则表达式的字符串相匹配
 * str2 被取代的每个匹配的字符串 
 */
String.prototype.replaceAll = function(str1, str2) {
	var str = this;
	var result = str.replace(eval("/" + str1 + "/gi"), str2);
	return result;
}


//金额格式化
/**    var revenue = 12345678;
    alert(revenue.formatMoney()); // $12,345,678.00
    alert(revenue.formatMoney(0, "HK$ ")); // HK$ 12,345,678
    var price = 4999.99;
    alert(price.formatMoney(2, "€", ".", ",")); // €4.999,99
    alert((-500000).formatMoney(0, "£ ")); // £ -500,000*/
    
Number.prototype.formatMoney = function (places, symbol, thousand, decimal) {
    places = !isNaN(places = Math.abs(places)) ? places : 2;
    symbol = symbol !== undefined ? symbol : "$";
    thousand = thousand || ",";
    decimal = decimal || ".";
    var number = this,
    negative = number < 0 ? "-" : "",
    i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
    j = (j = i.length) > 3 ? j % 3 : 0;
    return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
};
/**
 * 
 * @description <p>移除数组中的元素值</p>
 * @param arrayValue	要移除元素的数组
 * @param value		要移除的元素
 * @returnType void
 * 方法名:removeByValue
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年8月9日 下午5:34:40
 * @price ￥:三毛三
 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
function removeByValue(arrayValue,value){
	for(var i=0;i<arrayValue.length;i++){
		if(arrayValue[i] == value){
			arrayValue.splice(i,1) ;
			break ;
		}
	}
}
/**
 * 
 * @description <p>数组去重</p>
 * @param arrayValue
 * @returns {Array}
 * @returnType Array
 * 方法名:uniqueArray
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年8月9日 下午5:40:53
 * @price ￥:三毛三
 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
function uniqueArray(arrayValue){
	var result = new Array() ,isRepeat;
	for(var i=0;i<arrayValue.length;i++){
		isRepeat = false ;
		for(var j=0;j<result.length;j++){
			if(arrayValue[i] == result[j]){
				isRepeat = true ;
			}
		}
		if(!isRepeat){
			result.push(arrayValue[i]) ;
		}
	}
	return result ;
}
/**
 * 说　明：删除左右两端的空格
 * 创建人：lzchina
 */
function trimValue(str){ 
	return $.trim(str);
}
/**
 * 说　明：字符串是否为空
 * 创建人：lzchina
 */
function isNullOrEmptyValue(strVal) {
	var trimvalue=trimValue(strVal);//去除空格
	if (trimvalue == '' || trimvalue == null || trimvalue == undefined || trimvalue.length==0 || trimvalue=='null') {
		return true;
	}else {
		return false;
	}
}
// functioin passArguments(){
// 	if(arguments.length == 1){
// 		console.log(arguments[0]) ;
// 	}else if(arguments.length == 2){
// 		console.log(arguments[0] + arguments[1]) ;
// 	}
// }
/**
 * 说　明：将表单数据转为json
 * 创建人：lzchina
 *   fromname:表单名称 
 */
function form2Json(fromname) {
	var arr = $("#" + fromname).serializeArray();
    var jsonStr = "";

    jsonStr += '{';
    for (var i = 0; i < arr.length; i++) {
        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
    }
    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
    jsonStr += '}'
    var json = JSON.parse(jsonStr);
    return json
}
/**
 * JavaScript实现字符串的contains函数
 * string:原始字符串
 * substr:子字符串
 * isIgnoreCase:忽略大小写
 */
function contains(string, substr, isIgnoreCase){
    if (isIgnoreCase){
        string = string.toLowerCase();
        substr = substr.toLowerCase();
    }

    var startChar = substr.substring(0, 1);
    var strLen = substr.length;

    for (var j = 0; j<string.length - strLen + 1; j++){
    	if (string.charAt(j) == startChar){  //如果匹配起始字符,开始查找
    		if (string.substring(j, j+strLen) == substr){  //如果从j开始的字符与str匹配，那ok
    			return true;
            }
        }
    }
    return false;
}
//字符长度（按字节）  
function strlen(str) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        var c = str.charCodeAt(i);
        //单字节加1 
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
            len++;
        }else {
            len += 2;
        }
    }
    return len;
}
/**
 * 根据身份证号获取年龄
 * @param obj
 */
function getAgeByNo(obj,ageInputId){
	//获取输入身份证号码 
	var UUserCard = $(obj).val(); 
	if(UUserCard==null||UUserCard.length<18){
		if($("#"+ageInputId).attr("class").indexOf("textbox") > -1)
			$("#"+ageInputId).textbox("setValue","身份证输入有误");
		else
			$("#"+ageInputId).val("身份证输入有误");
		return;
	}
	//获取年龄 
	var myDate = new Date(); 
	var month = myDate.getMonth() + 1; 
	var day = myDate.getDate();
	var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1; 
	if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) { 
	age++; 
	} 
	if($("#"+ageInputId).attr("class").indexOf("textbox") > -1)
		$("#"+ageInputId).textbox("setValue",age);
	else
		$("#"+ageInputId).val(age);
}