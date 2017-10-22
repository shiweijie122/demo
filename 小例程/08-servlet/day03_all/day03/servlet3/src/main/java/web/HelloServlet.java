package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取路径的各个部位
		System.out.println(
			req.getContextPath());
		System.out.println(
			req.getServletPath());
		System.out.println(
			req.getRequestURI());
		System.out.println(
			req.getRequestURL());
		//若不写响应信息,则服务器会自动响应,
		//只是内容为空而已,浏览器看到一片空白.
	}

}




