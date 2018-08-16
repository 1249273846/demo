package com.yc.orderFood.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resshopcart;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.dao.ResshopcartDao;
import com.yc.orderFood.util.DBHelper;

public class ResshopcartDaoImpl implements ResshopcartDao {

	@Override
	public int insert(Resshopcart t) {
		List<Object> params = new ArrayList<Object>();
		String sql1 = "select * from resshopcart where fname=? and userid=?";
		List<Map<String, Object>> list = DBHelper.findAll(sql1, t.getFname(),t.getUserid());
		if(list.size() > 0){
			System.out.println("第二次");
			String sql2="update resshopcart set num=num+? , sum=sum+? where"
					+ " fname=?";
			return DBHelper.doUpdate(sql2, 1,t.getRealprice(),t.getFname());
		}
		System.out.println("第一次");
		String sql3 = "insert into resshopcart(fid,userid,fname,realprice,num,sum)"
				+ " values(?,?,?,?,?,?)";
		return DBHelper.doUpdate(sql3,t.getFid(),t.getUserid(),t.getFname(),
				t.getRealprice(),1,t.getRealprice());
	}

	@Override
	public int delete(Resshopcart t) {
		String sql = "delete from resshopcart where userid=?";
		int result = DBHelper.doUpdate(sql, t.getUserid());
		if(result > 0){
			return result;
		}else{
			System.out.println("失败");
			return 0;
		}
	}

	@Override
	public int update(Resshopcart t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Resshopcart> select(Resshopcart t, int pages, int rows) {
		return null;
	}

	@Override
	public Resshopcart selectById(Integer id) {
		return null;
	}

	@Override
	public long count(Resshopcart t) {
		String sql = "select sum(sum) total from resshopcart where userid=?";
		List<Map<String, Object>> list = DBHelper.findAll(sql, t.getUserid());
		Object value = list.get(0).get("total");
		int total = ((BigDecimal)value).intValue();
		return total;
	}

	@Override
	public List<Resshopcart> Login(Resshopcart t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Resshopcart> selectName(Resshopcart t){
		String sql = "select * from resshopcart where userid=?";
		return DBHelper.find(sql, Resshopcart.class, t.getUserid());		
	}
	
}