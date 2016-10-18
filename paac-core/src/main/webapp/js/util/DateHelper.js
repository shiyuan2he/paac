/**
 * 说 明：调查问卷JS公共方法 创建人：yzchina 日 期：2015年02月15日
 */
$.extend($.fn.validatebox.defaults.rules, {
	empty : {
		validator : function(value) {
			value = value.replace(/(^\s+)|(\s+$)/g, "");
			return value.length > 0;
		},
		message : "请填写内容"
	},
	userName : {
		validator : function(value) {
			return userNameValidate(value);
		},
		message : "登录账号由3-20个字符组成，中文2-10个汉字"
	},
	mobile : {
		validator : function(value) {
			return /^1[3|4|5|6|7|8|9][0-9]{9}$/.test(value);
		},
		message : "请正确输入移动电话"
	},
	userPwd : {
		validator : function(value) {
			var re = new RegExp(/(^.{6,50}$)/);
			return !(!re.test(value) || validateLength(value,6,50));
		},
		message : "密码由6-50位任意字符组成"
	},
	tel : {
		validator : function(value) {
			return /^(\d{3,4}-?)?\d{7,8}(-\d{1,4})?$/.test(value);
		},
		message : "请正确输入联系电话"
	},
	content : {
		validator : function(value) {
			return !/^(\+?\d{2,3}-?)?\d{7,8}(-\d*)?$/.test(value);
		},
		message : "请不要输入特殊字符"
	},
	realInt : {
		validator : function(value) {
			if (!isNaN(value) && value > 0) {
				return true;
			} else {
				return false;
			}
		},
		message : "请输入大于0的数字"
	},
	equals : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两次输入密码不一致'
	},
	//后台远程，必须设定delay属性，防止定时器过快调用后台，不建议使用
	checkSignCode : {
		validator : function(value, url) {
			var checkR = $.ajax({
				async : true,
				cache : false,
				type : 'post',
				url : url,
				data : {
					'unique' : value

				}
			}).responseText;
			return checkR === "true";
		},
		message : '登陆名已存在'
	},
	//身份证验证
	idcard : {
		validator : function(value, param) {
			var cerType = $(param[0]).combobox('getValue');
			if (cerType == 1) {//如果是身份证
				return isIdCardNo(value)
			} else if (cerType == 2) {
				var flag = (!isNaN(value)) && value.length == 8;
				return flag == true ? true : false;
			}
		},
		message : '身份证/军官证号码不合法'
	},
	legalIdentity:{// 验证身份证
		validator : function(value) {
			return isIdCardNo(value);
		},
		message : '身份证号输入不合法'
	},
	//汉字验证
	chinese : {// 验证中文
		validator : function(value) {
			 return /^[\u0391-\uFFE5]+$/.test(value);  
		},
		message : '请输入中文'
	},
	chinese_ : {// 验证中文含其他类型
		validator : function(value) {
			return /[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi.test(value);
		},
		message : '输入中文'
	},
	eaChinese_ : {// 验证中文含其他类型
		validator : function(value) {
			return /[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi.test(value);
		},
		message : '必须包含中文字符'
	},
	// 验证用户名
	username : {
		validator : function(value) {
			return /^[a-zA-Z][a-zA-Z0-9]{5,15}$/i.test(value);
		},
		message : '用户名不合法（字母开头，允许6-16字节，允许字母数字）'
	},
	english : {// 验证英语
		validator : function(value) {
			return /^[A-Za-z]+$/i.test(value);
		},
		message : '请输入英文'
	},
	ip : {// 验证IP地址
		validator : function(value) {
			return /\d+\.\d+\.\d+\.\d+/.test(value);
		},
		message : 'IP地址格式不正确'
	},
	ZIP : {
		validator : function(value, param) {
			return /^[0-9]\d{5}$/.test(value);
		},
		message : '邮政编码不存在'
	},
	QQ : {
		validator : function(value, param) {
			return /^[1-9]\d{4,11}$/.test(value);
		},
		message : 'QQ号码不正确'
	},
	 length: { validator: function (value, param) {
         var len = strLens(value);
         return len >= param[0] && len <= param[1];
     },
         message: "输入内容字符长度必须介于{0}和{1}之间."
     },
     sellLength: { validator: function (value, param) {
         var len = value.length;
         return len >= param[0] && len <= param[1];
     },
         message: "输入内容字符长度必须介于{0}和{1}之间."
     },
	range : {
		validator : function(value, param) {
			if (/^[0-9]\d*$/.test(value)) {				
				return  value >= param[0] && value <= param[1];
			} else {
				return false;
			}
		},
		message : '输入的数字在{0}到{1}之间'
	},
	minLength : {
		validator : function(value, param) {
			return strLens(value) >= param[0]
		},
		message : '至少输入{0}个字符'
	},
	maxLength : {
		validator : function(value, param) {
			return strLens(value) <= param[0]
		},
		message : '最多{0}个字符'
	},
	//select即选择框的验证
	selectValid : {
		validator : function(value, param) {
			if (value == param[0]) {
				return false;
			} else {
				return true;
			}
		},
		message : '请选择'
	},
	// 只能输入英文和数字
	englishOrNum : {
		validator : function(value) {
			return /^[a-zA-Z0-9_ ]{1,}$/.test(value);
		},
		message : '请输入英文、数字、下划线或者空格'
	},
	//小数
	xiaoshu : {
		validator : function(value) {
			return  /^\d{0,3}.\d{0,2}$/g.test(value);
		},
		message : '最多保留两位小数！'
	},
	// 增加了一个真实金额的校验规则    修改人：张爽    修改时间：2016/04/29    版本：无
	//小数最多保留两位
	realPrice: {
		validator : function(value) {
			//return  /^\d{0,3}.\d{0,2}$/g.test(value);
			return /^(0|[1-9][0-9]{0,6})(\.[0-9]{1,2})?$/g.test(value);
		},
		message : '输入的金额最多7位整数，两位小数！'
	},
	ddPrice : {
		validator : function(value, param) {
			if (/^[1-9]\d*$/.test(value)) {
				return value >= param[0] && value <= param[1];
			} else {
				return false;
			}
		},
		message : '请输入1到100之间正整数'
	},
	
	jretailUpperLimit : {
		validator : function(value, param) {
			if (/^[0-9]+([.]{1}[0-9]{1,2})?$/.test(value)) {
				return parseFloat(value) > parseFloat(param[0])
						&& parseFloat(value) <= parseFloat(param[1]);
			} else {
				return false;
			}
		},
		message : '请输入0到100之间的最多俩位小数的数字'
	},
	//百分数
	rateCheck : {
		validator : function(value, param) {
			if (/^[0-9]+([.]{1}[0-9]{1,2})?$/.test(value)) {
				return parseFloat(value) > parseFloat(param[0])
						&& parseFloat(value) <= parseFloat(param[1]);
			} else {
				return false;
			}
		},
		message : '请输入0到1000之间的最多俩位小数的数字'
	},
	//是否存在
	//例子：	data-options="validType:['email','existsValue[\'电子邮箱\',\'email\',\'WtBaseUserinfo\',\'${wtDoctorRfqVerify.wtDoctorRfq.userId}\']']"
	existsValue : {
		validator : function(value, param) {
			var state = true;
			$.ajaxSettings.async = false;
			var params = param[1] + "=" + value + "&type=" + param[2] + "&dataId=" + (param[3]==undefined?"":param[3])+"&eaId="+(param[4]==undefined?"":param[4]);
			var url=encodeURI(__rootPath__+"/registerFindExist.action?"+params+"&random=" + Math.round(Math.random() * 100));
			$.getJSON(url, function(data) {
				if (data.state == "true") {
					state = false;
				}
			});
			$.ajaxSettings.async = true;
			return state;
		},
		message : ' {0}已存在，请重新输入'
	},
	//是否存在通用
	//例子：	data-options="validType:['email','publicExistsValue[\'项目编号\',\'WtServiceDict\',\'serviceCode\',\'serviceId\',\'${wtServiceDict.serviceId}\',\'isDel=0 and eaId=`${sessionScope.userinfo.eaId }`\']']"
	publicExistsValue : {
		validator : function(value, param) {
			if(param[6] != undefined)
				value = $("[name='"+param[6]+"']").val();
			if(param[1] == "WtServiceDict")
				value = "F"+value;
			if(value.length != 0)
				value =$.trim(value);
			//多个value拼接获取值
			var paramValues = param[2].split(",");
			if(paramValues.length > 1){
				param[2] = paramValues[0];
				for(var i = 1; i < paramValues.length; i++){
					value = $("#"+paramValues[i]).val() + "" + value;
				}
			}
			//如果主键值为ID，那么取value值
			if(param[4].indexOf("Id") != -1){
				param[4] = $("#"+param[4]).val();
			}
			var state = true;
			$.ajaxSettings.async = false;
			var params = "table="+param[1] + "&field=" + param[2] + "&value="+ value + "&idField=" + param[3]+ "&idValue=" + param[4]+"&other=" + param[5];
			var url=encodeURI(__rootPath__+"/manageFrame/userInfo/userPublicFindExist.action?"+params+"&random=" + Math.round(Math.random() * 100));
			$.getJSON(url, function(data) {
				if (data.state == "true") {
					state = false;
				}
			});
			$.ajaxSettings.async = true;
			return state;
		},
		message : ' {0}已存在，请重新输入'
	},
	number : {
		validator : function(value, param) {
			if (/^\-?[0-9]\d*$/.test(value)) {	
				return  true;
			} else {
				return false;
			}
		},
		message : '输入的整数数字'
	},
	productTextLength:{ //校验新增修改商品广告的文字输入项的长度
		validator : function(value,param) {
			  var lenth=param[0]- getByteLen(value);
             // lenth=lenth>0?lenth:0;
              if(param[1]==0){
            	  //商品名称            
            	   $('#prodNameSurplusChar').html(lenth>0?lenth:0);	
              }
              if(param[1]==1){
            	  //广告
            	  $('#prodAdSurplusChar').html(lenth>0?lenth:0);
              }   
              if(param[1]==2){
            	  //服务地址
            	  $('#serviceAddressSurplusChar').html(lenth>0?lenth:0);
              } 
              if(lenth<0) return false; else return true;       
		},
		message : '输入文字超长'
	},
	productName:{
		validator : function(value) {
			return /^(\w|\.|\+|\-|[\u4E00-\u9FA5]|-|[（]|[）]|[(]|[)]|（|）|\s){1,100}$/.test(value);
		},
		message : '商品名称只能输入数字，字母，中文，减号，小括号，空格，中划线，小数点，加号'
	}
});

//字符长度（按字节）  
function strLens(str) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        var c = str.charCodeAt(i);
        //单字节加1，回车为2字符数(10位回车)
        if (((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) && c != 10) {
            len++;
        }else {
            len += 2;
        }
    }
    return len;
}

