package com.yc.orderFood.biz.impl;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.biz.ResshopcartBiz;
import com.yc.orderFood.dao.ResfoodDao;
import com.yc.orderFood.dao.ResshopcartDao;
import com.yc.orderFood.dao.ResuserDao;
import com.yc.orderFood.dao.impl.ResfoodDaoImpl;
import com.yc.orderFood.dao.impl.ResshopcartDaoImpl;
import com.yc.orderFood.dao.impl.ResuserDaoImpl;

public class ResshopcartBizImpl implements ResshopcartBiz {
	
	private ResshopcartDao dao = new ResshopcartDaoImpl();
	
	@Override
	public int insert(Resshopcart t) {
		return dao.insert(t);
	}

	@Override
	public List<Resshopcart> selectName(Resshopcart t) {
		return dao.selectName(t);
	}

	@Override
	public long count(Resshopcart t) {
		return dao.count(t);
	}

	@Override
	public int delete(Resshopcart t) {
		return dao.delete(t);
	}
	
}
