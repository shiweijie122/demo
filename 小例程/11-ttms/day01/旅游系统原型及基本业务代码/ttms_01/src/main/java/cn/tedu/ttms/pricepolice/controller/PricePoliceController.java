package cn.tedu.ttms.pricepolice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pricePolice")
public class PricePoliceController {
	
	/**
	 * 点击价格政策，跳转到价格政策管理页面
	 * @return
	 */
	@RequestMapping("/list.do")
	public String pricePoliceList(){
		return "ttms/pricepolice/pricePoliceManageList";
	}

}
