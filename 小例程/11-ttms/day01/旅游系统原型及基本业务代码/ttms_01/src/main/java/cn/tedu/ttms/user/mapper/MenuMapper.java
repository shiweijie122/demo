package cn.tedu.ttms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.user.entity.Menu;



public interface MenuMapper {
	/**
	 * 查询菜单
	 * @param menu
	 * @return
	 */
	List<Menu> selectMenu(@Param(value = "menu")Menu menu);
	
	/**
	 * 取得下一个菜单编号
	 * @return
	 */
	/*public String getNextMenuId();*/
	
	/**
	 * 新增菜单
	 * @param Menu
	 * @return
	 */
	int addMenu(@Param(value = "menu")Menu Menu);
	
	/**
	 * 更新菜单
	 * @param menu
	 * @return
	 */
	int updateMenu(@Param(value = "menu")Menu menu);
	
	/**
	 * 删除菜单
	 * @param menu
	 * @return
	 */
	int delMenu(@Param(value = "menu")Menu menu);
}
