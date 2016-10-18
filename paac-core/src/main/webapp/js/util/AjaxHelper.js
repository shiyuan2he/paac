/**
 * 说　明：AJAX Post请求
 * 创建人：yzchina
 *   url：Action处理路径
 *   postvalue：url参数，改参数可以是XML格式或json格式
 *   formname：表单名称
 *   gridname：执行成功之后调用的JS方法，一般情况用于添加，修改，删除之后刷新显示内容。
 *   divname:需要关闭的div名称
 */
function AjaxSubmit(url,postvalue,formname, gridname,divname) {
	AjaxSubmitSystem(url,postvalue,formname, gridname,divname,"1","","");
}

function AjaxSubmitSystem(url,postvalue,formname, gridname,divname,msgtype,sucmsg,errmsg) {
	AjaxSubmitSystemV1(url,postvalue,formname, gridname,divname,msgtype,sucmsg,errmsg,"");
}
/**
 * 说　明：AJAX Post请求,可以显示自定义弹出信息，也可以显示系统固定弹出信息
 * 创建人：yzchina
 *   url：Action处理路径
 *   postvalue：url参数，改参数可以是XML格式或json格式
 *   formname：表单名称
 *   gridname：执行成功之后调用的JS方法，一般情况用于添加，修改，删除之后刷新显示内容。
 *   divname:需要关闭的div名称
 *   msgtype:是否显示提示信息　1显示 2不显示
 *   sucmsg:正确的弹出信息
 *   errmsg:错误的弹出信息
 */
function AjaxSubmitSystemV2(url,postvalue,formname, gridname,divname,msgtype,sucmsg,errmsg,callback){
	var params = $("#"+formname).serialize(); // http request parameters.  
 	params = decodeURIComponent(params,true);   
 	var jsonStr = '{"'
		+params.replaceAll('=', '":"')
				.replaceAll('&', '","') + '"}';
 	var json = JSON.parse(jsonStr);
	if(validate(formname)){
		var pathurl = (url.indexOf("?") == -1 ? url + "?random=" + Math.round(Math.random() * 100) : url);
		if (postvalue.length > 0) {
			pathurl += "&postvalue=" + postvalue + "";
		}
		if (formname != ""){
			$('body').loadingOverlay();
		}
		$.ajax({
			type : "post",
			url : encodeURI(pathurl),
			data :json,
			success : function(data) {
				var msg="";//弹出信息
				var msgstate="";//弹出框状态
				if (data.split("_").length >= 2){
					if(msgtype=="1"){
						if(data.split("_")[1]=="err"){
							msgstate="error";
							if(errmsg.length>0){
								msg=errmsg;
								WTAlertTip(msg, msgstate,divname);
							}else{
								WTAlert(data.split("_")[0], data.split("_")[1],divname);
							}		
						}else if(data.split("_")[1]=="suc"){
							msgstate="info";
							if(sucmsg.length>0){
								msg=sucmsg;
								WTAlertTip(msg, msgstate,divname);
							}else{
								WTAlert(data.split("_")[0], data.split("_")[1],divname);
							}
						}
					}
				}
			},
			complete : function(msg) {
				if (gridname != undefined && gridname.length > 0){
					if (getId(gridname).attr('class') == "easyui-datagrid"){
						getId(gridname).datagrid('reload');
					}else if (getId(gridname).attr('class') == "easyui-treegrid") {
						getId(gridname).treegrid('reload');
					}else if (getId(gridname).attr('class') == "easyui-tree") {
						getId(gridname).tree('reload');
					}else if(getId(gridname).attr('easytype')=="treegrid"){
						getId(gridname).treegrid('reload');
					}else if(getId(gridname).attr('easytype')=="datagrid" || getId(gridname).attr('easytype')=="easyui-datagrid"){
						getId(gridname).datagrid('reload');
					}
				}
				if(callback != undefined && callback.length > 0){
					eval(callback);
				}
				$('body').loadingOverlay('remove');
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				WTAlertTip('发生错误，请联系客服！', 'error','');
			}
		});
	}else{
		WTAlertTip('请正确填写内容!', 'error','');
	}
}
/**
 * 说　明：AJAX Post请求,可以显示自定义弹出信息，也可以显示系统固定弹出信息
 * 创建人：yzchina
 *   url：Action处理路径
 *   postvalue：url参数，改参数可以是XML格式或json格式
 *   formname：表单名称
 *   gridname：执行成功之后调用的JS方法，一般情况用于添加，修改，删除之后刷新显示内容。
 *   divname:需要关闭的div名称
 *   msgtype:是否显示提示信息　1显示 2不显示
 *   sucmsg:正确的弹出信息
 *   errmsg:错误的弹出信息
 */
