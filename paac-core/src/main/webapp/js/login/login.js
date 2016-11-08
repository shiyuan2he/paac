/**
 * @description <p>登陆js</p>
 */
var loginJS = {
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