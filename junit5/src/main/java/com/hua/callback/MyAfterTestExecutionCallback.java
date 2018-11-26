/**
  * @filename MyAfterTestExecutionCallback.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.callback;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @type MyAfterTestExecutionCallback
 * @description 
 * @author qianye.zheng
 */
public class MyAfterTestExecutionCallback implements AfterTestExecutionCallback
{

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception
	{
		System.out.println("MyAfterTestExecutionCallback.afterTestExecution()");
	}

}
