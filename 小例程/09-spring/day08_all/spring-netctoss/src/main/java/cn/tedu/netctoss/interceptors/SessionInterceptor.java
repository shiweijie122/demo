package cn.tedu.netctoss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于session验证的拦截器
 *
 */
public class SessionInterceptor implements 
HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		HttpSession session = 
				request.getSession();
		Object obj = 
				session.getAttribute("admin");
		if(obj == null){
			//没有登录，重定向到登录页面
			response.sendRedirect(
					"toLogin.do");
			return false;
		}
		//登录过，继续向后调用
		return true;
	}
}






