package cn.tedu.ttms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("systemUser")
public class SystemUserController {
	
	@RequestMapping("/list.do")
	public String userList(){
		return "ttms/system/userManageList";
	}

}
