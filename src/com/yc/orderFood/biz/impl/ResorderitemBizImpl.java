package com.yc.orderFood.biz.impl;

import java.util.List;

import com.yc.orderFood.bean.Resorderitem;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.biz.ResorderitemBiz;
import com.yc.orderFood.dao.ResorderitemDao;
import com.yc.orderFood.dao.impl.ResorderitemDaoImpl;

public class ResorderitemBizImpl implements ResorderitemBiz {

	private ResorderitemDao dao = new ResorderitemDaoImpl();
	
	@Override
	public int insert(Resorderitem t) {
		return dao.insert(t);
	}

	@Override
	public List<Resorderitem> selectName(Resorderitem t) {
		return dao.selectName(t);
	}

	@Override
	public long count(Resorderitem t) {
		return dao.count(t);
	}

	@Override
	public Resorderitem selectById(Integer id) {
		return dao.selectById(id);
	}


}
