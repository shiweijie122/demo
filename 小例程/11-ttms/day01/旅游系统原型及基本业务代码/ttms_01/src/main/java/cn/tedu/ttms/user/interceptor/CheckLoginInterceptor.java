package cn.tedu.ttms.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.ttms.sys.utils.Constant;

public class CheckLoginInterceptor implements HandlerInterceptor {
	private String url = "/userLogin/";

	//目标对象之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		String uri = request.getRequestURI();
		String basePath = request.getContextPath();
		
		if(uri.indexOf(url)==-1){
			//进行拦截
			Object obj = request.getSession().getAttribute(Constant.SESSION_KEY_LOGINUSER);
			if(null==obj){
				//session中没有对象存在，进行拦截
				response.sendRedirect(basePath+"/userLogin/login.do");
				flag = false;
			}else{
				//用户存在，不拦截
				flag = true;
			}
			
		}else{
			//不拦截
			flag = true;
		}
		
		return flag;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
