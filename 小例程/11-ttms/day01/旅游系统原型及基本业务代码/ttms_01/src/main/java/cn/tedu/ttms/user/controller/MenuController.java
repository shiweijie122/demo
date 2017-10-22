package cn.tedu.ttms.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.BaseController;
import cn.tedu.ttms.sys.utils.DataOptUtil;
import cn.tedu.ttms.user.entity.Menu;
import cn.tedu.ttms.user.service.MenuService;


/**
 * 菜单管理
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	@Resource
	private MenuService menuService;
	
	/**
	 * 显示菜单画面
	 * @return
	 */
	@RequestMapping("info")
	public String showMenu() throws Exception {
		return "menu/menu";
	}
	
	/**
	 * 取得菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("select")
	@ResponseBody
	public List<Menu> selectMenu(Menu menu) throws Exception {
		List<Menu> menuList = this.menuService.selectMenu(menu);
		return menuList;
	}
	
	/**
	 * 保存菜单
	 * @param menu
	 * @return
	 */
	@RequestMapping("save")
	public String saveDictType(Menu menu) throws Exception{
		if(DataOptUtil.isNull(menu.getMenuId())) { //新增
			this.menuService.addMenu(menu);
		} else { //编辑
			this.menuService.updateMenu(menu);
		}
		
		return "redirect:menuInfo.do";
	}
	
	/**
	 * 删除菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete")
	@ResponseBody
	public void delDictType(Menu menu) throws Exception{
		this.menuService.delMenu(menu);
	}
}
