/**
 * 描述: 
 * AssertionTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.unitils;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyReflectionEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * AssertionTest
 */
public final class AssertionTest extends BaseTest {

	/**
	 
	 反射断言 (org.unitils.reflectionassert.ReflectionAssert)
	 
	 1) 对象(针对所有属性)断言 - 严格模式(可设置宽松模式)
	org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
	
	2) 对象(针对所有属性)断言 - 宽松模式(缺省值/顺序 宽松)
	org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals;
	
	3) 属性(针对指定的属性)断言 - 严格模式(可设置宽松模式)
	org.unitils.reflectionassert.ReflectionAssert.assertPropertyReflectionEquals;
	
	4) 属性断言(针对指定的属性) - 宽松模式(缺省值/顺序 宽松)
	org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;	 
	 
	 宽松模式只直接支持 缺省值/顺序 2种方式，日期宽松不自持; 所有宽松模式都
	 可以通过相应的严格模式来进行设置，严格模式可以设置的宽松模式有如下3种: 
	 IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
	 */
	
	/**
	 * 
	 * 描述:  对象(针对所有属性)断言 - 严格模式(可设置宽松模式)
	 * 严格方式 (可设置为宽松模式)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAssertReflection() {
		try {
			
			User expectUser = new User();
			expectUser.setOid(2001L);
			expectUser.setUsername("zhangsan");
			
			User actualUser = new User();
			actualUser.setOid(2001L);
			actualUser.setUsername("zhangsan1");
			
			// 期望值 、实际值 (严格模式)
			assertReflectionEquals(expectUser, actualUser);
			
			// 期望值 、实际值 (宽松模式) IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
			//assertReflectionEquals(expectUser, actualUser, ReflectionComparatorMode.IGNORE_DEFAULTS);
			
		} catch (Exception e) {
			log.error("testAssertReflection =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 对象(针对所有属性)断言 - 宽松模式(缺省值/顺序 宽松)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLenientOrder() {
		try {
			List<Integer> expectList = Arrays.asList(1, 2, 3);
			List<Integer> actualList = Arrays.asList(2, 1, 3);
			// 宽松模式
			assertLenientEquals(expectList, actualList);
			
			// 等效如下
			// 宽松模式 (顺序宽松) IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
			//assertReflectionEquals(expectList, actualList, ReflectionComparatorMode.LENIENT_ORDER);
			
			// 严格模式
			//assertReflectionEquals(expectList, actualList);
		} catch (Exception e) {
			log.error("testLenientOrder =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 对象(针对所有属性)断言 - 宽松模式(缺省值/顺序 宽松)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testIgnoreDefaults() {
		try {
			
			User expectUser = new User();
			expectUser.setOid(2001L);
			expectUser.setUsername(null);
			
			User actualUser = new User();
			actualUser.setOid(2001L);
			actualUser.setUsername("zhangsan");
			
			// 期望值 、实际值 (宽松模式 - null或false值设置在expect的位置)
			 assertLenientEquals(expectUser, actualUser);
			
			// 等效如下 IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
			//assertReflectionEquals(expectUser, actualUser, ReflectionComparatorMode.IGNORE_DEFAULTS);
			
		} catch (Exception e) {
			log.error("testIgnoreDefaults =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 对象(针对所有属性)断言 - 严格模式(可设置宽松模式) 宽松模式 - 日期
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLenientDates() {
		try {
			// 这种模式只比较2个实例的date属性是否都被设置了值或都为null
			User expectUser = new User();
			expectUser.setOid(2001L);
			expectUser.setUsername("zhangsan");
			expectUser.setLastLoginTime(new Timestamp(54654654654L));
			
			User actualUser = new User();
			actualUser.setOid(2001L);
			actualUser.setUsername("zhangsan");
			//actualUser.setLastLoginTime(new Timestamp(DateTimeUtil.getTimeInMillis()));
			
			// 期望值 、实际值 (宽松模式 - null或false值设置在expect的位置) IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
			assertReflectionEquals(expectUser, actualUser, ReflectionComparatorMode.LENIENT_DATES);
			
		} catch (Exception e) {
			log.error("testLientDates =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述:  属性(针对指定的属性)断言 - 严格模式(可设置宽松模式)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAssertPropertyReflection() {
		try {
			
			User expectUser = new User();
			expectUser.setOid(2001L);
			expectUser.setUsername("zhangsan");
			
			User actualUser = new User();
			actualUser.setOid(2001L);
			actualUser.setUsername("zhangsan");
			
			Long expectOid = 2002L;
			expectOid = 2001L;
			
			// 表示 用实际对象的 oid 属性 来和期望值(类型必须 和 实际对象的属性类型一致)
			assertPropertyReflectionEquals("oid", expectOid, actualUser);
			
			// IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
			//assertPropertyReflectionEquals("", expectUser, actualUser, ReflectionComparatorMode.IGNORE_DEFAULTS);
			
		} catch (Exception e) {
			log.error("testAssertPropertyReflection =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 属性断言(针对指定的属性) - 宽松模式(缺省值/顺序 宽松)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAssertPropertyLenient() {
		try {
			
			User expectUser = new User();
			expectUser.setOid(2001L);
			expectUser.setUsername("zhangsan");
			
			User actualUser = new User();
			actualUser.setOid(2001L);
			actualUser.setUsername("zhangsan");
			
			Long expectOid = 2002L;
			expectOid = 2001L;
			// 使用 ReflectionComparatorMode.IGNORE_DEFAULTS 在期望值为null的时候 忽略比较
			expectOid = null;
			
			// 表示 用实际对象的 oid 属性 来和期望值(类型必须 和 实际对象的属性类型一致)
			assertPropertyLenientEquals("oid", expectOid, actualUser);
			
			// 等效如下: 
			// IGNORE_DEFAULTS LENIENT_DATES LENIENT_ORDER
			//assertPropertyReflectionEquals("oid", expectOid, actualUser, ReflectionComparatorMode.IGNORE_DEFAULTS);
			
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
	@Test
	public void testTemp() {
		try {
			User u1 = new User();
			u1.setOid(2001L);
			u1.setUsername("zhangsan");
			
			User u2 = new User();
			u2.setOid(2001L);
			u2.setUsername("zhangsan1");
			assertReflectionEquals(u1, u2);
			
			
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
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 普通测试方法
	 ,@Test注解 不带参数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNormal() {
		System.out.println("testNormal()");
	}
	
	/**
	 * 
	 * 描述: 期望发生异常-测试方法
	 ,@Test注解 异常
	 * @author qye.zheng
	 * 
	 */
	@Test(expected=NullPointerException.class)
	@SuppressWarnings("all")
	public void testException() {
		String str = null;
		System.out.println(str.length());
	}
	
	/**
	 * 
	 * 描述: 超时测试方法
	 ,@Test注解 指定运行时间 (单位 : 毫秒)
	 * @author qye.zheng
	 * 
	 */
	@Test(timeout=3000)
	public void testTimeOut() {
		System.out.println("testTimeOut()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Ignore("暂时忽略的方法")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
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
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
