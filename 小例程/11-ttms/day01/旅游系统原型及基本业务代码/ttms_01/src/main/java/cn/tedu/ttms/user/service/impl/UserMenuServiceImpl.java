package cn.tedu.ttms.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.user.entity.UserMenu;
import cn.tedu.ttms.user.mapper.UserMenuMapper;
import cn.tedu.ttms.user.service.UserMenuService;

@Service("userMenuService")
@Transactional
public class UserMenuServiceImpl implements UserMenuService {
	
	@Resource
	private UserMenuMapper userMenuMapper;
	
	/**
	 * 获取菜单
	 * @param parentId
	 * @param level
	 * @param userId
	 * @return
	 * @throws Exception
	 */
    public List<UserMenu> getUserMenu(String parentId,String level,String userId) throws Exception {
		return userMenuMapper.getUserMenu(parentId,level,userId);
	}

}
