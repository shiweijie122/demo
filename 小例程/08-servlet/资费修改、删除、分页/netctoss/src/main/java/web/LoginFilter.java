package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��������¼��飬�ж��û��Ƿ��¼��
 */
public class LoginFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(
		ServletRequest req, 
		ServletResponse res,
		FilterChain chain) 
		throws IOException, ServletException {
		HttpServletRequest request = 
			(HttpServletRequest) req;
		HttpServletResponse response = 
			(HttpServletResponse) res;
		//1.����ȷУ��ķ�Χ��
		//��3�����󲻱��жϣ�
		//toLogin.do,createImg.do,login.do
		String[] paths = {"/toLogin.do",
			"/createImg.do", "/login.do"};
		String path = request.getServletPath();
		for(String p : paths) {
			if(p.equals(path)) {
				chain.doFilter(req, res);
				return;
			}
		}
		//2.�������������Χ�ڵ�·����
		//��������Ҫ����¼����Ŀ�ꡣ
		String adminCode = (String)
			request.getSession()
			.getAttribute("adminCode");
		if(adminCode == null) {
			//û��¼���ض��򵽵�¼ҳ
			response.sendRedirect(
				request.getContextPath() + 
				"/toLogin.do");
		} else {
			//�ѵ�¼������
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) 
		throws ServletException {
		
	}

}
