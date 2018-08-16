package com.yc.orderFood.biz.impl;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.biz.BizException;
import com.yc.orderFood.biz.ResuserBiz;
import com.yc.orderFood.dao.ResuserDao;
import com.yc.orderFood.dao.impl.ResuserDaoImpl;
import com.yc.orderFood.util.ValidUtils;

public class ResuserBizImpl implements ResuserBiz {
	private ResuserDao dao=new ResuserDaoImpl();
	//登录
	public List<Resuser> Login(Resuser t) {
		return dao.Login(t);
	}
	//注册
	public int insert(Resuser t) {
		return dao.insert(t);
	}
	//查用户
	public List<Resuser> find(Resuser resuser) {
		return dao.Login(resuser);
	}
	@Override
	public List<Resuser> selectName(Resuser t) {
		return dao.selectName(t);
	}
	
	public Resuser selectById(Integer id){
		return dao.selectById(id);
	}
	
	public List<Resuser> find(Resuser t, int pages, int rows){
		return 	dao.select(t, pages, rows);

	}
	@Override
	public long count(Resuser t) {
		return dao.count(t);
	}
}