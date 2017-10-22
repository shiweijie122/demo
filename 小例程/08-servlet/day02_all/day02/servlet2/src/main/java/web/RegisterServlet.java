package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.接收参数
		String user = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] interests = 
			req.getParameterValues("interest");
		
		//解决请求数据乱码
//		byte[] bs = user.getBytes("iso8859-1");
//		user = new String(bs,"utf-8");
		
		//2.处理业务
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests != null) {
			for(String i : interests) {
				System.out.println(i);
			}
		}
		//3.发送响应
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<p>成功了</p>");
		w.close();
	}

}




