package cn.tedu.ttms.guide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guide")
public class GuideController {
	/**
	 * 点击导游信息管理菜单，跳转到导游信息管理页面
	 */
	@RequestMapping("/list.do")
	public String guideList(){
		return "ttms/guide/guideManageList";
	}
	
	/**
	 * 点击新增按钮，模态框加载新增页面
	 */
	@RequestMapping("/showEditGuidePage.do")
	public String showAddGuidePage(){
		return "ttms/guide/editGuide";
	}
	
	/**
	 * 跳转到导游详细页面
	 */
	@RequestMapping("/showGuideDetail.do")
	public String showGuideDetail(){
		return "ttms/guide/guideDetail";
	}

}
