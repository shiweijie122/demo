package cn.tedu.ttms.travelresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/continent")
public class ContinentController {
	
	/**
	 * 点击世界大洲，跳转到大洲管理页面
	 */
	@RequestMapping("/list.do")
	public String continentList(){
		return "ttms/travelresource/continentManageList";
	}
	
	/**
	 * 跳转到添加世界大洲页面
	 */
	@RequestMapping("/showEditContinentPage.do")
	public String showEditContinentPage(){
		return "ttms/travelresource/editContinent";
	}

}
