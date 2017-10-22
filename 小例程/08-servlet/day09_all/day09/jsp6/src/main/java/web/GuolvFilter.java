package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GuolvFilter implements Filter {

	public void destroy() {
		System.out.println("销毁GuolvFilter");
	}

	public void doFilter(
		ServletRequest req, 
		ServletResponse res, 
		FilterChain chain)
		throws IOException, ServletException {
		System.out.println("过滤敏感词-3");
		chain.doFilter(req, res);
		System.out.println("过滤敏感词-4");
	}

	//tomcat自动管理FilterConfig对象:
	//Filter f = new GuolvFilter();
	//FilterConfig c = new FilterConfig();
	//f.init(c);
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("初始化GuolvFilter");
		String words = 
			cfg.getInitParameter("words");
		System.out.println(words);
	}

}





