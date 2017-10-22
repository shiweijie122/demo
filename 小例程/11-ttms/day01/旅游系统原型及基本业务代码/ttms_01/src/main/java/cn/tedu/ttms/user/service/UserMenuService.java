package cn.tedu.ttms.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.user.entity.UserMenu;


public interface UserMenuService {
	/**
	 * 查询菜单
	 * @param parentId
	 * @param level
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	List<UserMenu> getUserMenu(@Param(value = "parentId")String parentId,@Param(value = "level")String level,@Param(value = "userId")String userId) throws Exception;

}
