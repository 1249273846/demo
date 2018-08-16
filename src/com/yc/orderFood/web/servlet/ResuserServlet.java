package com.yc.orderFood.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yc.orderFood.bean.Resadmin;
import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resorderitem;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.biz.BizException;
import com.yc.orderFood.biz.ResadminBiz;
import com.yc.orderFood.biz.ResfoodBiz;
import com.yc.orderFood.biz.ResshopcartBiz;
import com.yc.orderFood.biz.ResuserBiz;
import com.yc.orderFood.biz.impl.ResadminBizImpl;
import com.yc.orderFood.biz.impl.ResfoodBizImpl;
import com.yc.orderFood.biz.impl.ResshopcartBizImpl;
import com.yc.orderFood.biz.impl.ResuserBizImpl;
import com.yc.orderFood.util.BeanUtils;
import com.yc.orderFood.vo.Result;

@WebServlet("/resuser.servlet")
public class ResuserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ResfoodBiz RFbiz = new ResfoodBizImpl();
	private ResuserBiz RUbiz=new ResuserBizImpl();
	

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws
	ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int pageNo = 1;
		int pageSize = 6;
		//操作参数
		String op = request.getParameter("op");
		//将请求参数设施到  实体对象中去
		Resfood resfood = BeanUtils.toBean(request, new Resfood());
		Resuser resuser = BeanUtils.toBean(request, new Resuser());

		if ("query".equals(op)){
			// 查询菜品
			query(resfood,request,response);
		} else if("find".equals(op)){
			// 查看菜品详情
			find(resfood,request,response);
		} else if("login".equals(op)){
			// 登录
			login(resuser,request,response);
		} else if("regist".equals(op)){
			// 注册
			regist(resuser,request,response);
		} else if("logout".equals(op)){
			// 注销
			logout(resuser,request,response);
		} else if("finduser".equals(op)){
			// 查询所有用户
			finduser(resuser,request,response);
		}
		
		
		else {
			throw new ServletException("操作类型字段错误: op="+op);
		}
	}

	private void query(Resfood resfood, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 定义分页变量
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int pageNo;
		int pageSize;
		if(request.getParameter("page")==null){
			pageNo=1;
		}else{
				try {
					pageNo = BeanUtils.cast(page, Integer.class);
				} catch (ParseException e) {
					pageNo = 1;
					e.printStackTrace();
				}
		}
		if(request.getParameter("rows")==null){
			pageSize=6;
		}else{
				try {
					pageSize = BeanUtils.cast(rows, Integer.class);
				} catch (ParseException e) {
					pageSize = 6;
					e.printStackTrace();
				}
		}
		
		//判断是否是ajax请求
		if(request.getParameter("ajax") == null){
			//暂时查询所有的记录  将结果设置到请求属性中去
			request.setAttribute("list", RFbiz.find(resfood, pageNo, pageSize));
			//页面跳转
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else{
			//查询结果集
			List<Resfood> list = RFbiz.find(resfood, pageNo,pageSize);
			//查询总行数
			long count = RFbiz.count(resfood);
			//定义分页数据Map
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("rows", list);
			data.put("total", count);
			// 将查询结果转出 jsom 字符串
			Gson gson = new Gson();
			String s = gson.toJson(list);
			// 输出到页面
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(s);
		}
	}

	private void find(Resfood resfood, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询菜品
		request.setAttribute("resfood",RFbiz.findById(resfood.getFid()) );
		//页面跳转
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	private void login(Resuser resuser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//定义用户名和密码来获取网页上的用户名和密码
		String uname = request.getParameter("loginName");
		String pwd = request.getParameter("loginPass");
		//实例化对象
		Resuser user=new Resuser();
		//把uname存进user
		user.setUsername(uname);
		user.setPwd(pwd);
		request.getSession().setAttribute("username", uname);
		//调用
		List<Resuser> list=RUbiz.Login(user);
		// 进行是否插入成功判断
		if(list.size()>0){
			session.setAttribute("resuser", list.get(0));
			request.getRequestDispatcher("resfood.servlet?op=query").forward(request, response);
		}else{
			request.setAttribute("msg", "您输入的用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	private void regist(Resuser resuser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Resuser t=new Resuser();
		//设置变量
		t.setUsername(request.getParameter("RegistName"));
		t.setPwd(request.getParameter("RegistPass"));
		t.setEmail(request.getParameter("RegistEmail"));
		//进行添加是否成功判断
		if(RUbiz.insert(t)>0){
			request.setAttribute("msg1", "已注册成功,请登录");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg2", "注册失败，请检查后重新输入");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
	}

	private void logout(Resuser resuser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将会话对象销毁
		request.getSession().invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void finduser(Resuser resuser, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 定义分页变量
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int pageNo;
		int pageSize;
		if(request.getParameter("page")==null){
			pageNo=1;
		}else{
				try {
					pageNo = BeanUtils.cast(page, Integer.class);
				} catch (ParseException e) {
					pageNo = 1;
					e.printStackTrace();
				}
		}
		if(request.getParameter("rows")==null){
			pageSize=6;
		}else{
				try {
					pageSize = BeanUtils.cast(rows, Integer.class);
				} catch (ParseException e) {
					pageSize = 6;
					e.printStackTrace();
				}
		}
		//查询结果集
		List<Resuser> list = RUbiz.find(resuser, pageNo,pageSize);
		//查询总行数
		long count = RUbiz.count(resuser);
		//定义分页数据Map
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("rows", list);
		data.put("total", count);
		// 将查询结果转出 jsom 字符串
		Gson gson = new Gson();
		String s = gson.toJson(data);
		// 输出到页面
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(s);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
	ServletException, IOException {
		doGet(request, response);
	}
}
