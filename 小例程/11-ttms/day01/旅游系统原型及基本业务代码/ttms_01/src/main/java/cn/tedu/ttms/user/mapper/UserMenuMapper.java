package cn.tedu.ttms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.user.entity.UserMenu;


public interface UserMenuMapper {

	/**
	 * 查询菜单
	 * @param parentId
	 * @param level
	 * @param userId
	 * @return
	 */
	List<UserMenu> getUserMenu(@Param(value = "parentId")String parentId,@Param(value = "level")String level,@Param(value = "userId")String userId);

}
