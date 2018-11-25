/**
 * 描述: 
 * NestedTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.junit5;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * NestedTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class NestedTest extends BaseTest {

	
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * @type InnerClazz
	 * @description 非静态内部类
	 * 使用 @Nested标注 ，否则提示没有 test runner
	 * @author qianye.zheng
	 */
	@DisplayName("嵌套测试类-内部类")
	@Nested
	class InnerClazz
	{
		/*
		 * 内部类可以嵌套任何深度，视为外部类的完整成员
		 */
		
		
		
		/**
		 * 
		 * @description 
		 * @author qianye.zheng
		 */
		@Test
		void isEmpty()
		{
			System.out.println("Junit5Test.InnerClazz.isEmpty()");
		}
		
		/*
		 * The method afterClass cannot be declared static; static methods can only be declared
		 * in a static or top level  type
		 * 内部类不能声明静态成员(属性/方法)，因此无法使用@BeforeAll 和 @AfterAll
		 * 可以使用@BeforeEach和@AfterEach，执行内部类的测试用例时，外部的类的@BeforeEache
		 * 和@AfterEach以及静态的@BeforeAll和@AfterAll 均被执行.
		 */
		// @AfterAll
		// public static void afterClass() {}
		
		/**
		 * 
		 * 描述: [每个测试-方法]开始之前运行
		 * @author qye.zheng
		 * 
		 */
		@DisplayName("InnerClazz.beforeMethod")
		@BeforeEach
		public void beforeMethod() {
			System.out.println("InnerClazz.beforeMethod()");
		}
		
		/**
		 * 
		 * 描述: [每个测试-方法]结束之后运行
		 * @author qye.zheng
		 * 
		 */
		@DisplayName("afterMethod")
		@AfterEach
		public void afterMethod() {
			System.out.println("afterMethod()");
		}
	}
	
	/**
	 * 
	 * @type InnerClazz
	 * @description 非静态内部类
	 * 使用 @Nested标注 ，否则提示没有 test runner
	 * @author qianye.zheng
	 */
	@DisplayName("嵌套测试类-内部类")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@Nested
	class InnerClazz2
	{
		/*
		 * 内部类可以嵌套任何深度，视为外部类的完整成员
		 * 执行情况: 从外到里，类级到对象级
		beforeClass()
		NestedTest.InnerClazz2.beforeClass()
		beforeMethod()
		InnerClazz2.beforeMethod()
		Junit5Test.InnerClazz2.isEmpty()
		InnerClazz2.afterMethod()
		afterMethod()
		NestedTest.InnerClazz2.afterClass()
		afterClass()
		 */
		
		/**
		 * 
		 * @description 
		 * @author qianye.zheng
		 */
		@Test
		void isEmpty()
		{
			System.out.println("Junit5Test.InnerClazz2.isEmpty()");
		}
		
		@BeforeAll
		public void beforeClass() {
			System.out.println("NestedTest.InnerClazz2.beforeClass()");
		}
		
		/*
		 * The method afterClass cannot be declared static; static methods can only be declared
		 * in a static or top level  type
		 * 内部类不能声明静态成员(属性/方法)，因此无法使用@BeforeAll 和 @AfterAll
		 * 可以使用@BeforeEach和@AfterEach，执行内部类的测试用例时，外部的类的@BeforeEache
		 * 和@AfterEach以及静态的@BeforeAll和@AfterAll 均被执行.
		 * 
		 * 在测试类上标注@TestInstance(TestInstance.Lifecycle.PER_CLASS)
		 * 然后写一个非静态成员方法加上@AfterAll或BeforeAll的标注即可
		 */
		@AfterAll
		public void afterClass() {
			System.out.println("NestedTest.InnerClazz2.afterClass()");
		}
		
		/**
		 * 
		 * 描述: [每个测试-方法]开始之前运行
		 * @author qye.zheng
		 * 
		 */
		@DisplayName("InnerClazz2.beforeMethod")
		@BeforeEach
		public void beforeMethod() {
			System.out.println("InnerClazz2.beforeMethod()");
		}
		
		/**
		 * 
		 * 描述: [每个测试-方法]结束之后运行
		 * @author qye.zheng
		 * 
		 */
		@DisplayName("afterMethod")
		@AfterEach
		public void afterMethod() {
			System.out.println("InnerClazz2.afterMethod()");
		}
	}
	
	/**
	 * 
	 * @type StaticClazz
	 * @description 静态内部类
	 * 独立存在，跟外部类没有任何关系
	 * @author qianye.zheng
	 */
	static class StaticClazz
	{
		@Test
		void isEmpty()
		{
			System.out.println("Junit5Test.StaticClazz.isEmpty()");
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testCommon")
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testSimple")
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
	}

}
