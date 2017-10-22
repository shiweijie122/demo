package cn.tedu.netctoss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.AppException;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.util.ImageUtil;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService ls;
	
	@ExceptionHandler
	public String handleEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx()");
		if(e instanceof AppException){
			//应用异常
			request.setAttribute(
					"login_failed", 
					e.getMessage());
			return "login";
		}
		//系统异常
		return "error";
	}
	
	@RequestMapping("/checkcode.do")
	/*
	 * 返回一个验证码图片
	 * 当方法的返回值不是String,也不是
	 * ModelAndView,则由代码来控制(转发还是
	 * 重定向，或者是直接输出)。
	 */
	public void checkcode(
			HttpServletResponse response,
			HttpSession session) 
					throws IOException{
		System.out.println("checkcode()");
		Object[] objs = ImageUtil.createImage();
		
		//将验证码先存放到session对象上
		String number = (String) objs[0];
		session.setAttribute("number", number);
		
		BufferedImage image =
				(BufferedImage) objs[1];
		//将原始图片按照指定的格式压缩，然后
		//发送给浏览器。
		javax.imageio.ImageIO
		.write(image, "jpeg", 
				response.getOutputStream());
	}
	
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		System.out.println("login()");
		//先比较验证码是否正确
		//number1:用户提交的验证码
		String number1 = 
				request.getParameter(
						"number");
		//number2:session对象上保存的验证码
		String number2 = 
			(String) session.getAttribute(
					"number");
		if(!number1.equals(number2)){
			//验证码不一致，提示用户
			request.setAttribute(
					"number_error",
					"验证码错误");
			return "login";
		}
		
		//读取帐号和密码
		String adminCode = 
				request.getParameter(
						"adminCode");
		System.out.println("adminCode:" 
						+ adminCode);
		String pwd = 
				request.getParameter("pwd");
		//调用业务层组件来完成登录请求
		//注：表示层要负责处理业务层抛出的异常。
		Admin admin = 
				ls.checkLogin(adminCode, pwd);
		//登录成功，将admin绑订到session
		//对象上（用于session验证）
		session.setAttribute(
				"admin", admin);
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
}






