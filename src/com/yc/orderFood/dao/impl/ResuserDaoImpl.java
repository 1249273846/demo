package com.yc.orderFood.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.bean.Resuser;
import com.yc.orderFood.dao.ResuserDao;
import com.yc.orderFood.util.DBHelper;

public class ResuserDaoImpl implements ResuserDao {

	//用户登录
	public List<Resuser> Login(Resuser t) {
		String sql="select * from resuser where username=? and pwd=?";
		List<Resuser> list=DBHelper.find(sql, Resuser.class, t.getUsername(),t.getPwd());
		return list;
	}
	
	//用户注册
	public int insert(Resuser t) {
		String sql="insert into resuser(username,pwd,email) values (?,?,?)";
		return DBHelper.doUpdate(sql,t.getUsername(),t.getPwd(),t.getEmail());
	}

	@Override
	public int delete(Resuser t) {
		String sql = "delete from resuser where userid=?";
		return DBHelper.doUpdate(sql, t.getUserid());
	}

	@Override
	public int update(Resuser t) {
		String sql = "update resuser set ";
		ArrayList<Object> params = new ArrayList<Object>();
		if (t.getUsername() != null){
			sql += " username=?,";
			params.add(t.getUsername());
		}
		if (t.getPwd() != null){
			sql += " pwd=?,";
			params.add(t.getPwd());
		}
		if (t.getEmail() != null){
			sql += " email=?,";
			params.add(t.getEmail());
		}
		// 去掉最后一个逗号(,)
		sql = sql.substring(0, sql.length() -1);
		sql += " where fid=?";
		params.add(t.getUserid());
		return DBHelper.doUpdate(sql, params);
	}

	@Override
	public List<Resuser> select(Resuser t, int pages, int rows) {
		String sql="select * from resuser where 1=1";
		//创建参数集合
		List<Object> params = new ArrayList<Object>();
		// 验证是否为空，以免报错
		if (t != null){
			if(t.getUsername() !=null && t.getUsername().trim().length()>0) {
				params.add(t.getUsername());
				sql +=" and username =?";
			}
			if(t.getPwd() !=null && t.getPwd().trim().length()>0){
				params.add(t.getPwd());
				sql +=" and pwd =?";
			}
			if(t.getEmail() !=null && t.getEmail().trim().length()>0){
				params.add(t.getEmail());
				sql +=" and email =?";
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
		return DBHelper.find(sql, Resuser.class, params);
	}

	@Override
	public Resuser selectById(Integer id) {
		String sql = "select * from resuser where userid = ?";
		 List<Resuser> list = DBHelper.find(sql, Resuser.class, id);
		 if(list.size()>0){
			 return list.get(0);
		 } else {
			 return null;
		 }
	}

	@Override
	public long count(Resuser t) {
		String sql="select count(*) cnt from resuser where 1=1";
		//创建参数集合
		List<Object> params = new ArrayList<Object>();
		// 验证是否为空，以免报错
		if (t != null){
			if(t.getUsername() !=null && t.getUsername().trim().length()>0) {
				params.add(t.getUsername());
				sql +=" and username =?";
			}
			if(t.getPwd() !=null && t.getPwd().trim().length()>0){
				params.add(t.getPwd());
				sql +=" and pwd =?";
			}
			if(t.getEmail() !=null && t.getEmail().trim().length()>0){
				params.add(t.getEmail());
				sql +=" and email =?";
			}
	}
		List<Map<String,Object>> list = DBHelper.findAll(sql, params);
		Object value = list.get(0).get("cnt");
		//将结果转换成  long 类型
		long ret = Long.parseLong("" + value);
		return ret;
	}

	@Override
	public List<Resuser> selectName(Resuser t) {
		String sql = "select *  from resuser where 1=1";
		List<Object> params = new ArrayList<Object>();
		if( t.getUsername()!=null ){
			sql+=" and username=?";
			params.add(t.getUsername());
		}
		if( t.getPwd()!=null ){
			sql+=" and pwd=?";
			params.add(t.getPwd());
		}
		return DBHelper.find(sql, Resuser.class, params);
	}
}
