package cn.tedu.ttms.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.user.entity.Menu;
import cn.tedu.ttms.user.mapper.MenuMapper;
import cn.tedu.ttms.user.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;
	
	public List<Menu> selectMenu(Menu menu) throws Exception {
		return menuMapper.selectMenu(menu);
	}

	public int addMenu(Menu Menu) throws Exception {
		return menuMapper.addMenu(Menu);
	}

	public int updateMenu(Menu menu) throws Exception {
		return menuMapper.updateMenu(menu);
	}

	public int delMenu(Menu menu) throws Exception {
		return menuMapper.delMenu(menu);
	}

}
