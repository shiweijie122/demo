package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//发送响应的数据
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		//当前:/EmpManager/findEmp
		//目标:/EmpManager/add_emp.html
		w.println("<a href='add_emp.html'>增加</a>");
		w.println("<table border='1' cellspacing='0' width='300px'>");
		w.println("	<tr>");
		w.println("		<td>编号</td>");
		w.println("		<td>姓名</td>");
		w.println("		<td>职位</td>");
		w.println("		<td>工资</td>");
		w.println("	</tr>");
		for(Emp e : list) {
			w.println("<tr>");
			w.println("	<td>"+e.getEmpno()+"</td>");
			w.println("	<td>"+e.getEname()+"</td>");
			w.println("	<td>"+e.getJob()+"</td>");
			w.println("	<td>"+e.getSal()+"</td>");
			w.println("</tr>");
		}
		w.println("</table>");
		w.close();
	}
	
}










