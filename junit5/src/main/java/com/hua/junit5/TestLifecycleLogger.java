/**
  * @filename TestLifecycleLogger.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.junit5;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;

/**
 * @type TestLifecycleLogger
 * @description 
 * @author qianye.zheng
 */
// 标记为PER_CLASS，@BeforeAll/@AfterAll 可以在静态/接口默认方法上声明
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifecycleLogger
{
	
	static final Logger logger = Logger.getLogger(TestLifecycleLogger.class.getName());
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@BeforeAll
	default void beforeAll()
	{
		logger.info("before all");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@BeforeEach
	default void beforeEach(TestInfo testInfo)
	{
		logger.info("before earch");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@AfterEach
	default void afterEach()
	{
		logger.info("after each");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@AfterAll
	default void afterAll()
	{
		logger.info("after all");
	}
}
