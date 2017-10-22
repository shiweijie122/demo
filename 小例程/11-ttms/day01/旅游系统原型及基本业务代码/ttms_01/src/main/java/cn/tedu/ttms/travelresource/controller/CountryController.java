package cn.tedu.ttms.travelresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
public class CountryController {
	/**
	 * 点击国家地区菜单，跳转到国家管理页面
	 */
	@RequestMapping("/list.do")
	public String countryList(){
		return "ttms/travelresource/countryManageList";
	}
	
	/**
	 * 跳转到新增国家地区页面
	 */
	@RequestMapping("/showEditCountryPage.do")
	public String showEditCountryPage(){
		return "ttms/travelresource/editCountry";
	}
}
