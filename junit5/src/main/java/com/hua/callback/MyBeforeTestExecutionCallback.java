/**
  * @filename MyBeforeTestExecutionCallback.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.callback;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @type MyBeforeTestExecutionCallback
 * @description 
 * @author qianye.zheng
 */
public class MyBeforeTestExecutionCallback
		implements BeforeTestExecutionCallback
{

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception
	{
		System.out
				.println("MyBeforeTestExecutionCallback.beforeTestExecution()");
	}

}
