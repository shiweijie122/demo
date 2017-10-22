package cn.tedu.ttms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	/**
	 * 
	 */
	@RequestMapping("/list.do")
	public String authorityList(){
		return "ttms/system/authorityManageList";
	}

}
