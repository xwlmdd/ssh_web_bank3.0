package com.cx.bank.service;

import com.cx.bank.dao.MoneyDao;
import com.cx.bank.exception.InvalidDepositException;
import com.cx.bank.exception.InvalidTransferException;
import com.cx.bank.exception.IsRegisterException;
import com.cx.bank.exception.NoUserException;
import com.cx.bank.model.MoneyBean;

/**
 * ManagerImpl业务层实现
 * 
 * @author 许望禄
 * 
 */

public class ManagerImpl  implements ManagerInterface{
	
	private MoneyDao moneyDaoImpl;
	
	public void setMoneyDaoImpl(MoneyDao moneyDaoImpl) {
		this.moneyDaoImpl = moneyDaoImpl;
	}

	public MoneyDao getMoneyDaoImpl() {
		return moneyDaoImpl;
	}

	/**
	 * 检查是否存在此用户
	 * @param username
	 * @return
	 */
	public boolean checkIsExistToUser(String username){
		MoneyBean mb = moneyDaoImpl.query(username);
		if(mb==null){
			System.out.println("不存在");
			return false;
		}
		return true;
	}

	/**
	 * 登入
	 */
	public boolean login(MoneyBean moneyBean) throws NoUserException {
		String name = moneyBean.getUserName();
		MoneyBean mb = moneyDaoImpl.query(name);
		if (mb == null) {
			throw new NoUserException("你没有注册，请重新注册");
		}
		String pass = mb.getPassword();
		if (!pass.equals(moneyBean.getPassword())) {
			return false;
		}
		return true;
	}

	/**
	 * 注册
	 */
	public boolean register(MoneyBean moneyBean) throws IsRegisterException {
		String name = moneyBean.getUserName();
		MoneyBean mb = moneyDaoImpl.query(name);
		if (mb != null) {
			throw new IsRegisterException("该用户名已注册！请重新注册");
		}
		boolean result = moneyDaoImpl.insert(moneyBean);
		return result;
	}
	
	public static void main(String[] args) throws IsRegisterException {
		ManagerImpl mi  = new ManagerImpl();
		MoneyBean mb = new MoneyBean();
		mb.setMoney(0);
		mb.setPassword("111");
		mb.setUserName("xwl");
		mi.register(mb);
	}

	// 存钱方法
	public boolean deposit(MoneyBean moneyBean) throws InvalidDepositException {
		if (moneyBean.getMoney() <= 0) {
			throw new InvalidDepositException("你的存款为负数！请重新输入！");
		}
		boolean result = moneyDaoImpl.update(moneyBean);
		return result;
	}

	// 取款
	public boolean withdrawals(MoneyBean moneyBean)
			throws InvalidDepositException {
		MoneyBean mb = moneyDaoImpl.query(moneyBean.getUserName());
		if (moneyBean.getMoney() <= 0) {
			throw new InvalidDepositException("你的取款为负数！请重新输入！");
		}

		if (mb.getMoney() < moneyBean.getMoney()) {
			throw new InvalidDepositException("你余额不够！请重新输入！");
		}
		boolean result = moneyDaoImpl.update(moneyBean);
		System.out.println(result);
		return result;
	}

	// 查询余额
	public double inquiry(String username) {
		MoneyBean mb = moneyDaoImpl.query(username);
		return mb.getMoney();
	}

	// 转账
	public boolean transfer(String username,double zhuanMoney, String toUserName)
			throws InvalidTransferException, NoUserException {
		MoneyBean mb = moneyDaoImpl.query(username);
		MoneyBean toUserMb = moneyDaoImpl.query(toUserName);
		if (zhuanMoney<= 0) {
			throw new InvalidTransferException("你的转账为负数！请重新输入！");
		}
		
		if(mb.getMoney()<zhuanMoney){
			throw new InvalidTransferException("你的余额不足！请重新输入！");
		}
		
		if(toUserMb==null){
			throw new NoUserException("你要转的转户不存在！");
		}
		
		mb.setMoney(mb.getMoney()-zhuanMoney);
		moneyDaoImpl.update(mb);
		
		toUserMb.setMoney(toUserMb.getMoney()+zhuanMoney);
		moneyDaoImpl.update(toUserMb);
		
		return true;
	}
}
