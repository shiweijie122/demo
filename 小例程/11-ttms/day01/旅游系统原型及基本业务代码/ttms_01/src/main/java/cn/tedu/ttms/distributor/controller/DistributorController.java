package cn.tedu.ttms.distributor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/distributor")
public class DistributorController {

	/**
	 * 点击分销商菜单调转到分销商管理页面
	 * @return
	 */
	@RequestMapping("/list.do")
	public String list(){
		return "ttms/distributor/distributorManageList";
	}
}
