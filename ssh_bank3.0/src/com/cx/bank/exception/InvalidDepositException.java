package com.cx.bank.exception;

/**
 * 作用：存款为负数时抛出异常
 * @author 许望禄
 *
 */
@SuppressWarnings("serial")
public class InvalidDepositException extends Exception  {
	
	public InvalidDepositException(){
		super();
	}
	
	public InvalidDepositException(String msg){
		super(msg);
	}
}

