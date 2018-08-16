package com.yc.orderFood.dao;

import com.yc.orderFood.bean.Resorder;

public interface ResorderDao extends BaseDao<Resorder>{

	boolean isUsed(Integer roid);

}
