package com.yc.orderFood.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 权限访问控制的过滤器，为了正确加载初始化参数，注意下面的注解必须去掉
 */
//@WebFilter("*.jsp")
public class LoginFilter implements Filter {

	//排除权限访问控制的数组，在该数组中的资源部受权限访问控制
	private String[] withoutUrls;

	public void destroy() {
	}

	/**
	 * request 请求
	 * response 响应
	 * FilterChain 过滤器链
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//先将请求对象转换成 HttpServletRequest ，然后获取会话
		HttpSession session = ((HttpServletRequest) request).getSession();
		//获取访问的资源名
		String servletPath = ((HttpServletRequest) request).getServletPath();

		/**
		 * 作业，请使用withoutUrls来判断 例外页面
		 */
		//如果不是访问 login.jsp 那么就要进行权限判断
		if (canOpen(servletPath) == false) {
			if (session.getAttribute("user") == null) {
				session.setAttribute("msg", "请先登录系统");
				((HttpServletResponse) response).sendRedirect("login.jsp");
				return;
			}
		}
		// 过滤器链的 过滤方法，确保后续过滤器的执行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//获取初始化参数
		String withoutUrl = fConfig.getInitParameter("withoutUrl");
		if (withoutUrl != null) {
			//分裂数组
			withoutUrls = withoutUrl.split(",");
		}
	}

	private boolean canOpen(String path) {
		if (withoutUrls == null)
			return true;

		for (String url : withoutUrls) {
			if (path.endsWith(url)) {
				return true;
			}
		}
		return false;
	}

}
