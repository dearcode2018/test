/**
  * @filename TimingExtension.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.junit5;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

/**
 * @type TimingExtension
 * @description 
 * @author qianye.zheng
 */
public class TimingExtension
		implements BeforeTestExecutionCallback, AfterTestExecutionCallback
{
	
	static final Logger log = Logger.getLogger(TimingExtension.class.getName());

	static final String START_TIME = "start_time";
	
	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception
	{
		Method method = context.getRequiredTestMethod();
		long startTime = getStore(context).remove(START_TIME, long.class);
		long duration = System.currentTimeMillis() - startTime;
		log.info(() -> String.format("Method [%s] takes %s ms", method.getName(), duration));
	}

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception
	{
		getStore(context).put(START_TIME, System.currentTimeMillis());
	}
	
	/**
	 * 
	 * @description 
	 * @param context
	 * @return
	 * @author qianye.zheng
	 */
	private Store getStore(ExtensionContext context)
	{
		return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
	}
	
}
