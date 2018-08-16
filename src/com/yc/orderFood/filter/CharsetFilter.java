package com.yc.orderFood.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 1、字符集必须是配置信息
 * 2、该过滤只能过滤动态请求
 * @author Administrator
 *
 */
@WebFilter("/CharsetFilter")
public class CharsetFilter implements Filter {

	private String charset;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String servletPath = ((HttpServletRequest) request).getServletPath();

		if(servletPath.endsWith(".jsp") 
				|| servletPath.endsWith(".servlet")) {
			request.setCharacterEncoding(charset);
			response.setCharacterEncoding(charset);
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("charset");
	}

}
