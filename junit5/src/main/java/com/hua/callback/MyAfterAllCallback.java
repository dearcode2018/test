/**
  * @filename MyAfterAllCallback.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.callback;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @type MyAfterAllCallback
 * @description 
 * @author qianye.zheng
 */
public class MyAfterAllCallback implements AfterAllCallback
{

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void afterAll(ExtensionContext context) throws Exception
	{
		System.out.println("MyAfterAllCallback.afterAll()");
	}

}
