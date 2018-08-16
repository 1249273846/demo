package com.yc.orderFood.biz;

import java.util.List;

import com.yc.orderFood.bean.Resorderitem;
import com.yc.orderFood.bean.Resshopcart;

public interface ResorderitemBiz {

	public int insert(Resorderitem t);
	
	public List<Resorderitem> selectName(Resorderitem t);
	
	public long count(Resorderitem t);
	
	public Resorderitem selectById(Integer id);
	
	
}
