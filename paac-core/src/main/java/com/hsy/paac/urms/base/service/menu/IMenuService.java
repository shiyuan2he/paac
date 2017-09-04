package com.hsy.paac.urms.base.service.menu;
import java.util.List;

import com.hsy.paac.urms.base.entry.bean.RightsMenuTree;

/**
 * @path paac-core/com.codelibrary.javaee.service.IMenuService.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月3日 上午11:48:34
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
public interface IMenuService {
	/**
	 * 
	 * @description <p>创建菜单</p>
	 * @param menuName
	 * @param menuParent
	 * @param menuUrl
	 * @param menuLevel
	 * @returnType void
	 * 方法名:createMenuRights
	 * 类名:IMenuService
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月3日 下午1:55:05
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public void createMenuRights(String menuName,String menuParent,String menuUrl,int menuLevel,int menuOrder) ;
	/**
	 * 
	 * @description <p>根据用户ID获取本人菜单权限树</p>
	 * @param userId
	 * @return
	 * @returnType List<MenuRightsTree>
	 * 方法名:getMenuRightsTreeList
	 * 类名:IMenuService
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月3日 下午4:48:39
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public List<RightsMenuTree> getMenuRightsTreeList(String userId) ;
}


