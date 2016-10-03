package com.cx.bank.model;

import org.apache.struts.action.ActionForm;

/**
 * 接收表单数据的actionform
 * @author 许望禄
 *
 */
public class MoneyActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;//账户
	private String password;//密码
	private double money;//账户余额

	public MoneyActionForm(){
		
	}
	

	public MoneyActionForm(String userName, String password, double money) {
		this.userName = userName;
		this.password = password;
		this.money = money;
	}


	@Override
	public String toString() {
		return "MoneyBean [userName=" + userName + ", password=" + password
				+ ", money=" + money + "]";
		
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {

		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
