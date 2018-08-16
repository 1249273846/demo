package com.yc.orderFood.dao;

import java.util.List;

import com.yc.orderFood.bean.Resshopcart;

/**
 * 泛型 的  Dao 类，是其他dao接口的父接口
 * 
 */

import com.yc.orderFood.bean.Resuser;

public interface BaseDao <T>{

	public int insert(T t);
	
	public int delete(T t);
	
	public int update(T t);
	
	public List<T> select(T t,int pages,int rows);
	
	public T selectById(Integer id);
	
	public long count(T t);
	
	public List<T> Login(T t);
	
	public List<T> selectName(T t);
	
}