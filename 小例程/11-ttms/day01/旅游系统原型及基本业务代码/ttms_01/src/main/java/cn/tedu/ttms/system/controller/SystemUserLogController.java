package cn.tedu.ttms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systemUserLog")
public class SystemUserLogController {

	@RequestMapping("/list.do")
	public String systemUserLogList(){
		return "ttms/system/systemUserLogList";
	}
}
