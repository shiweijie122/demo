package cn.tedu.ttms.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.BaseController;
import cn.tedu.ttms.user.entity.UserMenu;
import cn.tedu.ttms.user.service.UserMenuService;


/**
 * 菜单管理
 *
 */
@Controller
@RequestMapping("/userMenu")
public class UserMenuController extends BaseController {
	@Resource
	private UserMenuService userMenuService;
	
	/**
	 * 取得菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sel")
	@ResponseBody
	public List<UserMenu> getUserMenus(String parentId,String level,String userId) throws Exception {
		
		List<UserMenu> menuListHeader = this.userMenuService.getUserMenu(parentId, level, userId);
		return menuListHeader;
	}
	
	
}
