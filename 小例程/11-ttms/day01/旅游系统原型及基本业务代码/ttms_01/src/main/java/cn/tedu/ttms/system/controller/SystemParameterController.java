package cn.tedu.ttms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systemParameter")
public class SystemParameterController {

	@RequestMapping("/list.do")
	public String parameterList(){
		return "ttms/system/parameterList";
	}
}
