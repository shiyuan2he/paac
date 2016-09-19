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