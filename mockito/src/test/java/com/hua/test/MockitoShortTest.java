/**
 * 描述: 
 * MockitoShortTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

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
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MockitoShortTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
@SuppressWarnings("unchecked")
public final class MockitoShortTest extends BaseTest {

	/**
	 * 用注解的方式，统一声明，可以省略 Mockito.mock(T);
	 * 需要在执行具体测试方法执行，执行MockitoAnnotations.openMocks(this);
	 */
	@Mock
	private List<Integer> mock;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@SuppressWarnings("unchecked")
	//@DisplayName("test")
	@Test
	public void testMockito() {
		try {
			mock.add(1);
			
			/*
			 * 验证某个行为(方法以及参数)是否发生(调用)
			 * 若没有发生，则测试结果将失败
			 */
			//Mockito.verify(mock).add(1);
			//Mockito.verify(mock).add(2);
			
			mock.size();
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@SuppressWarnings("unchecked")
	//@DisplayName("test")
	@Test
	public void testVerify() {
		try {
			mock.add(1);
			
			/*
			 * 验证某个行为(方法以及参数)是否发生(调用)
			 * 若没有发生，则测试结果将失败
			 */
			Mockito.verify(mock).add(1);
			//Mockito.verify(mock).add(2);
			
			//mock.size();
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@SuppressWarnings("unchecked")
	//@DisplayName("test")
	@Test
	public void testVerifyNoInteractions() {
		try {
			//mock.add(1);
			
			/*
			 * 验证某个行为(方法以及参数)是否发生(调用)
			 * 若没有发生，则测试结果将失败
			 */
			//Mockito.verify(mock).add(1);
			//Mockito.verify(mock).add(2);
			
			// 经过前面verify之后，再无其他动作
			Mockito.verifyNoInteractions(mock);
			//mock.size();
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@SuppressWarnings("unchecked")
	//@DisplayName("test")
	@Test
	public void testWhen() {
		try {
			//mock.add(1);
			
			/*
			 * 验证某个行为(方法以及参数)是否发生(调用)
			 * 若没有发生，则测试结果将失败
			 */
			//Mockito.verify(mock).add(1);
			//Mockito.verify(mock).add(2);
			// 调用指定返回后，指定期待的返回值
			Mockito.when(mock.size()).thenReturn(10);
			
			assertTrue(mock.size() == 10);
			
			// 经过前面verify之后，再无其他动作
			//Mockito.verifyNoInteractions(mock);
			//mock.size();
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testThrowException() {
		try {
			OutputStream outputStream = Mockito.mock(OutputStream.class);
			// 预设关闭流时，抛出异常
			Mockito.doThrow(new IOException("流关闭异常")).when(outputStream).close();
			// 执行将发生上面预设的异常场景
			outputStream.close();
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testArgumentMatch() {
		try {
			Comparable<String> comparable = Mockito.mock(Comparable.class);
			// 预设场景
			Mockito.when(comparable.compareTo("abc")).thenReturn(1);
			Mockito.when(comparable.compareTo("okr0")).thenReturn(2);
			
			// 断言验证预设的场景
			assertEquals(1, comparable.compareTo("abc"));
			assertEquals(2, comparable.compareTo("okr0"));
			
			// 没有预设则返回对应类型的默认值 0
			assertEquals(0, comparable.compareTo("111"));
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testUnsepcifiedMatch() {
		try {
			// 预设场景
			Mockito.when(mock.get(Mockito.anyInt())).thenReturn(1);
			
			Mockito.when(mock.contains(Mockito.argThat(x -> Integer.valueOf(100).equals(x)))).thenReturn(true);
			
			//assertEquals(Integer.valueOf(1), mock.get(2));
			assertEquals(1, mock.get(2).intValue());
			assertNotEquals(1, mock.get(1));
			assertTrue(mock.contains(100));
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testAllArgument() {
		try {
			Comparator<String> comparator = Mockito.mock(Comparator.class);
			comparator.compare("112", "ala");
			
			/*
			 * Mockito.anyString() 和 Mockito.eq() 都是一个Matcher，都会执行reportMatcher
			 */
			Mockito.verify(comparator).compare(Mockito.anyString(), Mockito.eq("ala"));
			/* 无效的写法
			 * Invalid use of argument matchers!
			 * 2 matchers expected, 1 recorded:
			 */
			//Mockito.verify(comparator).compare(Mockito.anyString(), "ala");
			
			// 这个也是正确的写法
			//Mockito.verify(comparator).compare("112", "ala");
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testTimes() {
		try {
			mock.add(0);
			mock.add(1);
			mock.add(1);
			mock.add(2);
			mock.add(2);
			mock.add(2);
			
			//Mockito.verify(mock).add(1);
			// 校验调用了几次
			Mockito.verify(mock, Mockito.times(2)).add(1);
			Mockito.verify(mock, Mockito.times(3)).add(2);

			// 验证是否从未被调用过
			Mockito.verify(mock, Mockito.never()).add(1233);
			
			// 至少调用过一次
			Mockito.verify(mock, Mockito.atLeastOnce()).add(1);
			
			// 至少调用过多少次
			Mockito.verify(mock, Mockito.atLeast(2)).add(1);
			
			// 最多调用1次
			Mockito.verify(mock, Mockito.atMostOnce()).add(0);
			
			// 最多调用多少次
			Mockito.verify(mock, Mockito.atMost(3)).add(2);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testInOrder() {
		try {
			/*
			 * 验证其是否按顺序发生
			 */
			List<Integer> mock1 = Mockito.mock(List.class);
			List<Integer> mock2 = Mockito.mock(List.class);
			mock1.add(101);
			mock2.add(201);
			
			mock1.add(102);
			mock2.add(202);
			
			InOrder inOrder = Mockito.inOrder(mock1, mock2);
			inOrder.verify(mock1).add(101);
			inOrder.verify(mock2).add(201);
			inOrder.verify(mock1).add(102);
			inOrder.verify(mock2).add(202);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testInteraction() {
		try {
			mock.add(1);
			
			/*
			 * 验证某个行为(方法以及参数)是否发生(调用)
			 * 若没有发生，则测试结果将失败
			 */
			Mockito.verify(mock).add(1);
			Mockito.verify(mock, Mockito.never()).add(2);
			
			// 经过前面verify之后，检查是否还有未被验证的互动行为
			Mockito.verifyNoMoreInteractions(mock);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
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
		// 打开测试对象的Mock
		MockitoAnnotations.openMocks(this);
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
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
