package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet 
	extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		//获得请求资源路径
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		//分析请求资源路径
		String action = 
			uri.substring(
					uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		System.out.println("action:" + action);
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		//依据分析结果，进行不同的处理
		if("/check".equals(action)){
			//检查用户名是否存在
			String uname = 
					request.getParameter("uname");
			System.out.println("uname:" + uname);
			//访问数据库
			if("Sally".equals(uname)){
				//只需要返回部分数据
				out.println("用户名已经存在");
			}else{
				out.println("可以使用");
			}
		}else if("/getNumber".equals(action)){
			//返回一个随机整数
			Random r = new Random();
			int number = r.nextInt(1000);
			System.out.println("number:" + number);
			out.println(number);
		}
		
	}
}



