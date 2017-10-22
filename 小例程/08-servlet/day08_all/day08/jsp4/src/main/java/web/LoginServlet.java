package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	//模拟的是NETCTOSS中的login()
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//接收账号
		String code = req.getParameter("code");
		//将其存入cookie
		//1个cookie只能存一份String数据.
		Cookie c1 = new Cookie("user",code);
		//声明cookie的有效时间
		c1.setMaxAge(6000);
		//将cookie发送给浏览器
		res.addCookie(c1);
		
		//在cookie中存中文
		Cookie c2 = new Cookie("city",
			URLEncoder.encode("北京", "utf-8"));
		res.addCookie(c2);
		
		//设置cookie的有效路径
		Cookie c3 = new Cookie("name","Tom");
		c3.setPath("/jsp4");
		res.addCookie(c3);
		
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		w.println("ok");
		w.close();
	}

}













