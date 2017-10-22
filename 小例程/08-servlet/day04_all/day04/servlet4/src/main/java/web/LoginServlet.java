package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//tomcat按照如下过程调用Servlet:
		//先实例化req,res
		//LoginServlet ls = new LoginServlet();
		//cfg = new ServletConfig();
		//ls.init(cfg);
		//ls.service(req,res);
		ServletConfig cfg = getServletConfig();
		String maxOnline = 
			cfg.getInitParameter("maxOnline");
		System.out.println(maxOnline);
		Integer.valueOf("abc");
	}

}








