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

/**
 * 路径规范:
 * 查询员工: /find.emp
 * 增加员工: /add.emp
 * */
public class EmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//根据路径处理请求
		String path = req.getServletPath();
		if("/find.emp".equals(path)) {
			find(req,res);
		} else if("/add.emp".equals(path)) {
			add(req,res);
		} else {
			throw new RuntimeException(
				"不存在这个网页");
		}
	}
	
	protected void find(
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

	protected void add(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接收参数
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//保存数据
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(sal != null && sal.length()>0) {
			e.setSal(Double.valueOf(sal));
		}
		new EmpDao().save(e);
		//发送响应
//			res.setContentType(
//				"text/html;charset=utf-8");
//			PrintWriter w = res.getWriter();
//			w.println("<p>保存成功</p>");
//			w.close();
		//重定向到查询页面:
		//建议浏览器自己去访问查询页面.
		//当前:/EmpManager/add.emp
		//目标:/EmpManager/find.emp
		res.sendRedirect("find.emp");
	}	
	
}