function AjaxSubmitSystemV1(url,postvalue,formname, gridname,divname,msgtype,sucmsg,errmsg,callback,callbackParam,loading){	
	var flag = "";
	if(validate(formname)){
		var pathurl = (url.indexOf("?") == -1 ? url + "?random=" + Math.round(Math.random() * 100) : url);
		if (postvalue.length > 0) {
			pathurl += "&postvalue=" + postvalue + "";
		}
		//添加遮罩
		if(loading != false)
			$('body').loadingOverlay();
		
		$.ajax({
			type : "post",
			url : encodeURI(pathurl),
			data :getId(formname).serialize(),
			success : function(data) {
				var msg="";//弹出信息
				var msgstate="";//弹出框状态
				if (data.split("_").length >= 2){
					flag = data.split("_")[1];
					if(msgtype=="1"){
						if(flag=="err"){
							msgstate="error";
							if(errmsg.length>0){
								msg=errmsg;
								WTAlertTip(msg, msgstate,divname);
							}else{
								WTAlert(data.split("_")[0], data.split("_")[1],divname);
							}		
						}else if(flag=="suc"){
							msgstate="info";
							if(sucmsg.length>0){
								msg=sucmsg;
								WTAlertTip(msg, msgstate,divname);
							}else{
								WTAlert(data.split("_")[0], data.split("_")[1],divname);
							}
						}
					}
				}
			},
			complete : function(msg) {
				if (gridname != undefined && gridname.length > 0){
					if (getId(gridname).attr('class') == "easyui-datagrid"){
						getId(gridname).datagrid('reload');
					}else if (getId(gridname).attr('class') == "easyui-treegrid") {
						getId(gridname).treegrid('reload');
					}else if (getId(gridname).attr('class') == "easyui-tree") {
						getId(gridname).tree('reload');
					}else if(getId(gridname).attr('easytype')=="treegrid"){
						getId(gridname).treegrid('reload');
					}else if(getId(gridname).attr('easytype')=="datagrid" || getId(gridname).attr('easytype')=="easyui-datagrid"){
						getId(gridname).datagrid('reload');
					}
				}
				if(callback != undefined && callback.length > 0){
					var callbackIndex = callback.indexOf("(");
					if(callbackIndex != -1)
						callback = callback.substring(0,callbackIndex);
					eval("("+callback+"('"+flag+"'"+(callbackParam!=undefined?","+callbackParam:"")+"))");
				}
				//移除遮罩
				if(loading != false)
					$('body').loadingOverlay('remove');
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				WTAlertTip('发生错误，请联系客服！', 'error','');
			}
		});
	}else{
		WTAlertTip('请正确填写内容!', 'error','');
	}
}
/**
 * 负责不需要表单验证的请求处理
 * @param url
 */
function AjaxSubmitUrl(url,win,gridname){
	AjaxSubmitForm(url,"",win,gridname,"1","");
}

/**
 * 说　明：AJAX Post请求,可以显示自定义弹出信息，也可以显示系统固定弹出信息
 * 创建人：yzchina
 *   url：Action处理路径
 *   formname：表单名称
 *   win:需要关闭的div名称
 *   grid：执行成功之后调用的JS方法，一般情况用于添加，修改，删除之后刷新显示内容 
 *   isalert:是否显示提示信息　1显示 0不显示       
 *   postvalue：url参数，改参数可以是XML格式或json格式
 *   callback:回调函数（字符串）
 */
