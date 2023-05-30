package com.job.common.utils;
 
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
 
public class SnowflakeIdUtil {
 
	private volatile static Snowflake instance;
 
	public static synchronized Snowflake getInstance() {
		if (instance == null) {
			synchronized (SnowflakeIdUtil.class) {
				if (instance == null) {
					instance = IdUtil.getSnowflake(1, 1);
				}
			}
			return instance;
		}
		return instance;
	}
}