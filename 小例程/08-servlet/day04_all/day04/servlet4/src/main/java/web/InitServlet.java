package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *	在真实项目中,往往有一个甚至多个这样的Servlet,
 *	它们不负责处理具体请求,只是用来初始化数据的.
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		//tomcat启动时最先创建context,
		//然后再创建配置了load-on-startup的Servlet.
		ServletContext ctx = getServletContext();
		ctx.setAttribute("count", 0);
	}
	
}








