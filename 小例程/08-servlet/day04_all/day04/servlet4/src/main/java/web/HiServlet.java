package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	public HiServlet() {
		System.out.println("实例化HiServlet");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//父辈的service内有默认逻辑,
		//它根据请求方式调用了doGet/doPost,
		//而do方法内直接抛出了异常.
		//所以若不想重写do方法,就不要
		//执行这段逻辑了.
		//super.service(arg0, arg1);
		System.out.println("调用HiServlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁HiServlet");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("初始化HiServlet-1");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化HiServlet-2");
	}
	
}





