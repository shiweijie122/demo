package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@ExceptionHandler
	/** 这是一个异常处理方法。
	 *  e:是其它方法所抛出的异常。
	 */
	public String handleEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx()");
		//依据异常类型，做相应的处理
		if(e instanceof NumberFormatException){
			request.setAttribute("msg",
					"亲，请输入合法的数字");
			return "error3";
		}else if(e instanceof 
				StringIndexOutOfBoundsException){
			request.setAttribute("msg", "下标越界");
			return "error3";
		}
		//其它异常
		return "error";
	}
	
	
	
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1()");
		Integer.parseInt("123a");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		String str = "abcd";
		str.charAt(10);
		return "hello";
	}
}






