package com.hsy.paac.urms.base.service.menu.impl;

import java.util.List;
import java.util.Map;

import com.hsy.paac.urms.base.entry.bean.RightsMenuTree;
import com.hsy.paac.urms.base.entry.hibernate.RightsMenu;
import com.hsy.paac.urms.base.hibernate.IBaseDao;
import com.hsy.paac.urms.base.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.paac.base.utils.javase.util.RandomHelper;

/**
 * @path paac-core/com.codelibrary.javaee.service.impl.MenuServiceImpl.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月3日 上午11:48:54
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
@Transactional
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private IBaseDao<Map<String,Object>,RightsMenu> baseDao ;
	/**
	 * 
	 * @description <p>后台创建权限</p>
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
	@Override
	public void createMenuRights(String menuName, String menuParent,String menuUrl, int menuLevel,int menuOrder) {
		RightsMenu menuRights = new RightsMenu() ;
		menuRights.setMenuLevel(menuLevel);
		menuRights.setMenuName(menuName);
		menuRights.setMenuParent(menuParent);
		menuRights.setMenuUrl(menuUrl);
		menuRights.setMenuCode(RandomHelper.generateValueByParam("R", "", 5));
		menuRights.setMenuOrder(Integer.parseInt(RandomHelper.generateValueByParam("", "", 5)));
		menuRights.setMenuType((char)0);
		menuRights.setIsDel("0");
		baseDao.save(menuRights) ;
	}
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
	@Override
	public List<RightsMenuTree> getMenuRightsTreeList(String userId) {
		StringBuilder hql = new StringBuilder() ;
		hql.append("select new Map(")
		   .append(" rightsMenu.id as id,rightsMenu.menuCode as menuCode,rightsMenu.menuName as menuName,rightsMenu.menuParent as menuParent,")
		   .append(" rightsMenu.menuUrl as menuUrl,rightsMenu.menuLevel as menuLevel,rightsMenu.menuType as menuType")
		   .append(")") 
		   .append(" from RightsMenu rightsMenu")
		   .append(" where 1=1")
		   .append(" and rightsMenu.isDel = 0")
	       .append(" and rightsMenu.menuLevel = 1")
		   ;
		List<Map<String,Object>> list =  (List<Map<String,Object>>)baseDao.find(hql.toString()) ;
		List<RightsMenuTree> rightsTree = RightsMenuService.getRightsMenuTreeList(list,this) ;
		return rightsTree;
	}
}


