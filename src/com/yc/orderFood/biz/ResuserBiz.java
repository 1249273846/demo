package com.yc.orderFood.biz;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resuser;

public interface ResuserBiz {
	
	//登录
	public List<Resuser> Login(Resuser t);
	//注册
	public int insert(Resuser t);
	//查用户

	public List<Resuser> find(Resuser t, int pages, int rows);
	
	public List<Resuser> selectName(Resuser t) ;
	
	public Resuser selectById(Integer id);
	
	long count(Resuser t);
	
}