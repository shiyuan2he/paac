package com.codelibrary.javaee.service.menu.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;
import com.codelibrary.javaee.entry.bean.RightsMenuTree;
import com.codelibrary.javaee.service.menu.IMenuService;
import com.hsy.codebase.utils.javase.string.StringHelper;
/**
 * @path paac-core/com.codelibrary.javaee.service.menu.impl.RightsMenu.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月3日 下午6:13:21
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
public class RightsMenu {
	/**
	 * 
	 * @description <p>请在这里输入方法的作用</p>
	 * @param list
	 * @param menuService
	 * @return
	 * @returnType List<RightsMenuTree>
	 * 方法名:getMenuTree
	 * 类名:RightsMenu
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月3日 下午7:10:25
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static List<RightsMenuTree> getRightsMenuTreeList(List<Map<String,Object>> list,IMenuService menuService) {
		List<RightsMenuTree> treeList = new ArrayList<>() ;
		
		for(Map<String,Object> map : list){
			if(!CollectionUtils.isEmpty(map)){
				treeList.add(getRightsMenuTree(map)) ;
			}
		}
		return treeList;
	}
	/**
	 * @description <p>将Map<String,Object>转化成RightsMenuTree</p>
	 * @param node
	 * @param parentNode
	 * @param count
	 * @return
	 * @returnType RightsMenuTree
	 * 方法名:getLeftRightsTree
	 * 类名:RightsMenu
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月3日 下午7:06:03
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static RightsMenuTree getRightsMenuTree(Map<String,Object> node){
		String name = node.get("menuName")==null?"":node.get("menuName").toString();
		String id = node.get("menuId").toString();
		String menuType = node.get("menuType").toString();
		String pid = node.get("menuParent").toString();
		String menuUrl = node.get("menuUrl").toString();
		RightsMenuTree td = new RightsMenuTree();
		td.setId(id);
		td.setCode(id);
		td.setName(name);
		td.setMenuId(id);
		td.setMenuType(menuType);
		td.setMenuName(name);
		td.setMenuParent(pid);
		td.setMenuUrl(menuUrl);
		return td;
	}
}


