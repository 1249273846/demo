package com.yc.orderFood.dao;

import com.yc.orderFood.bean.Resfood;

public interface ResfoodDao extends BaseDao<Resfood>{

	public boolean isUsed(Integer fid);

}
