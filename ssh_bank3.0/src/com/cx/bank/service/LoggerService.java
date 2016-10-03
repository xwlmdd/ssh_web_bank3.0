package com.cx.bank.service;

import com.cx.bank.model.Log;

public interface LoggerService {

	void createLogTable(String tableName);
	
	void saveLogger(Log log);
}
