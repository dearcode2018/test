/**
  * @filename MyBeforeEachCallback.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.callback;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @type MyBeforeEachCallback
 * @description 
 * @author qianye.zheng
 */
public class MyBeforeEachCallback implements BeforeEachCallback
{

	/**
	 * @description 
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void beforeEach(ExtensionContext context) throws Exception
	{
		System.out.println("MyBeforeEachCallback.beforeEach()");
	}

}
