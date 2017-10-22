package cn.tedu.ttms.supplier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	/**
	 * 点击供应商菜单跳转到供应商管理页面
	 * @return
	 */
	@RequestMapping("/list.do")
	public String list(){
		return "ttms/supplier/supplierManageList";
	}

}
