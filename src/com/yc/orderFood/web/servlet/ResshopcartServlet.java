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
import com.yc.orderFood.biz.ResadminBiz;
import com.yc.orderFood.biz.ResfoodBiz;
import com.yc.orderFood.biz.ResshopcartBiz;
import com.yc.orderFood.biz.ResuserBiz;
import com.yc.orderFood.biz.impl.ResadminBizImpl;
import com.yc.orderFood.biz.impl.ResfoodBizImpl;
import com.yc.orderFood.biz.impl.ResshopcartBizImpl;
import com.yc.orderFood.biz.impl.ResuserBizImpl;
import com.yc.orderFood.util.BeanUtils;
import com.yc.orderFood.util.DBHelper;

@WebServlet("/resshopcart.servlet")
public class ResshopcartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ResfoodBiz RFbiz = new ResfoodBizImpl();
	private ResshopcartBiz SCbiz = new ResshopcartBizImpl();
	private ResuserBiz RUbiz=new ResuserBizImpl();
	
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws
	ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int pageNo = 1;
		int pageSize = 6;
		// 定义用户默认名字和ID
		String username = "a";
		int userid = 1;
		try {
			// 得到会话的username,并存进去
			username = (String) request.getSession().getAttribute("username");
			Resuser u = new Resuser();
			u.setUsername(username);
			// 得到ID
			userid = RUbiz.selectName(u).get(0).getUserid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//操作参数
		String op = request.getParameter("op");
		//将请求参数设施到  实体对象中去
		Resfood resfood = BeanUtils.toBean(request, new Resfood());
		Resuser resuser = BeanUtils.toBean(request, new Resuser());

		if("query".equals(op)){
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
		}else if("find".equals(op)){
			//查询菜品
			request.setAttribute("resfood",RFbiz.findById(resfood.getFid()) );
			//页面跳转
			request.getRequestDispatcher("details.jsp").forward(request, response);
		}else if("shopcart".equals(op)){
			if(username == null || "".equals(username)){
				request.setAttribute("msg10", "暂无法使用订购功能，请先登录");
				request.getRequestDispatcher("resfood.servlet?op=query").forward(request, response);
				return;
			}
			//进行实例化;
			Resfood rf = RFbiz.findById(resfood.getFid());
			Resshopcart t=new Resshopcart();
			System.out.println(request.getSession().getAttribute("username"));
			//查询菜品和用户ID
			if(request.getSession().getAttribute("username")==null){
				request.getRequestDispatcher("resfood.servlet?op=query").forward(request, response);
				return;
			}
			t.setUserid(userid);
			t.setFid(resfood.getFid());
			t.setFname(rf.getFname());
			t.setRealprice(rf.getRealprice());
			//HttpSession session =request.getSession();
			if(SCbiz.insert(t)>0){
				Resfood list = RFbiz.findById(resfood.getFid());
				request.setAttribute("msg3", list.getFname()+"-----添加成功");
				request.getRequestDispatcher("resfood.servlet?op=query").forward(request, response);
			}else{
				request.setAttribute("msg4", "添加失败");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if("check".equals(op)){
			if(username == null || "".equals(username)){
				request.setAttribute("msg11", "暂无法查看购物车，请先登录");
				request.getRequestDispatcher("resfood.servlet?op=query").forward(request, response);
				return;
			}
			Resshopcart t = new Resshopcart();
			t.setUserid(userid);
			List<Resshopcart> list = SCbiz.selectName(t);
			//查询总金额
			if(list.size()>0){
				long sum = SCbiz.count(t);
				request.setAttribute("sum", sum);
			}
			request.setAttribute("resshopcart", list);
			request.getRequestDispatcher("shopCart.jsp").forward(request, response);
		} else if("delete".equals(op)){
			Resshopcart t = new Resshopcart();
			t.setUserid(userid);
			if(SCbiz.delete(t)>0){
			//删除成功
			request.setAttribute("resshopcart", null);
			request.getRequestDispatcher("shopCart.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("shopCart.jsp").forward(request, response);
		}
		}
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
	ServletException, IOException {
		doGet(request, response);
	}
}
