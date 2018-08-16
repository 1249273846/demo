package com.yc.orderFood.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.orderFood.bean.Resorder;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.dao.ResorderDao;
import com.yc.orderFood.util.DBHelper;

public class ResorderDaoImpl implements ResorderDao {

	@Override
	public int insert(Resorder t) {
		String sql = "insert into resorder(userid,address,tel,ordertime,deliverytime,ps,status)"
				+ " values(?,?,?,now(),now(),?,?)";
		int result =  DBHelper.doInsert(sql, t.getUserid(),t.getAddress(),t.getTel(),t.getPs(),t.getStatus());
		System.out.println("roid:"+ result);
		return result;
	}

	@Override
	public int delete(Resorder t) {
		String sql = "delete from resorder where roid=?";
		return DBHelper.doUpdate(sql, t.getRoid());
	}

	@Override
	public int update(Resorder t) {
		String sql = "update resorder set ";
		ArrayList<Object> params = new ArrayList<Object>();
		if (t.getAddress() != null){
			sql += " address=?,";
			params.add(t.getAddress());
		}
		if (t.getTel() != null){
			sql += " tel=?,";
			params.add(t.getTel());
		}
		if (t.getDeliverytime() != null){
			sql += " deliverytime=?,";
			params.add(t.getDeliverytime());
		}
		if (t.getPs() != null){
			sql += " ps=?,";
			params.add(t.getPs());
		}
		if (t.getStatus() != null){
			sql += " status=?,";
			params.add(t.getStatus());
		}
		// 去掉最后一个逗号(,)
		sql = sql.substring(0, sql.length() -1);
		sql += " where fid=?";
		params.add(t.getRoid());
		return DBHelper.doUpdate(sql, params);
	}

	@Override
	public List<Resorder> select(Resorder t, int pages, int rows) {
		String sql="select * from resorder where 1=1";
		//创建参数集合
		List<Object> params = new ArrayList<Object>();
		// 验证是否为空，以免报错
		if (t != null){
			if(t.getUserid() !=null ) {
				params.add(t.getUserid());
				sql +=" and userid =?";
			}
			if(t.getAddress() !=null && t.getAddress().trim().length()>0){
				params.add(t.getAddress());
				sql +=" and address =?";
			}
			if(t.getTel() !=null && t.getTel().trim().length()>0){
				params.add(t.getTel());
				sql +=" and tel =?";
			}
			if(t.getDeliverytime() !=null ) {
				params.add(t.getDeliverytime());
				sql +=" and deliverytime =?";
			}
			if(t.getPs() !=null && t.getPs().trim().length()>0){
				params.add(t.getPs());
				sql +=" and ps =?";
			}
			if(t.getStatus() !=null){
				params.add(t.getStatus());
				sql +=" and status =?";
			}
	}
		// 计算分页参数，偏移量
		int offset = (pages - 1) * rows;
		//设置分页参数
		sql += " limit ?,?";
		//pages  ==>   pageNo
		//rows   ==>   pageSize
		params.add(offset);
		params.add(rows);
		return DBHelper.find(sql, Resorder.class, params);
	}

	@Override
	public Resorder selectById(Integer id) {
		String sql = "select * from resorder where roid=?";
		List<Resorder> list = DBHelper.find(sql, Resorder.class, id);
		return list.get(0);
	}

	@Override
	public long count(Resorder t) {
		String sql="select count(*) cnt from resorder where 1=1";
		//创建参数集合
		List<Object> params = new ArrayList<Object>();
		// 验证是否为空，以免报错
		if (t != null){
			if(t.getUserid() !=null ) {
				params.add(t.getUserid());
				sql +=" and userid =?";
			}
			if(t.getAddress() !=null && t.getAddress().trim().length()>0){
				params.add(t.getAddress());
				sql +=" and address =?";
			}
			if(t.getTel() !=null && t.getTel().trim().length()>0){
				params.add(t.getTel());
				sql +=" and tel =?";
			}
			if(t.getDeliverytime() !=null ) {
				params.add(t.getDeliverytime());
				sql +=" and deliverytime =?";
			}
			if(t.getPs() !=null && t.getPs().trim().length()>0){
				params.add(t.getPs());
				sql +=" and ps =?";
			}
			if(t.getStatus() !=null){
				params.add(t.getStatus());
				sql +=" and status =?";
			}
	}
		List<Map<String,Object>> list = DBHelper.findAll(sql, params);
		Object value = list.get(0).get("cnt");
		//将结果转换成  long 类型
		long ret = Long.parseLong("" + value);
		return ret;
	}

	@Override
	public List<Resorder> Login(Resorder t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resorder> selectName(Resorder t) {
		String sql = "select * from resorder where 1=1";
		return DBHelper.find(sql, Resorder.class, t);
	}

	@Override
	public boolean isUsed(Integer roid) {
		String sql = "select count(*) cnt from resorder where roid=?";
		long count = (long) DBHelper.findAll(sql, roid).get(0).get("cnt");
		return count > 0;
	}

}
