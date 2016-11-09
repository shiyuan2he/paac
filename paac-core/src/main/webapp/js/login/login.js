/**
 * @description <p>登陆js</p>
 */
var loginJS = {
		/**
		 * @description <p>登陆请求</p>
		 * @returnType void
		 * 方法名:login
		 * @author heshiyuan
		 * @email sy.he@jiankangyun.com.cn
		 * @date 2016年11月9日 上午9:50:15
		 * @price ￥:三毛三
		 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
		 * @callnumber 15003828090
		 */
		login : function(){
			$.ajax({
				url : path+"/mainFrame/login/do_login.action",
				type : 'post',
				dataType : "json",
				data : {
					"user.username" : $("#username").val(),
					"user.password" : $("#password").val(),
				},
				success : function(data) {
					if(!isNullOrEmptyValue(data.tip)){
						window.location.href = data.tip;
					}else{
						window.location.reload();
					}
				}
			});
		}
} ;