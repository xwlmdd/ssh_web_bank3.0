package com.cx.bank.exception;

/**
 * 作用：取款超出余额时抛出异常
 * @author 许望禄
 *
 */
@SuppressWarnings("serial")
public class AccountOverDrawnException extends Exception{

	public AccountOverDrawnException(){
		super();
	}
	
	public AccountOverDrawnException(String msg){
		super(msg);
	}
}
