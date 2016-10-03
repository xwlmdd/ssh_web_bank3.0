package com.cx.bank.model;


/**
 * @author 许望禄
 * @date 2016.6.21 账户余额结果bean
 */
public class MoneyBean{
	private int id;
	private String userName;//账户
	private String password;//密码
	private double money;//账户余额

	public MoneyBean(){
		
	}
	

	public MoneyBean(String userName, String password, double money) {
		this.userName = userName;
		this.password = password;
		this.money = money;
	}


	

	@Override
	public String toString() {
		return "MoneyBean [id=" + id + ", userName=" + userName + ", password="
				+ password + ", money=" + money + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
