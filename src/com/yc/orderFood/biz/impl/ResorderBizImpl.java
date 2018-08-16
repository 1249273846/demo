package com.yc.orderFood.biz.impl;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resorder;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.biz.BizException;
import com.yc.orderFood.biz.ResorderBiz;
import com.yc.orderFood.dao.ResorderDao;
import com.yc.orderFood.dao.impl.ResorderDaoImpl;
import com.yc.orderFood.util.ValidUtils;

public class ResorderBizImpl implements ResorderBiz {

	private ResorderDao dao = new ResorderDaoImpl();
	
	@Override
	public int insert(Resorder t) {
		return dao.insert(t);
	}

	@Override
	public Resorder selectById(Integer id) {
		return dao.selectById(id);
	}

	public List<Resorder> selectName(Resorder t){
		return dao.selectName(t);
	}

	@Override
	public List<Resorder> find(Resorder t, int pageNo, int pageSize) {
		return dao.select(t, pageNo, pageSize);
	}

	@Override
	public long count(Resorder t) {
		return dao.count(t);
	}
	
	//修改订餐信息
	public long modify(Resorder resorder) throws BizException {
		ValidUtils.check(resorder.getRoid(), "订单编号不能为空！");
		ValidUtils.check(resorder.getAddress(), "用户地址不能为空！");
		ValidUtils.check(resorder.getTel(), "用户电话不能为空！");
		ValidUtils.check(resorder.getDeliverytime(), "配送时间不能为空！");
		ValidUtils.check(resorder.getPs(), "送餐方式不能为空！");
		ValidUtils.check(resorder.getStatus(), "订单状态不能为空！");
		return dao.update(resorder);
	}

	//删除订餐
	public long remove(Resorder resorder) throws BizException {
		ValidUtils.check(resorder.getRoid(), "订单品编号不能为空！");
		if(dao.isUsed(resorder.getRoid())) {
			throw new BizException("该订餐已经接单了，不能删除");
		}
		return dao.delete(resorder);
	}
}
