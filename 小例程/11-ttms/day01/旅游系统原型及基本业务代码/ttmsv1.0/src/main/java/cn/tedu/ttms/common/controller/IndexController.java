package cn.tedu.ttms.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/indexUI")
	public String indexUI() {
		return "index";
	}
}
