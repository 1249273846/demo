package com.yc.orderFood.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.yc.orderFood.bean.Resorder;
import com.yc.orderFood.bean.Resorderitem;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.dao.ResorderitemDao;
import com.yc.orderFood.util.DBHelper;

public class ResorderitemDaoImpl implements ResorderitemDao {

	@Override
	public int insert(Resorderitem t) {
		String sql = "insert into resorderitem(roid,fid,dealprice,num) values(?,?,?,?)";
		return DBHelper.doUpdate(sql, t.getRoid(),t.getFid(),t.getDealprice(),t.getNum());
	}


	@Override
	public int delete(Resorderitem t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Resorderitem t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Resorderitem> select(Resorderitem t, int pages, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resorderitem selectById(Integer id) {
		System.out.println("进来了");
		System.out.println("id="+id);
		String sql = "select * from resorderitem where roid=?";
		List<Resorderitem> list = DBHelper.find(sql, Resorderitem.class, id);
		System.out.println("值为"+list.get(0));
		return list.get(0);
	}

	@Override
	public long count(Resorderitem t) {
		String sql = "select sum(dealprice) total from resorderitem where roid=?";
		List<Map<String, Object>> list = DBHelper.findAll(sql, t.getRoid());
		Object value = list.get(0).get("total");
		int total = ((BigDecimal)value).intValue();
		return total;
	}


	@Override
	public List<Resorderitem> Login(Resorderitem t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resorderitem> selectName(Resorderitem t) {
		String sql = "select * from resorderitem where roid=?";
		return DBHelper.find(sql, Resorderitem.class, t.getRoid());		
	}
}
