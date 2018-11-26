/**
  * @filename IgnoreIOExceptionHandler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import java.io.IOException;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

/**
 * @type IgnoreIOExceptionHandler
 * @description IO异常处理器 (扩展)
 * @author qianye.zheng
 */
public class IgnoreIOExceptionHandler implements TestExecutionExceptionHandler
{

	/**
	 * @description 
	 * @param context
	 * @param throwable
	 * @throws Throwable
	 * @author qianye.zheng
	 */
	@Override
	public void handleTestExecutionException(ExtensionContext context,
			Throwable throwable) throws Throwable
	{
		if (throwable instanceof IOException)
		{
			System.out.println("忽略IO异常");
			// 忽略IO异常
			return ;
		}
		
		// 其他异常往上抛
		throw throwable;
	}

}
