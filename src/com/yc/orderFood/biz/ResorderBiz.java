package com.yc.orderFood.biz;

import java.util.List;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resorder;
import com.yc.orderFood.bean.Resuser;

public interface ResorderBiz {
	
	public int insert(Resorder t);
	
	public Resorder selectById(Integer id);
	
	public List<Resorder> selectName(Resorder t);

	List<Resorder> find(Resorder t, int pageNo, int pageSize);

	public long count(Resorder t);
	
	long modify(Resorder resorder) throws BizException;
	
	long remove(Resorder resorder) throws BizException;

}
