package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.CostDao;
import entity.Admin;
import entity.Cost;
import util.ImageUtil;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//�ж�����·��
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			//��ѯ�ʷ�
			findCost(req, res);
		} else if("/toAddCost.do".equals(path)) {
			//�������ʷ�ҳ
			toAddCost(req, res);
		} else if("/addCost.do".equals(path)) {
			//���ӱ����ʷ�
			addCost(req, res);
		} else if("/toUpdateCost.do".equals(path)) {
			//���޸��ʷ�ҳ
			toUpdateCost(req, res);
		} else if("/updateCost.do".equals(path)) {
			//�޸ı����ʷ�
			updateCost(req, res);
		} else if("/deleteCost.do".equals(path)) {
			deleteCost(req,res);
		} else if("/toLogin.do".equals(path)) {
			//�򿪵�¼ҳ
			toLogin(req, res);
		} else if("/toIndex.do".equals(path)) {
			//����ҳ
			toIndex(req, res);
		} else if("/login.do".equals(path)) {
			//��¼У��
			login(req, res);
		} else if("/createImg.do".equals(path)) {
			//������֤��
			createImg(req, res);
		} else {
			//����·��
			throw new RuntimeException("���޴�ҳ");
		}
	}

	protected void createImg(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//������֤�뼰ͼƬ
		Object[] objs = ImageUtil.createImage();
		//����֤�����session
		HttpSession sn = req.getSession();
		sn.setAttribute("imgCode", objs[0]);
		//��ͼƬ����������
		res.setContentType("image/png");
		OutputStream os = res.getOutputStream();
		ImageIO.write(
			(BufferedImage) objs[1], "png", os);
		os.close();
	}
	
	protected void login(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//�����������
		String adminCode = 
			req.getParameter("adminCode");
		String pwd = 
			req.getParameter("password");
		String code = 
			req.getParameter("code");
		//У����֤��
		HttpSession sn = req.getSession();
		String imgCode = (String)
			sn.getAttribute("imgCode");
		if(code == null
			|| !code.equalsIgnoreCase(imgCode)) {
			//��֤�����
			req.setAttribute(
				"error", "��֤�����");
			req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
				.forward(req, res);
			return;
		}
		
		//��¼��֤
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		if(a == null) {
			//�˺Ų����ڣ�ת���ص�¼ҳ
			//Ŀ��:/netctoss/WEB-INF/main/login.jsp
			req.setAttribute(
				"error", "�˺Ų�����");
			req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
				.forward(req, res);
		} else if(!a.getPassword().equals(pwd)) {
			//�������ת���ص�¼ҳ
			//Ŀ��:/netctoss/WEB-INF/main/login.jsp
			req.setAttribute(
				"error", "�������");
			req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
				.forward(req, res);
		} else {
			//���˺ż�¼��Cookie�У�
			//������������ҳ������ʾ�˺š�
			Cookie ck = new Cookie(
				"adminCode",adminCode);
			res.addCookie(ck);
			//���˺Ŵ���session������
			//��������¼����ҵ��
			sn.setAttribute(
				"adminCode", adminCode);
			//�ɹ����ض�����ҳ
			//��ǰ:/netctoss/login.do
			//Ŀ��:/netctoss/toIndex.do
			res.sendRedirect("toIndex.do");
		}
	}
	
	protected void toIndex(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//��ǰ:/netctoss/toIndex.do
		//Ŀ��:/netctoss/WEB-INF/main/index.jsp
		req.getRequestDispatcher(
			"WEB-INF/main/index.jsp")
			.forward(req, res);
	}
	
	protected void toLogin(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//��ǰ:/netctoss/toLogin.do
		//Ŀ��:/netctoss/WEB-INF/main/login.jsp
		req.getRequestDispatcher(
			"WEB-INF/main/login.jsp")
			.forward(req, res);
	}
	
	protected void deleteCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException{
		String id = req.getParameter("id");
		CostDao dao = new CostDao();
		dao.delete(new Integer(id));
		res.sendRedirect("findCost.do");
	}
	
	protected void updateCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//��ȡ�������
		//���������ֿ�������������
		//Ϊ�˱��ڼ���ͨ����ʵ������ͬ����
		String costId = 
			req.getParameter("costId");
		String name = 
			req.getParameter("name");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost =
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = 
			req.getParameter("descr");
		String costType = 
			req.getParameter("costType");
		//�޸���Щ����
		Cost c = new Cost();
		c.setCostId(new Integer(costId));
		c.setName(name);
		c.setDescr(descr);
		c.setCostType(costType);
		if(baseDuration != null
			&& !baseDuration.equals("")) {
			c.setBaseDuration(
				new Integer(baseDuration));
		}
		if(baseCost != null
			&& !baseCost.equals("")) {
			c.setBaseCost(
				new Double(baseCost));
		}
		if(unitCost != null
			&& !unitCost.equals("")) {
			c.setUnitCost(
				new Double(unitCost));
		}
		CostDao dao = new CostDao();
		dao.update(c);
		//�ض��򵽲�ѯ
		res.sendRedirect("findCost.do");
	}
	
	protected void toUpdateCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//�����������
		String id = req.getParameter("id");
		//��ѯ���ʷ�����
		CostDao dao = new CostDao();
		Cost cost = 
			dao.findById(new Integer(id));
		//ת�����޸�ҳ��
		//��ǰ:/netctoss/toUpdateCost.do
		//Ŀ��:/netctoss/WEB-INF/cost/cost_update.jsp
		req.setAttribute("cost", cost);
		req.getRequestDispatcher(
			"WEB-INF/cost/update.jsp")
			.forward(req, res);
	}
	
	protected void addCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
		req.setCharacterEncoding("utf-8");
		//������������
		String name = req.getParameter("name");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost = 
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		String costType= 
			req.getParameter("costType");
		//��������
		Cost c = new Cost();
		c.setName(name);
		if(baseDuration != null
			&& !baseDuration.equals("")) {
			c.setBaseDuration(
				new Integer(baseDuration));
		}
		if(baseCost != null
			&& !baseCost.equals("")) {
			c.setBaseCost(
				new Double(baseCost));
		}
		if(unitCost != null
			&& !unitCost.equals("")) {
			c.setUnitCost(
				new Double(unitCost));
		}
		c.setDescr(descr);
		c.setCostType(costType);
		CostDao dao = new CostDao();
		dao.save(c);
		//�ض��򵽲�ѯ�ʷ�
		//��ǰ��/netctoss/addCost.do
		//Ŀ�꣺/netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}
	
	protected void toAddCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//ת�������ʷ�ҳ��
		//��ǰ��/netctoss/toAddCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/cost_add.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/add.jsp")
			.forward(req, res);
	}
	
	protected void findCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//��ȡ�������
		String page = req.getParameter("page");
		if(page == null || page.equals("")) {
			page = "1";
		}
		//��ȡ����
		String size = 
			getServletContext()
				.getInitParameter("size");
		//��ѯ�ʷ�
		CostDao dao = new CostDao();
		List<Cost> list = 
			dao.findByPage(
				new Integer(page), 
				new Integer(size));
		//��ѯ���������������ҳ��
		int rows = dao.findRows();
		int total = rows/new Integer(size);
		if(rows%new Integer(size) != 0) {
			total++;
		}
		//ת������ѯҳ��
		req.setAttribute("costs", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);
		//��ǰ��/netctoss/findCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/find.jsp")
			.forward(req, res);
	}
	
}










