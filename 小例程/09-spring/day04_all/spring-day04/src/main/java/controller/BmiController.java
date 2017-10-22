package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BmiController {
	@RequestMapping("/toBmi.do")
	public String toBmi(){
		System.out.println("toBmi()");
		return "bmi";
	}
	
	@RequestMapping("/bmi.do")
	public String bmi(BmiParam bp,
			ModelMap mm){
		System.out.println("bmi()");
		//计算bmi指数
		double bmi = 
				bp.getWeight() /
				bp.getHeight() / 
				bp.getHeight();
		//依据bmi指数判断用户的身体状况
		String status = "正常";
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		//向页面传值
		mm.addAttribute("status",
				"你的bmi指数是"
		+ bmi + ",身体状况是" + status);
		
		return "view";
	}
}




