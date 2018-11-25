/**
  * @filename TestInterfaceDynamicTestDemo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;


/**
 * @type TestInterfaceDynamicTestDemo
 * @description 
 * @author qianye.zheng
 */
public interface TestInterfaceDynamicTestDemo
{
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	default Collection<DynamicTest> dynamicTestFromCollection()
	{
		
		return Arrays.asList(DynamicTest.dynamicTest("1st dynamic test in test interface", () -> assertTrue(true)), 
				DynamicTest.dynamicTest("2st dynamic test in test interface", () -> assertTrue(true))
				);
	}
	
}
