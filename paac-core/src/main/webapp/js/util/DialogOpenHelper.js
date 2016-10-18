/**
 * 说 明：弹出大窗体 创建人：lzchina 日 期：2015年02月06日 参 数： win：需要转换成窗口的DIV的ID名称
 * hrefurl：需要加载的页面路径 titlevalue：窗体标题名称
 */
function winOpenMax(win, hrefurl, titlevalue) {
	WinOpen(win, hrefurl, titlevalue, 752, 462);
}
/**
 * 说　明：弹出小窗体
 * 创建人：lzchina
 *   win:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 */
function winOpenSmall(win, hrefurl, titlevalue) {
	WinOpen(win, hrefurl, titlevalue, 342, 210);
}
/**
 * 说　明：弹出中等窗体
 * 创建人：lzchina
 *   win:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 */
function winOpenMedium(win, hrefurl, titlevalue) {
	WinOpen(win, hrefurl, titlevalue, 508, 312);
}
/**
 * 说　明：弹出自定议大小窗体
 * 创建人：lzchina
 * 日　期：2015年02月06日
 * 参  数：
 *   win:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   widthvalue：窗体宽度
 *   heightvalue：窗体高度
 */
function WinOpen(win, hrefurl, titlevalue, widthvalue, heightvalue) {
    $("#"+win+"").addClass("easyui-window");
	$("#" + win + "").window({
		width : widthvalue,
		height : heightvalue,
		modal : true,
		href : hrefurl,
		loadingMessage:'正在努力为您加载数据,请稍候......',
		title : titlevalue,
		onBeforeClose:function(){
			$.messager.confirm('确认','您确认关闭窗体吗？',function(data){   
			    if (data){    
			    	$("#" + win + "").window('close',true);
			    }
			}); 
			return false;
		}
	});
}
/**
 * 信息管理用
 * @param dialogid
 * @param hrefurl
 * @param titlevalue
 * @param buttonsname
 * @returns
 */
function InfoDialogOpenMax(dialogid,hrefurl, titlevalue,buttonsname){
	InfoDialogOpenfixed(dialogid,hrefurl,titlevalue,950, 570,buttonsname);
}
function InfoDialogOpenfixed(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname) {
	InfoDialogOpen(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname,false);
}
function InfoDialogOpen(){
	var dialogid,hrefurl, titlevalue, widthvalue=0,heightvalue=0,buttonsname,maximizablestate=false,iconClsName,closemsgtype=true,maximizedstate=false,onLoadCallback,maxLoadCallback;
	if (arguments.length == 1){
		dialogid=arguments[0];
	}else if (arguments.length == 2){
		dialogid=arguments[0];
		hrefurl=arguments[1];
	}else if (arguments.length == 3){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
	}else if (arguments.length == 4){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
	}else if (arguments.length == 5){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
	}else if (arguments.length == 6){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
	}else if (arguments.length == 7){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
	}else if (arguments.length == 8){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
	}else if (arguments.length == 9){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
	}else if (arguments.length == 10){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
		maximizedstate=arguments[9];
	}else if (arguments.length == 11){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
		maximizedstate=arguments[9];
		onLoadCallback=arguments[10];
	}else if (arguments.length == 12){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
		maximizedstate=arguments[9];
		onLoadCallback=arguments[10];
		maxLoadCallback=arguments[11];
	}
	if(widthvalue==0 ||heightvalue==0){
		widthvalue=950;
		heightvalue=570;
    }
	InfoDialogOpenSystem(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname,maximizablestate,iconClsName,closemsgtype,maximizedstate,onLoadCallback,maxLoadCallback);
}
function InfoDialogOpenSystem(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname,
		maximizablestate,iconClsName,closemsgtype,maximizedstate,onLoadCallback,maxLoadCallback){ 
		if(buttonsname.length==0){
		buttonsname="#dlg-buttons";
		}
		if($("#" + dialogid + "").length > 0){
		if($("#" + dialogid + "").is(':hidden')){
		$("#" + dialogid + "").dialog('open');
		}else{
		$("#" + dialogid + "").dialog('close',true);
		}
		}else{ 		
		dialogObj = $("<div id='"+dialogid+"'  class='easyui-dialog' />");
		dialogObj.dialog({
		hide:true, 
		width : widthvalue,
		height : heightvalue,
		loadingMessage:'正在努力为您加载数据,请稍候......',
		collapsible : false,
		maximizable:maximizablestate,
		maximized:maximizedstate,
		modal : true,
		href : hrefurl,
		iconCls:iconClsName,
		title : titlevalue,
		shadow:false,
		cache : false,
		buttons :buttonsname,
		onBeforeClose:function(){
		if(closemsgtype){
		DialogClose(dialogid);
		if(dialogid=="knowledgeInfo_dialog"){//信息管理用为了关闭右上角时刷新列表
		$("#knowledge_dataGrid").datagrid('reload');
		}
		}else{
		dialogObj.dialog('destroy');
		}
		return false;
		},
		onMaximize:function(){
		if (maxLoadCallback != undefined && maxLoadCallback.length > 0) {
		eval(maxLoadCallback);
		}
		if(UEObj!=undefined){
		var divheight=0;
		if(UEDiv.height()>800){
		divheight=UEDiv.height()-150;						
		}else{
		divheight=UEDiv.height()-180;
		}
		UEObj.setHeight(divheight);
		}
		if(UEObjKnow!=undefined){
		var divheight=0;
		if(UEDivKnow.height()>800){
		divheight=UEDivKnow.height();
		}else{
		divheight=UEDivKnow.height();
		}
		UEObjKnow.setHeight(divheight);
		}
		},
		onRestore:function(){
		if (maxLoadCallback != undefined && maxLoadCallback.length > 0) {
		eval(maxLoadCallback);
		}
		if(UEObj!=undefined){
		var divheight=UEDiv.height()-203;
		UEObj.setHeight(divheight);	
		}
		
		if(UEObjKnow!=undefined){
		var divheight=UEDivKnow.height()-206;
		UEObjKnow.setHeight(divheight);	
		}
		}, 
		onBeforeOpen : function( ) {
		//alert(  );
		},
		onLoad : function() {
		if (onLoadCallback != undefined && onLoadCallback.length > 0) {
		eval(onLoadCallback);
		}
		}
		});
		}	
}
/**
 * 说　明：弹出大dialog，不包含可最大化按钮
 * 创建人：lzchinaIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样
 */
