package com.yc.orderFood.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.orderFood.bean.Resadmin;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.biz.ResadminBiz;
import com.yc.orderFood.biz.impl.ResadminBizImpl;

/**
 * Servlet implementation class ResadminServlet
 */
@WebServlet("/resadmin.servlet")
public class ResadminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ResadminBiz RAbiz= new ResadminBizImpl();   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//定义用户名和密码来获取网页上的用户名和密码
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		//实例化对象
		Resadmin admin=new Resadmin();
		//把uname存进user
		admin.setRaname(name);
		admin.setRapwd(pwd);
		request.getSession().setAttribute("raname", name);
		//调用
		List<Resadmin> list=RAbiz.Login(admin);
		if(list.size()>0){
			session.setAttribute("admin", list.get(0));
			request.getRequestDispatcher("/back/manage.jsp").forward(request, response);
		}else{
			response.setHeader("refresh", "5;URL=index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
