/**
  * @filename MyBeforeAllCallback.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.callback;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @type MyBeforeAllCallback
 * @description 
 * @author qianye.zheng
 */
public class MyBeforeAllCallback implements BeforeAllCallback
{

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void beforeAll(ExtensionContext context) throws Exception
	{
		System.out.println("MyBeforeAllCallback.beforeAll()");
	}

}
