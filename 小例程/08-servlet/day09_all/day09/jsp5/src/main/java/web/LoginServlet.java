package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//接收账号
		String code = req.getParameter("code");
		//存入session
		//session中可以存任意类型任意数量的数据
		HttpSession session = req.getSession();
		session.setAttribute("user", code);
		
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		w.println("ok");
		w.close();
	}

}





