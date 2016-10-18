/*使用easy ui表单验证，前提是控件必须指定required=true*/
/**
 * @description <p>请在这里输入方法的作用</p>
 * @param fromname
 * @returns {Boolean}
 * @returnType Boolean
 * 方法名:validate
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年10月18日 上午11:31:24
 * @price ￥:三毛三
 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
function validate(fromname){
	var flag = false;
	if($("#" + fromname + "").form('validate') || fromname.length == 0){
		flag=true;
	}
	return flag;
}