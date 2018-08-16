package com.yc.orderFood.biz;

import java.util.List;

import com.yc.orderFood.bean.Resadmin;
import com.yc.orderFood.bean.Resuser;

public interface ResadminBiz {

	//登录
	public List<Resadmin> Login(Resadmin t);
	
}
