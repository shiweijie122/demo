package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		//返回视图名
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	/*
	 * 注（了解）：
	 * 		DispatcherServlet在调用Controller
	 * 	的方法之前，会利用java反射分析方法的结
	 *  构。这儿，会将request对象传过来。
	 */
	public String login(
			HttpServletRequest request){
		System.out.println("login()");
		String adminCode = 
				request.getParameter(
						"adminCode");
		String pwd = 
				request.getParameter("pwd");
		System.out.println(adminCode
				+ " " + pwd);
		return "index";
	}
	
	@RequestMapping("/login2.do")
	/*
	 * 注（了解）
	 * 	DispatcherServlet会调用request对象
	 * 的方法获得相应的参数值，然后赋给相应的
	 * 形参。
	 * 	如果形参名与请求参数名不一致，使用
	 *  @RequestParam注解来说明对应关系。
	 */
	public String login2(String adminCode,
			@RequestParam("pwd") 
			String password){
		System.out.println("login2()");
		System.out.println(adminCode 
				+ " " + password);
		return "index";
	}
	
	@RequestMapping("/login3.do")
	public String login3(AdminParam ap){
		System.out.println("login3()");
		String adminCode = 
				ap.getAdminCode();
		String pwd = 
				ap.getPwd();
		System.out.println(adminCode 
				+ " " + pwd);
		return "index";
	}
	
	@RequestMapping("/login4.do")
	public String login4(AdminParam ap,
			HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = 
				ap.getAdminCode();
		//将数据绑订到request对象上
		request.setAttribute(
				"adminCode", adminCode);
		//DispatcherServlet默认会使用转发
		return "index";
	}
	
	@RequestMapping("/login5.do")
	public ModelAndView login5(AdminParam ap){
		System.out.println("login5()");
		String adminCode = 
				ap.getAdminCode();
		/*
		 * 将数据添加到ModelAndView对象上。
		 * 分两步:
		 * step1.将数据添加到Map。
		 * step2.将Map添加到ModelAndView。
		 * */
		Map<String,Object> data = 
				new HashMap<String,Object>();
		/*
		 * (了解)
		 * DispatcherServlet会将ModelAndView
		 * 中的数据取出来，然后绑订到request
		 * 上（绑订名是Map中的key）
		 */
		data.put("adminCode", adminCode);
		ModelAndView mav = 
				new ModelAndView("index",data);
		return mav;
	}
	
	@RequestMapping("/login6.do")
	public String login6(AdminParam ap,
			ModelMap mm){
		System.out.println("login6()");
		String adminCode = 
				ap.getAdminCode();
		/*
		 * (了解)
		 * 	DispatcherServlet从ModelMap
		 * 对象上获取数据，然后将这些数据
		 * 绑订到request。
		 */
		mm.addAttribute("adminCode", 
				adminCode);
		
		return "index";
	}
	
	@RequestMapping("/login7.do")
	public String login7(AdminParam ap,
			HttpSession session){
		System.out.println("login7()");
		String adminCode = 
				ap.getAdminCode();
		//将数据绑订到session
		session.setAttribute(
				"adminCode", adminCode);
		return "index";
	}
	
	@RequestMapping("/login8.do")
	public String login8(){
		System.out.println("login8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/login9.do")
	public ModelAndView login9(){
		System.out.println("login9()");
		RedirectView rv = 
			new RedirectView("toIndex.do");
		ModelAndView mav = 
			new ModelAndView(rv);
		return mav;
	}
	
	
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	
}
























