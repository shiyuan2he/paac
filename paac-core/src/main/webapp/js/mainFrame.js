/**
 * @description <p>mainFrame.jsp初始化加载js代码</p>
 */
$(function(){
	/**
	 * @author heshiyuan @date 2016年11月2日 下午3:30:20
	 * @description <p>初始化加载后台首页</p>
	 */
	/**
	 * @description <p>进入后台欢迎页面</p>
	 */
	mainframe.menuHref('mainFrameCenter','./mainFrame/manage/manage_toWelcome.action');
	/**
	 * @description <p>后台首页底部自动加载当前年份，月份</p>
	 */
	$("#copyrightTime").html(DateHelper.getYearAndMonth()) ;
});
var mainframe = {
	/**
	 * 
	 * @description <p>跳转到此菜单时根据second是否打开二级子菜单</p>
	 * @param hrefurl
	 * @param second
	 * @returnType void
	 * 方法名:menuHref
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月2日 下午3:18:23
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	menuHref:function(divId,hrefurl,second){
		if(second == undefined){
			$("#"+divId).panel({
				method:'post',
				region : 'center',
				href : hrefurl,
				onLoad : function(){}
			});
		}else{
			$("#"+divId).panel({
				method:'post',
				region : 'center',
				href : hrefurl,
				onLoad : second
			});
		}
	}
};
