package com.cx.bank.exception;

/**
 * 作用：注册时，用户名存在是抛出异常
 * @author 许望禄
 *
 */
@SuppressWarnings("serial")
public class IsRegisterException extends Exception{

	public IsRegisterException(){
		super();
	}
	
	public IsRegisterException(String msg){
		super(msg);
	}
}