function DialogOpenMax(dialogid,hrefurl, titlevalue,buttonsname){
	if(dialogid.indexOf("riskResult_questionnaire") != -1){
		DialogOpenfixed(dialogid,hrefurl,titlevalue,900, 570,buttonsname);
	}else{
		DialogOpenfixed(dialogid,hrefurl,titlevalue,950, 570,buttonsname);
	}
}
/**
 * 说　明：弹出小dialog，不包含可最大化按钮
 * 创建人：lzchina
 * 日　期：2015年02月06日
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样.或者不想窗体自动加载有底部工具栏传"no"即可
 */
function DialogOpenSmall(dialogid,hrefurl, titlevalue,buttonsname) {
	DialogOpenfixed(dialogid,hrefurl,titlevalue, 500, 300,buttonsname);
}
/**
 * 说　明：弹出迷你小dialog，不包含可最大化按钮
 * 创建人：lzchina
 * 日　期：2015年02月06日
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样.或者不想窗体自动加载有底部工具栏传"no"即可
 */
function DialogOpenMiniSmall(dialogid,hrefurl, titlevalue,buttonsname){
    DialogOpenfixed(dialogid,hrefurl,titlevalue, 350, 210,buttonsname);
}

/**
 * 说　明：弹出中等dialog
 * 创建人：lzchina
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样.或者不想窗体自动加载有底部工具栏传"no"即可
 */
function DialogOpenMedium(dialogid,hrefurl, titlevalue,buttonsname) {
	DialogOpenfixed(dialogid,hrefurl,titlevalue, 750, 450,buttonsname);
}
/**
 * 说　明：弹出自定议大小dialog,不包含可最大化按钮
 * 创建人：lzchina
 * 日　期：2015年02月08日
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   widthvalue：窗体宽度
 *   heightvalue：窗体高度
 *　buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样.或者不想窗体自动加载有底部工具栏传"no"即可
 */
