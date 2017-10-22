package cn.tedu.netctoss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.AppException;
import cn.tedu.netctoss.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService ls;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request){
		System.out.println("login()");
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
		try{
			Admin admin = 
				ls.checkLogin(adminCode, pwd);
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，应该明确提示用户
				//采取正确的操作。
				request.setAttribute(
						"login_failed",
						e.getMessage());
				return "login";
			}
			//系统异常，提示用户稍后重试
			return "error";
		}
		//登录成功
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
}






