package com.cx.bank.advice;


import org.aspectj.lang.ProceedingJoinPoint;

import com.cx.bank.model.Log;
import com.cx.bank.service.LoggerService;

public class Logger {
	private LoggerService LoggerServiceImpl;

	public LoggerService getLoggerServiceImpl() {
		return LoggerServiceImpl;
	}

	public void setLoggerServiceImpl(LoggerService loggerServiceImpl) {
		LoggerServiceImpl = loggerServiceImpl;
	}

	/**
	 * 环绕通知
	 * 
	 * @param pjp
	 * @return
	 */
	public Object record(ProceedingJoinPoint pjp) {
		Log log = new Log();
		try {
			// 操作名称
			String mname = pjp.getSignature().getName();
			log.setOperName(mname);
			// 操作参数
			Object[] params = pjp.getArgs();
			// log.setOperParams(params[0]);
			// 调用目标对象的方法
			Object ret = pjp.proceed();
			// 设置操作结果
			log.setOperResult("success");
			// 设置结果消息
			if (ret != null) {
				log.setResultMsg(ret.toString());
			}
			return ret;
		} catch (Throwable e) {
			log.setOperResult("failure");
			log.setResultMsg(e.getMessage());
		} finally {
			LoggerServiceImpl.saveLogger(log);
		}
		return null;

	}
}
