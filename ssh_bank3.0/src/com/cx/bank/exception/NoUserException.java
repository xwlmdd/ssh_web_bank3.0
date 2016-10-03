package com.cx.bank.exception;

/**
 * 作用：转账的时候没有对应账户抛出异常
 * @author 许望禄
 *
 */
@SuppressWarnings("serial")
public class NoUserException extends Exception{

	public NoUserException(){
		super();
	}
	
	public NoUserException(String msg){
		super(msg);
	}
}
