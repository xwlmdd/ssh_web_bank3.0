package com.cx.bank.exception;

/**
 * 作用：存款为负数时抛出异常
 * @author 许望禄
 *
 */
@SuppressWarnings("serial")
public class InvalidTransferException extends Exception  {
	
	public InvalidTransferException(){
		super();
	}
	
	public InvalidTransferException(String msg){
		super(msg);
	}
}