function AjaxSubmitForm(url, formname, win, grid, isalert,callback,hasparam,postvalue) {
	if(validate(formname)){
		if(url.indexOf("?") == -1){
			url = url + "?random=" + Math.round(Math.random() * 100);
		}else{
			url = url + "&random=" + Math.round(Math.random() * 100);
		}
		if (postvalue!=null&&postvalue.length > 0) {
			url += "&postvalue=" + postvalue + "";
		}
		var flag=-1;//0成功，1失败
		var alldata="";
		$.ajax({
			type : "post",
			url : url,
			data : getId(formname).serialize(),
			success : function(data) {
				flag=0;
				alldata=data+'';
				if (isalert == "1" && data.split("_").length >= 2) {
					WTAlert(data.split("_")[0], data.split("_")[1], "");
				}
				
				if (win.length > 0) {
					getId(win).window('destroy');
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				flag=1;
				alldata=errorThrown+'';	
				WTAlertTip('发生错误，请联系客服！', 'error','');
			},
			complete : function(msg) {	
				if (grid.length > 0) {
					if (getId(grid).attr('class') == "easyui-datagrid") {
						getId(grid).datagrid('reload');
					} else if (getId(grid).attr('class') == "easyui-treegrid") {
						getId(grid).treegrid('reload');
					}else if(getId(grid).attr('easytype')=="treegrid"){
						getId(grid).treegrid('reload');
					}else if(getId(grid).attr('easytype')=="datagrid"){
						getId(grid).datagrid('reload');
					}else if(getId(grid).attr('easytype')=="easyui-datagrid"){
						getId(grid).datagrid('reload');
					}
				}
				
				if (callback!=null&&callback.length > 0) {				
					if (hasparam!=null&&hasparam=="1"){					
						if (flag==0){
							try{
							    eval("("+callback+"("+flag+","+alldata+"))");	
							} catch(err) {
								flag=1;
								eval("("+callback+"("+flag+",'"+err+"'))");
							}
						}else{
							  alert("错误信息！");
						}												
					}else{
						eval(callback);
					}					
				}		
			}
		});
	}else{
		WTAlertTip('请您填写规范内容!', 'error','');
	}
}

/**
 * 说　明：提交数据，然后在DIV显示返回信息。目前该函数设计用于健康工具
 * 创建人：lzchina
 * 日　期：2015年04月30日
 *   url:action请求
 *   formname：表单名称
 *   divname:显示返回请求数据的容器名称
 *   callback:回调函数名称
 *   sucmsg:成功提示
 *   errmsg:错误提示
 */
function AjaxSubmitDiv(url, formname, divname, callback){
    AjaxSubmitDivV1(url, formname, divname, callback, "", "");
}

function AjaxSubmitDivV1(url, formname, divname, callback, sucmsg, errmsg) {
    if (formname!=""){
        $('body').loadingOverlay();
    }
    $.ajax({
        type : "post",
        url : url,
        data : getId(formname).serialize(),
        success : function(data) {
        	if(data == -1){
        		getId(divname).attr("onClick","");
        	}else{
        		if (divname.length > 0 && (getId(divname).attr("class")==undefined || getId(divname).attr("class").indexOf("easyui-window") == -1)) {
        			getId(divname).html(eval("("+data+")"));
        		}
        		if(sucmsg.length>0 && data.split("_")[1]=="suc"){
        			WTAlertTip(sucmsg, "info",divname);
        		}
        		if(errmsg.length>0 && data.split("_")[1]=="err"){
        			WTAlertTip(errmsg, "error","");
        		}
        	}
        },
        complete : function(msg) {
            if(callback != undefined){
                if (callback.length > 0) {
                    eval(callback);
                }
            }
            $('body').loadingOverlay('remove');
        }
    });
}

function AjaxSubmitDivAppend(url, formname, divname, callback) {
    $.ajax({
        type : "post",
        url : url,
        data : getId(formname).serialize(),
        dataType : "json",
        success : function(data) {
            if (divname.length > 0) {
                getId(divname).append(data); 
            }
        },
        complete : function(msg) {
            if(callback!='undefined'){
                if (callback.length > 0) {
                    eval(callback);
                }
            }
        }
    });
}
/**
 * 获取后台数据
 * @param url
 * @param param
 */
function AjaxSubmitGetData(url,param,callback,callbackParam,loading) {
	var callbackParam = callbackParam == undefined || callbackParam == "" ? "''" : callbackParam;
	var loading = loading == undefined ? false : loading;
	//开启遮罩
	if(loading){
		if(typeof loading == "boolean"){
			$('body').loadingOverlay();
		}else{
			$('#'+loading).loadingOverlay();
		}
	}
    $.ajax({
        type : "post",
        url : url,
        data : param,
        dataType : "json",
        success : function(data) {
        	eval(callback+"(data,"+callbackParam+")");
        },complete : function(msg) {
			//移除遮罩
			if(loading){
				if(typeof loading == "boolean"){
					$('body').loadingOverlay('remove');
				}else{
					$('#'+loading).loadingOverlay('remove');
				}
			}
		}
    });
}
/**
 * 说　明：公共提示方法
 * 创建人：cwc
 * message 提示消息
 * statetype　提示框类型 info 成功样式 error 失败样式
 * divname:需要关闭的div名称
 */
function WTAlertTip(message, statetype,divname) {
	if (statetype=="error"){
		$.messager.alert("系统提示", message, statetype,function(){
			if(divname.length>0 && statetype.indexOf("error") == -1)
				$("#" + divname + "").dialog('destroy');
			});
	}else{
		messagerShow( message);{
			if(divname.length>0 && statetype.indexOf("error") == -1){
				$("#" + divname + "").dialog('destroy');				
			}
		}
	}
}
/**end 提示消息结束**/
/**
* @param urlAction action的地址
* @param fname 回调的方法名字符串,如有回调回调应该有两个参数flag（0成功，1失败），result结果数据
*/
function getAjaxData(formname, urlAction, fname) {
    var flag = 0;//提交状态
    var result;
    $.ajax({
        url : urlAction,
        async : false,
        data : getId(formname).serialize(),
        type : "post",
        dataType : "json",
        success : function(data) {

            result = data;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {

            flag = 1;
            result = errorThrown + '';
        },
        complete : function(msg) {
            if (flag == 0) {
                try {
                    if (fname) {
                        eval(fname + "(flag,result)");
                    } else {
                        return result;
                    }
                } catch (err) {
                    WTAlertTip('发生错误，请联系客服！', 'error', '');
                }
            } else {
                WTAlertTip('发生错误，请联系客服！', 'error', '');
            }
        }
    });
}
/**end 提示消息结束**/
/**
*by yatoo 2015-8-14
* @param param 参数
* @param urlAction action的地址
* @param fname 回调的方法名字符串,如有回调回调应该有两个参数flag（0成功，1失败），result结果数据
*/
function submitAjaxData(param, urlAction, fname) {
    var flag = 0;//提交状态
    var result;
    $.ajax({
        url : urlAction,
        async : false,
        data :param,
        type : "post",
        dataType : "json",
        success : function(data) {
            result = data;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            flag = 1;
            result = errorThrown + '';
        },
        complete : function(msg) {
            if (flag == 0) {
                try {
                    if (fname) {
                        eval(fname + "(flag,result)");
                    } else {
                        return result;
                    }
                } catch (err) {
                    WTAlertTip('发生错误，请联系客服！', 'error', '');
                }
            } else {
                WTAlertTip('发生错误，请联系客服！', 'error', '');
            }
        }
    });
}

function AjaxSubmitFormIntervene(url, formname, win, grid, isalert,callback, hasparam, postvalue) {
    if (validate(formname)) {
        if (url.indexOf("?") == -1){
        	url = url + "?random=" + Math.round(Math.random() * 100);
        }else{
        	url = url + "&random=" + Math.round(Math.random() * 100);        	
        }

        if (postvalue != null && postvalue.length > 0) {
            url += "&postvalue=" + postvalue + "";
        }
        var flag = -1;//0成功，1失败
        var alldata = "";
        $.ajax({
            type : "post",
            url : url,
            data : getId(formname).serialize(),
            success : function(data) {
                flag = 0;
                alldata = data + '';
                if (isalert == "1" && data.split("_").length >= 2) {
                    if (callback != null && callback.length > 0) {
                        if (hasparam != null && hasparam == "1") {
                            if (flag == 0) {
                                try {
                                    eval("(" + callback + "(" + flag + "," + alldata  + "))");
                                } catch (err) {
                                    flag = 1;
                                    eval("(" + callback + "(" + flag + ",'" + err + "'))");
                                }
                            } else {
                                alert("错误信息！");
                            }
                        } else {
                            eval(callback);
                        }
                    }
                    WTAlert(data.split("_")[0], data.split("_")[1], win);
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                flag = 1;
                alldata = errorThrown + '';
                WTAlertTip('发生错误，请联系客服！', 'error', '');
            },
            complete : function(msg) {
                if (grid.length > 0) {
                    if (getId(grid).attr('class') == "easyui-datagrid") {
                        getId(grid).datagrid('reload');
                    } else if (getId(grid).attr('class') == "easyui-treegrid") {
                        getId(grid).treegrid('reload');
                    } else if (getId(gridname).attr('easytype') == "treegrid") {
                        getId(gridname).treegrid('reload');
                    } else if (getId(gridname).attr('easytype') == "datagrid") {
                        getId(gridname).datagrid('reload');
                    }
                }
            }
        });
    } else{
    	WTAlertTip('请您填写规范内容!', 'error', '');
    }
}