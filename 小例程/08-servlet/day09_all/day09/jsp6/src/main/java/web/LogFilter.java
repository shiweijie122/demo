package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	public void destroy() {
		System.out.println("销毁LogFilter");
	}

	public void doFilter(
		ServletRequest req, 
		ServletResponse res, 
		FilterChain chain)
		throws IOException, ServletException {
		System.out.println("记录日志-1");
		chain.doFilter(req, res);
		System.out.println("记录日志-2");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化LogFilter");
	}

}
