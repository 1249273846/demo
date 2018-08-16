package com.yc.orderFood.biz.impl;

import java.util.List;

import com.yc.orderFood.bean.Resadmin;
import com.yc.orderFood.biz.ResadminBiz;
import com.yc.orderFood.dao.ResadminDao;
import com.yc.orderFood.dao.impl.ResadminDaoImpl;

public class ResadminBizImpl implements ResadminBiz {
	
	private ResadminDao dao = new ResadminDaoImpl();

	@Override
	public List<Resadmin> Login(Resadmin t) {
		return dao.Login(t);
	}
	
	
}
