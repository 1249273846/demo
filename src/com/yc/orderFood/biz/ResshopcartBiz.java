package com.yc.orderFood.biz;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.bean.Resuser;

public interface ResshopcartBiz {
	
	public int insert(Resshopcart t);

	public List<Resshopcart> selectName(Resshopcart t);
	
	public long count(Resshopcart t);
	
	public int delete(Resshopcart t);
	
}