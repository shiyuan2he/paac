package com.hsy.paac.service.menu.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hsy.paac.service.menu.IMenuService;
import org.springframework.util.CollectionUtils;
import com.hsy.paac.entry.bean.RightsMenuTree;

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
public class RightsMenuService {
	/**
	 * 
	 * @description <p>将菜单列表转换成树结构</p>
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
		RightsMenuTree tree = new RightsMenuTree();
		tree.setId(node.get("id")==null?"":node.get("id").toString());
		tree.setMenuType(node.get("menuType")==null?"":node.get("menuType").toString());
		tree.setMenuName(node.get("menuName")==null?"":node.get("menuName").toString());
		tree.setMenuParent(node.get("menuParent")==null?"":node.get("menuParent").toString());
		tree.setMenuUrl(node.get("menuUrl")==null?"":node.get("menuUrl").toString());
		tree.setMenuLevel(node.get("menuLevel")==null?"":node.get("menuLevel").toString());
		return tree;
	}
}