//登录名验证
function userNameValidate(val) {
	var re = new RegExp(/(^[A-Za-z0-9_]{3,20}$)|(^[\u4E00-\u9FA5]{2,10}$)/);
	return re.test(val);
	//return validateAddress(val) || validateLength(val,3,20);
}
//是否包含特殊字符
function validateAddress(val) {
	var address = val;
	var containSpecial = new RegExp(
			/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
	if (containSpecial.test(address)) {
		return true;
	}
	return false;
}
//是否超过指定长度中文2字符
function validateLength(val,minLength,maxLength){
		return val.replace(/[^\x00-\xff]/g, 'xx').length < minLength || val.replace(/[^\x00-\xff]/g, 'xx').length > maxLength;
}
//--身份证号码验证-支持新的带x身份证
function isIdCardNo(num) {
	//身份证正则表达式(15位) 
	var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
	//身份证正则表达式(18位) 
	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
	return isIDCard1.test(num) || isIDCard2.test(num);
}
function ValidRadio(radioname) {
	var radiovalue = $('input[type="radio"][name="' + radioname + '"]:checked')
			.val();
	if (radiovalue == undefined)
		return false;
	else
		return true;
}
function GetRadioValue(radioname) {
	var radiovalue = $('input[type="radio"][name=' + radioname + ']:checked')
			.val();
	return radiovalue;
}

function ValidVisble(name, type) {
	if (type == 1) {
		//$("#img" + name).attr({'src' : '../images/ico_err.gif'});
		$("#img" + name).attr('class' , 'ztIco-Err');
	} else if (type == 2) {
		//$("#img" + name).attr({'src' : '../images/ico_ok.gif'});
		$("#img" + name).attr('class' , 'ztIco-Ok');
	} else if (type == 3) {
		//$("#img" + name).attr({'src' : '../images/ico_info.gif'});
		$("#img" + name).attr('class' , 'ztIco');
	} else if (type == 4) {
		//$("#img" + name).attr({'src' : '../images/ico_gray.gif'});
		$("#img" + name).attr('class' , 'ztIco-Gray');
	}
}
/**
 * 设置问卷验证范围
 * @param typeVal 单位类型
 * @param tipName 控件名称
 * @param typeMin1 类型1 小值
 * @param typeMax1 类型1 大值
 * @param typeMin2 类型2 小值
 * @param typeMax2 类型2 大值
 */
function setRangeCheck(typeVal, tipName, typeMin1, typeMax1, typeMin2,
		typeMax2, prec) {
	var tip = "";
	var vMin = 0, vMax = 0;
	if (typeVal == 1) {
		tip = "取值范围[" + typeMin1 + "," + typeMax1 + "]";
		vMin = typeMin1;
		vMax = typeMax1;
	} else {
		tip = "取值范围[" + typeMin2 + "," + typeMax2 + "]";
		vMin = typeMin2;
		vMax = typeMax2;
		prec = 0;
	}
	//设置范围
	getId(tipName).numberbox({
		min : vMin,
		max : vMax,
		precision : prec
	});
	//设置提示
	getId("td" + tipName).tooltip({
		position : 'right',
		content : tip
	});
}
