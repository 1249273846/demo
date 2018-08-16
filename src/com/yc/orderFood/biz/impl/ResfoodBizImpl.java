package com.yc.orderFood.biz.impl;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.biz.BizException;
import com.yc.orderFood.biz.ResfoodBiz;
import com.yc.orderFood.dao.ResfoodDao;
import com.yc.orderFood.dao.impl.ResfoodDaoImpl;
import com.yc.orderFood.util.ValidUtils;

/**
 * 菜品管理业务实现类
 * @author Administrator
 *
 */

public class ResfoodBizImpl implements ResfoodBiz{

	private ResfoodDao dao = new ResfoodDaoImpl();
	
	public List<Resfood> find(Resfood resfood, int page, int rows) {
		return dao.select(resfood, page, rows);
	}
	
	public Resfood findById(Integer fid){
		return dao.selectById(fid);
	}

	@Override
	public long count(Resfood t) {
		return dao.count(t);
	}
	
	public List<Resfood> selectName(Resfood t){
		return dao.selectName(t);
	}
	
	//新增菜品
	public long create(Resfood resfood) throws BizException {
		ValidUtils.check(resfood.getFname(), "菜品名称不能为空！");
		ValidUtils.check(resfood.getNormprice(), "菜品价格不能为空！");
		ValidUtils.check(resfood.getFphoto(), "菜品图片不能为空！");
		ValidUtils.check(resfood.getDetail(), "菜品描述不能为空！");
		return dao.insert(resfood);
	}
	
	//修改菜品信息
	public long modify(Resfood resfood) throws BizException {
		ValidUtils.check(resfood.getFid(), "菜品编号不能为空！");
		ValidUtils.check(resfood.getFname(), "菜品名称不能为空！");
		ValidUtils.check(resfood.getNormprice(), "菜品价格不能为空！");
		ValidUtils.check(resfood.getFphoto(), "菜品图片不能为空！");
		ValidUtils.check(resfood.getDetail(), "菜品描述不能为空！");
		return dao.update(resfood);
	}

	//删除菜品
	public long remove(Resfood resfood) throws BizException {
		ValidUtils.check(resfood.getFid(), "菜品编号不能为空！");
		if(dao.isUsed(resfood.getFid())) {
			throw new BizException("该菜品已经有人点过了，不能删除");
		}
		return dao.delete(resfood);
	}
}
