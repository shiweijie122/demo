package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//tomcat在启动时,会加载每一个部署项目,
		//并给每个项目创建一个context对象,该对象
		//内有代码自动读取了web.xml中配置的参数.
		//每个项目内都有唯一的一个context,所有的
		//Servlet都可以从context内获取参数.
		ServletContext ctx = getServletContext();
		String size = ctx.getInitParameter("size");
		System.out.println(size);
		//统计流量
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println("流量:" + count);
	}

}







