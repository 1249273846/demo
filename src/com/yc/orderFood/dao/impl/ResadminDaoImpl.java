package com.yc.orderFood.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.orderFood.bean.Resadmin;
import com.yc.orderFood.dao.ResadminDao;
import com.yc.orderFood.util.DBHelper;

public class ResadminDaoImpl implements ResadminDao {

	@Override
	public int insert(Resadmin t) {
		return 0;
	}

	@Override
	public int delete(Resadmin t) {
		return 0;
	}

	@Override
	public int update(Resadmin t) {
		return 0;
	}

	@Override
	public List<Resadmin> select(Resadmin t, int pages, int rows) {
		return null;
		
	}

	@Override
	public Resadmin selectById(Integer id) {
			return null;
	}

	@Override
	public long count(Resadmin t) {
		return 0;
	}

	@Override
	public List<Resadmin> Login(Resadmin t) {
		String sql = "select * from resadmin where raname=? and rapwd=?";
		List<Resadmin> list = DBHelper.find(sql, Resadmin.class, t.getRaname(),t.getRapwd());
		return list;
	}

	@Override
	public List<Resadmin> selectName(Resadmin t) {
		// TODO Auto-generated method stub
		return null;
	}

}
