package com.yc.orderFood.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.orderFood.bean.Resfood;
import com.yc.orderFood.biz.ResfoodBiz;
import com.yc.orderFood.dao.ResfoodDao;
import com.yc.orderFood.util.DBHelper;

public class ResfoodDaoImpl implements ResfoodDao {

	/**
	 * 菜品管理的Dao类，继承菜品管理Dao接口
	 */
	public int insert(Resfood t) {
		String sql = "insert into resfood (fname,normprice,realprice,detail,fphoto)" + "values (?,?,?,?,?)";
		//只要保存文件名就可以了，所以去掉文件名前面的路径
		if(t.getFphoto()==null) {
			t.setFphoto("noimg.gif");
		} else {
			t.setFphoto(t.getFphoto().substring(t.getFphoto().lastIndexOf("/") + 1));
		}
		return DBHelper.doUpdate(sql, t.getFname(),t.getNormprice(),t.getRealprice(),t.getDetail(),t.getFphoto());
	}

	@Override
	public int delete(Resfood t) {
		String sql = "delete from resfood where fid=?";
		return DBHelper.doUpdate(sql, t.getFid());
	}

	@Override
	public int update(Resfood t) {
		String sql = "update resfood set ";
		ArrayList<Object> params = new ArrayList<Object>();
		if (t.getFname() != null){
			sql += " fname=?,";
			params.add(t.getFname());
		}
		if (t.getRealprice() != null){
			sql += " realprice=?,";
			params.add(t.getRealprice());
		}
		if (t.getDetail() != null){
			sql += " detail=?,";
			params.add(t.getDetail());
		}
		if (t.getFphoto() != null){
			// 只要保存文件名就可以了，所有去掉文件名前面的路径
			t.setFphoto(t.getFphoto().substring(t.getFphoto().lastIndexOf("/") + 1));
			sql += " fphoto=?,";
			params.add(t.getFphoto());
		}
		// 去掉最后一个逗号(,)
		sql = sql.substring(0, sql.length() -1);
		sql += " where fid=?";
		params.add(t.getFid());
		return DBHelper.doUpdate(sql, params);
	}

	/**
	 * 菜品分页查询列表
	 */
	public List<Resfood> select(Resfood t, int pages, int rows) {
		String sql="select * from resfood where 1=1";
		//创建参数集合
		List<Object> params = new ArrayList<Object>();
		// 验证是否为空，以免报错
		if (t != null){
			// 判断菜品名
			if(t.getFname() !=null && t.getFname().trim().length()>0) {
				params.add(t.getFname());
				sql +=" and fname =?";
			}
			// 判断菜品描述
			if(t.getDetail() !=null && t.getDetail().trim().length()>0){
				params.add(t.getDetail());
				sql +=" and detail =?";
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
		return DBHelper.find(sql, Resfood.class, params);
	}
	
	/**
	 * 菜品查询菜品id信息
	 */
	public Resfood selectById(Integer id) {
		String sql = "select * from resfood where fid = ?";
		 List<Resfood> list = DBHelper.find(sql, Resfood.class, id);
		 if(list.size()>0){
			 return list.get(0);
		 } else {
			 return null;
		 }
	}

	/**
	 * 查询总数
	 */
	public long count(Resfood t) {
		String sql="select count(*) cnt from resfood where 1=1";
		//创建参数集合
		List<Object> params = new ArrayList<Object>();
		// 验证是否为空，以免报错
		if (t != null){
			//判断菜品名
			if(t.getFname() !=null && t.getFname().trim().length() > 0) {
				params.add(t.getFname());
				sql +=" and fname =?";
			}
			//判断菜品描述
			if(t.getDetail() !=null && t.getDetail().trim().length() > 0){
				params.add(t.getDetail());
				sql +=" and detail =?";
			}
	}
		List<Map<String,Object>> list = DBHelper.findAll(sql, params);
		Object value = list.get(0).get("cnt");
		//将结果转换成  long 类型
		long ret = Long.parseLong("" + value);
		return ret;
	}


	
	public List<Resfood> Login(Resfood t) {
		
		return null;
	}
	
	public static void main(String[] args) {
		ResfoodDao dao = new ResfoodDaoImpl();
		System.out.println(dao.select(null, 1, 5));
		System.out.println(dao.select(null, 2, 5));
		System.out.println(dao.select(null, 3, 5));
		System.out.println(dao.count(null));
	}

	@Override
	public List<Resfood> selectName(Resfood t) {
		String sql = "select fname from resfood where fid=?";
		List<Resfood> list = DBHelper.find(sql,Resfood.class, t);
		return list;
	}

	@Override
	public boolean isUsed(Integer fid) {
		String sql = "select count(*) cnt from resorderitem where fid=?";
		long count = (long) DBHelper.findAll(sql, fid).get(0).get("cnt");
		return count > 0;
	}
}
