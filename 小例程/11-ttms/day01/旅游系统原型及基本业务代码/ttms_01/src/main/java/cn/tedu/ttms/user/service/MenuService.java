package cn.tedu.ttms.user.service;

import java.util.List;

import cn.tedu.ttms.user.entity.Menu;



public interface MenuService {

	/**
	 * 查询菜单
	 * 
	 * @param menu
	 * @return
	 */
	List<Menu> selectMenu(Menu menu) throws Exception;

	/**
	 * 取得下一个菜单编号
	 * 
	 * @return
	 */
	/* public String getNextMenuId() throws Exception; */

	/**
	 * 新增菜单
	 * 
	 * @param Menu
	 * @return
	 */
	int addMenu(Menu Menu) throws Exception;

	/**
	 * 更新菜单
	 * 
	 * @param menu
	 * @return
	 */
	int updateMenu(Menu menu) throws Exception;

	/**
	 * 删除菜单
	 * 
	 * @param menu
	 * @return
	 */
	int delMenu(Menu menu) throws Exception;

}
