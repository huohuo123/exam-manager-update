package com.exam.api.jdbc;

import org.beetl.sql.ext.DebugInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:HuoYaJing
 * @Description:sql 执行日志
 * @Date: Create in 16:30 2018/9/13
 */
public class SqlPrintInterceptor extends DebugInterceptor {
	private static final Logger log = LoggerFactory.getLogger("dbInfo");

	@Override
	protected void println(String str){
		log.info(str);
	}
}
