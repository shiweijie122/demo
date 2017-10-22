package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements 
HandlerInterceptor{

	/**
	 * 请求处理完毕，最后执行的方法。
	 * arg3: 处理器方法所抛出的异常。
	 */
	public void afterCompletion(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2, Exception arg3)
			throws Exception {
		System.out.println(
				"afterCompletion()");
	}
	

	/**
	 * 当处理器(Controller)方法已经执行完毕，
	 * 正准备将处理结果(ModelAndView)返回给
	 * DispatcherServlet之前会执行postHandle
	 * 方法。
	 * 注：
	 * 		可以在该方法里面，修改ModelAndView
	 */
	public void postHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1,
			Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle()");
	}

	/**
	 * DispatcherServlet收到请求之后，
	 * 会先调用拦截器的preHandle方法。
	 * 如果该方法的返回值为true,表示继续
	 * 向后调用；如果返回值为false,则
	 * 不再向后调用。
	 *  arg2: 可以通过该对象获得处理器(Controller)
	 *  方法的描述（比如方法名，参数类型等）。
	 */
	public boolean preHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}

}


