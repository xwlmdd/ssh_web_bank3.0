package com.cx.bank.dao;

import com.cx.bank.model.MoneyBean;

/**
 * 
 * @author 许望禄
 * 持久层接口
 *
 */
public interface MoneyDao {
	/**
	 * 插入数据
	 * @param mb
	 * @return
	 */
	boolean insert(MoneyBean mb);
	
	/**
	 * 通过姓名查询信息
	 * @param name
	 * @return
	 */
	MoneyBean query(String name);
	
	/**
	 * 修改用户信息
	 * @param mb
	 * @return
	 */
	boolean update(MoneyBean mb);
}
