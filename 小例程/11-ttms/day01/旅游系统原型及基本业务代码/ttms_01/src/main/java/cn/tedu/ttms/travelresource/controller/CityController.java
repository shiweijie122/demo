package cn.tedu.ttms.travelresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {
	
	/**
	 * 点击城市菜单跳转到城市列表页面
	 */
	@RequestMapping("/list.do")
	public String cityList(){
		return "ttms/travelresource/cityManageList";
	}
	
	/**
	 * 跳转到城市编辑页面
	 */
	@RequestMapping("/showEditCityPage.do")
	public String showAddCityPage(){
		return "ttms/travelresource/editCity";
	}

}
