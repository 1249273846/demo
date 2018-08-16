package com.yc.orderFood.tag;

import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.yc.orderFood.util.DBHelper;



public class PageTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private long total;
	private int rows;
	private String href;
	private String s;

	@Override
	public int doStartTag() throws JspException {
		// 得到总行数
		String sql = "select count(*) as total from resfood";
		List<Map<String, Object>> list = DBHelper.findAll(sql);
		long total = (long) list.get(0).get("total");
		System.out.println(total);
		// 得到总页数
		long pages = 0;
		if (total % rows == 0) {
			pages = total / rows;
		} else {
			pages = total / rows + 1;
		}
		// 当前页数
		int currentPage = 0;
		// 输出分页连接
		while (currentPage < pages) {
			String pageName = currentPage == 0 ? "首页" : currentPage == pages - 1 ? "尾页" : (currentPage + 1 + "");
			currentPage++;
			s = String.format("<a href='%s&page=%s&rows=%s'>%s </a>", href, currentPage, rows, pageName);
			try {
				pageContext.getOut().println(s);
			} catch (Exception e) {
				new JspException(e);
			}
		}

		return super.doStartTag();
	}

	 public void setTotal(long total) {
	 this.total = total;
	 }
	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
