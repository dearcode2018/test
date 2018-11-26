/**
  * @filename MyTestInstancePostProcessor.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.processor;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

/**
 * @type MyTestInstancePostProcessor
 * @description 
 * @author qianye.zheng
 */
public class MyTestInstancePostProcessor implements TestInstancePostProcessor
{

	/**
	 * @description 
	 * @param testInstance
	 * @param context
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void postProcessTestInstance(Object testInstance,
			ExtensionContext context) throws Exception
	{
		System.out.println(
				"MyTestInstancePostProcessor.postProcessTestInstance()");
	}

}
