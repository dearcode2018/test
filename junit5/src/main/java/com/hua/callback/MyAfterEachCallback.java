/**
  * @filename MyAfterEachCallback.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.callback;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @type MyAfterEachCallback
 * @description 
 * @author qianye.zheng
 */
public class MyAfterEachCallback implements AfterEachCallback
{

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void afterEach(ExtensionContext context) throws Exception
	{
		System.out.println("MyAfterEachCallback.afterEach()");
	}

}
