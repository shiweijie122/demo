package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//1.使用request读取请求数据
		//1.1请求行
		System.out.println(
			"请求方式:" + req.getMethod());
		System.out.println(
			"访问路径:" + req.getServletPath());
		System.out.println(
			"协议类型:" + req.getProtocol());
		//1.2消息头
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(
				key + ":" + value);
		}
		//1.3实体内容
		//浏览器向服务器发送的业务数据,
		//如账号、密码等
		//本案例没有业务数据,实体内容为空
		
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		
		//2.使用response发送响应数据
		//2.1状态行
		//由服务器自动填写
		//2.2消息头
		//大部分数据由服务器自动填写,
		//数据类型必须由我们设置.
		//告诉浏览器发送的数据的类型
		res.setContentType("text/html");
		//获取输出流
		PrintWriter w = res.getWriter();
		//2.3实体内容
		//发送的网页就是实体内容
		//此处偷懒,省略若干标签
		w.println("<p>"+now+"</p>");
		//关闭流
		w.close();
	}

}