function DialogOpenfixed(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname) {
	DialogOpen(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname,false);
}
/**
 * 说　明：弹出自定议大小dialog,该方法可以根据需求传入不同的参数，不需要的参数可以不传，不会造成方法错误。注：最好确定前5个参数有值
 * 创建人：lzchina
 * 日　期：2015年02月08日
 * 参  数：
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   widthvalue：窗体宽度
 *   heightvalue：窗体高度
 *   buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样
 *   maximizablestate:定义是否允许窗体最大化　true或false
 *   iconClsName:设置一个16x16图标的CSS类ID显示在面板左上角。默认为null
 *   closemsgtype:true弹出关闭对话框 fase　不弹出对话框
 *   maximizedstate:定义是否在初始化的时候最大化面板。true或false
 *   onLoadCallback:在加载远程数据时触发加载的函数
 *   maxLoadCallback:窗体最大化时执行的函数
 */
function DialogOpen(){
	var dialogid,hrefurl, titlevalue, widthvalue=0,heightvalue=0,buttonsname,maximizablestate=false,iconClsName,closemsgtype=true,maximizedstate=false,onLoadCallback,maxLoadCallback;
	if (arguments.length == 1){
		dialogid=arguments[0];
	}else if (arguments.length == 2){
		dialogid=arguments[0];
		hrefurl=arguments[1];
	}else if (arguments.length == 3){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
	}else if (arguments.length == 4){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
	}else if (arguments.length == 5){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
	}else if (arguments.length == 6){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
	}else if (arguments.length == 7){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
	}else if (arguments.length == 8){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
	}else if (arguments.length == 9){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
	}else if (arguments.length == 10){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
		maximizedstate=arguments[9];
	}else if (arguments.length == 11){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
		maximizedstate=arguments[9];
		onLoadCallback=arguments[10];
	}else if (arguments.length == 12){
		dialogid=arguments[0];
		hrefurl=arguments[1];
		titlevalue=arguments[2];
		widthvalue=arguments[3];
		heightvalue=arguments[4];
		buttonsname=arguments[5];
		maximizablestate=arguments[6];
		maximizedstate=arguments[7];
		closemsgtype=arguments[8];
		maximizedstate=arguments[9];
		onLoadCallback=arguments[10];
		maxLoadCallback=arguments[11];
	}
	if(widthvalue==0 ||heightvalue==0){
		widthvalue=950;
		heightvalue=570;
    }
	DialogOpenSystem(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname,maximizablestate,iconClsName,closemsgtype,maximizedstate,onLoadCallback,maxLoadCallback);
}
var UEObj;//百度UE编辑器对像
var UEDiv;//百度UE编辑器容器对像

var UEObjKnow;//百度UE编辑器对像
var UEDivKnow;//百度UE编辑器容器对像
/**
 * 说　明：弹出自定议大小dialog
 * 创建人：lzchina
 * 日　期：2015年02月08日
 * 参  数：
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   widthvalue：窗体宽度
 *   heightvalue：窗体高度
 *   buttonsname:底部工具栏名称,该名称可以为空，方法会有默认名称，但同时定义的div名称也是跟默认名称一样
 *   maximizablestate:定义是否允许窗体最大化　true或false
 *   iconClsName:设置一个16x16图标的CSS类ID显示在面板左上角。默认为null
 *   closemsgtype:true弹出关闭对话框 fase　不弹出对话框
 *   maximizedstate:定义是否在初始化的时候最大化面板。true或false
 *   onLoadCallback:在加载远程数据时触发加载的函数
 *   maxLoadCallback:窗体最大化时执行的函数
 */
