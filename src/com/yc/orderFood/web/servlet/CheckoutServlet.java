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
import com.yc.orderFood.bean.Resorder;
import com.yc.orderFood.bean.Resorderitem;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.biz.BizException;
import com.yc.orderFood.biz.ResadminBiz;
import com.yc.orderFood.biz.ResfoodBiz;
import com.yc.orderFood.biz.ResorderBiz;
import com.yc.orderFood.biz.ResorderitemBiz;
import com.yc.orderFood.biz.ResshopcartBiz;
import com.yc.orderFood.biz.ResuserBiz;
import com.yc.orderFood.biz.impl.ResadminBizImpl;
import com.yc.orderFood.biz.impl.ResfoodBizImpl;
import com.yc.orderFood.biz.impl.ResorderBizImpl;
import com.yc.orderFood.biz.impl.ResorderitemBizImpl;
import com.yc.orderFood.biz.impl.ResshopcartBizImpl;
import com.yc.orderFood.biz.impl.ResuserBizImpl;
import com.yc.orderFood.util.BeanUtils;
import com.yc.orderFood.vo.Result;

@WebServlet("/checkout.servlet")
public class CheckoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ResfoodBiz RFbiz = new ResfoodBizImpl();
	private ResuserBiz RUbiz=new ResuserBizImpl();
	private ResorderBiz RObiz= new ResorderBizImpl();
	private ResshopcartBiz RSCbiz = new ResshopcartBizImpl();
	private ResorderitemBiz ROIbiz= new ResorderitemBizImpl();
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws
	ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//操作参数
		String op = request.getParameter("op");
		//将请求参数设施到  实体对象中去
		Resfood resfood = BeanUtils.toBean(request, new Resfood());
		Resuser resuser = BeanUtils.toBean(request, new Resuser());
		Resorder resorder = BeanUtils.toBean(request, new Resorder());
		Resorderitem resorderitem = BeanUtils.toBean(request, new Resorderitem());
		
		if ("query".equals(op)){
			// 查询菜品
			query(resfood,request,response);
		} else if("find".equals(op)){
			// 查看菜品详情
			find(resfood,request,response);
		}else if("del".equals(op)){
			// 删除菜品
			del(resorder,request,response);
		} else if("mod".equals(op)){
			// 修改菜品
			mod(resorder,request,response);
		}else if("order".equals(op)){
			order(resorder,request,response);
		}else if("findorder".equals(op)){
			findorder(resorder,request,response);
		}else {
			throw new ServletException("操作类型字段错误: op="+op);
		}
	}
	private void query(Resfood resfood, 
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
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
		String s = gson.toJson(data);
		// 输出到页面
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(s);
	}
		}
	private void find(Resfood resfood,
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		//查询菜品
		request.setAttribute("resfood",RFbiz.findById(resfood.getFid()) );
		//页面跳转
		request.getRequestDispatcher("details.jsp").forward(request, response);
		}
	// 删除
	private void del(Resorder resorder, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String data;
		try {
			RObiz.remove(resorder);
			data = toJson(Result.getSuccess("订单删除成功"));
		} catch (BizException e) {
			e.printStackTrace();
			data = toJson(Result.getFailure(e.getMessage()));
		}
		response.setContentType("text/html);charset=utf-8");
		response.getWriter().print(data);
		}
	// 修改
	private void mod(Resorder resorder, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String data;
		try {
			RObiz.modify(resorder);
			data = toJson(Result.getSuccess("订单修改成功"));
		} catch (BizException e) {
			e.printStackTrace();
			data = toJson(Result.getFailure(e.getMessage()));
		}
		response.setContentType("text/html);charset=utf-8");
		response.getWriter().print(data);	
		}
	// 下单
	private void order(Resorder resorder, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "a";
		int userid = 1;
		try {
			username = (String) request.getSession().getAttribute("username");
			Resuser u = new Resuser();
			u.setUsername(username);
			userid = RUbiz.selectName(u).get(0).getUserid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Resorder t = new Resorder();
		t.setUserid(userid);
		t.setAddress(resorder.getAddress());
		t.setTel(resorder.getTel());
		t.setPs(resorder.getPs());
		t.setStatus(resorder.getStatus());
		int result = RObiz.insert(t);
		//判断是否插入成功
		if( result > 0 ){
			Resshopcart sc = new Resshopcart();
			sc.setUserid(userid);
			List<Resshopcart> list = RSCbiz.selectName(sc);
			for(int i = 0; i < list.size(); i++){
				Resorderitem item = new Resorderitem();
				item.setRoid(result);
				item.setFid(list.get(i).getFid());
				item.setDealprice(list.get(i).getRealprice());
				item.setNum(list.get(i).getNum());
				ROIbiz.insert(item);
			}
			request.getRequestDispatcher("seeYou.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("resshopcart.servlet?op=shopcart").forward(request, response);
		}
			
		}
	// 查询所有订单
	private void findorder(Resorder resorder, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		List<Resorder> list = RObiz.find(resorder, pageNo,pageSize);
		//查询总行数
		long count = RObiz.count(resorder);
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
	
	private String toJson(Result data) {
		return new Gson().toJson(data);
	}
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws
		ServletException, IOException {
			doGet(request, response);
		}
}
