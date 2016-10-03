package com.cx.bank.service;
import com.cx.bank.exception.InvalidDepositException;
import com.cx.bank.exception.InvalidTransferException;
import com.cx.bank.exception.IsRegisterException;
import com.cx.bank.exception.NoUserException;
import com.cx.bank.model.MoneyBean;

/**
 * @date 2016.6.21
 * @author 许望禄 业务类接口
 */
public interface ManagerInterface {
	/**
	 * 用户注册
	 * @return
	 * @throws IsRegisterException 
	 */
	boolean register(MoneyBean moneyBean) throws IsRegisterException;
	
	/**
	 * 用户登入
	 * @return
	 * @throws NoUserException 
	 */
	boolean login(MoneyBean moneyBean) throws NoUserException;
	/**
	 * 存款
	 * @param money
	 * @return
	 * @throws InvalidDepositException 
	 */
	boolean deposit(MoneyBean moneyBean) throws  InvalidDepositException;
	
	/**
	 * 取款
	 * @param money
	 * @return
	 * @throws InvalidDepositException 
	 */
	boolean withdrawals(MoneyBean moneyBean) throws InvalidDepositException;
	
	/**
	 * 查询
	 * @return
	 */
	double inquiry(String username);
	
	/**
	 * 转账
	 * @param zhuanMoney
	 * @param toUserName 转向的账户名
	 * @param toUserName
	 * @return
	 * @throws InvalidTransferException 
	 * @throws NoUserException 
	 */
	boolean transfer(String username,double zhuanMoney, String toUserName) throws InvalidTransferException, NoUserException;

	boolean checkIsExistToUser(String username);
	
}
