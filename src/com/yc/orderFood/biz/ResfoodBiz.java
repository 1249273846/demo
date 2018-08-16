package com.yc.orderFood.biz;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resuser;

public interface ResfoodBiz {
	
	//定义菜品管理查询方法
	public List<Resfood> find(Resfood resfood,int page,int rows);
	
	public Resfood findById(Integer fid);
	
	public long count(Resfood t);

	long create(Resfood resfood) throws BizException;

	long modify(Resfood resfood) throws BizException;
	
	long remove(Resfood resfood) throws BizException;
	
	public List<Resfood> selectName(Resfood t);
	
}