function DialogOpenSystem(dialogid,hrefurl, titlevalue, widthvalue,heightvalue,buttonsname,
												maximizablestate,iconClsName,closemsgtype,maximizedstate,onLoadCallback,maxLoadCallback){ 
	if(buttonsname.length==0){
		buttonsname="#dlg-buttons";
    }
	if($("#" + dialogid + "").length > 0){
		if($("#" + dialogid + "").is(':hidden')){
			$("#" + dialogid + "").dialog('open');
		}else{
			$("#" + dialogid + "").dialog('close',true);
		}
	}else{ 		
		dialogObj = $("<div id='"+dialogid+"'  class='easyui-dialog' />");
		dialogObj.dialog({
			hide:true, 
			width : widthvalue,
			height : heightvalue,
			loadingMessage:'正在努力为您加载数据,请稍候......',
			collapsible : false,
			maximizable:maximizablestate,
			maximized:maximizedstate,
			modal : true,
			href : hrefurl,
			iconCls:iconClsName,
			title : titlevalue,
			shadow:false,
			cache : false,
			buttons :buttonsname,
			onBeforeClose:function(){
				if(closemsgtype){
					DialogClose(dialogid);
				}else{
					dialogObj.dialog('destroy');
				}
				return false;
			},
			onMaximize:function(){
				if (maxLoadCallback != undefined && maxLoadCallback.length > 0) {
	                eval(maxLoadCallback);
	            }
				if(UEObj!=undefined){
					var divheight=0;
					if(UEDiv.height()>800){
						divheight=UEDiv.height()-150;						
					}else{
						divheight=UEDiv.height()-180;
					}
					UEObj.setHeight(divheight);
				}
				if(UEObjKnow!=undefined){
					var divheight=0;
					if(UEDivKnow.height()>800){
						divheight=UEDivKnow.height();
					}else{
						divheight=UEDivKnow.height();
					}
					UEObjKnow.setHeight(divheight);
				}
			},
			onRestore:function(){
				if (maxLoadCallback != undefined && maxLoadCallback.length > 0) {
	                eval(maxLoadCallback);
	            }
				if(UEObj!=undefined){
					var divheight=UEDiv.height()-203;
					UEObj.setHeight(divheight);	
				}
				
				if(UEObjKnow!=undefined){
					var divheight=UEDivKnow.height()-206;
					UEObjKnow.setHeight(divheight);	
				}
			}, 
			onBeforeOpen : function( ) {
				//alert(  );
			},
	        onLoad : function() {
	            if (onLoadCallback != undefined && onLoadCallback.length > 0) {
	                eval(onLoadCallback);
	            }
	        }
		});
	}	
}
/**
 * 说　明：关闭dialog
 * 创建人：lzchina
 *   dialogid:需要转换成窗口的DIV的ID名称
 */
function DialogClose(dialogid){
	$("#"+dialogid).dialog('destroy');
}
/**
 * 说　明：弹出自定议大小dialog (无关闭提示)
 * 创建人：lzchina
 *   dialogid:需要转换成窗口的DIV的ID名称
 *   hrefurl:需要加载的页面路径
 *   titlevalue：窗体标题名称
 *   widthvalue：窗体宽度
 *   heightvalue：窗体高度
  */
function DialogNoClosePrompt(dialogid,hrefurl, titlevalue, widthvalue,heightvalue) {
	if($("#" + dialogid + "").length > 0){
		if($("#" + dialogid + "").is(':hidden')){
			$("#" + dialogid + "").dialog('open');			
		}else{
			$("#" + dialogid + "").dialog('close',true);			
		}
	}else{
		dialogObj = $("<div id='"+dialogid+"'  class='easyui-dialog' />");
		dialogObj.dialog({
			hide:true, 
			width : widthvalue,
			height : heightvalue,
			loadingMessage:'正在努力为您加载数据,请稍候......',
			collapsible : false,
			modal : true,
			href : hrefurl,
			title : titlevalue,
			shadow:false,
			cache : false,
			onBeforeClose:function(){			
			    try{
			    	dialogObj.dialog('destroy');
			    }catch(e){
			    	DialogClose(dialogid);
			    }
			   return false;
			}
		});
	}	
}
function DialogOpenCC(dialogid,hrefurl, titlevalue){
	if($("#" + dialogid + "").length > 0){
		if($("#" + dialogid + "").is(':hidden')){
			$("#" + dialogid + "").dialog('open');			
		}else{
			$("#" + dialogid + "").dialog('close',true);			
		}
	}else{
		dialogObj = $("<div id='"+dialogid+"'  class='easyui-dialog' />");
		dialogObj.dialog({
			hide:true, 
			width : 500,
			height : 320,
			loadingMessage:'正在努力为您加载数据,请稍候......',
			collapsible : false,
			maximizable:false,
			minimizable:true,
			closable:false,
			modal : false,
			href : hrefurl,
			title : titlevalue,
			shadow:false,
			cache : false,
			onBeforeClose:function(){
				dialogObj.dialog('close',true);//destroy
				return false;
			}
		});
	}	
}
