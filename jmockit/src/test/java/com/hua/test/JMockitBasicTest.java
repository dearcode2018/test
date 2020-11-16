/**
 * 描述: 
 * JMockitBasicTest.java
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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.hua.mock.HelloJMockit;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JMockitBasicTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class JMockitBasicTest extends BaseTest {

    @Mocked
    private HelloJMockit helloJMockit;
    
    /**
     * 
     * 描述:
     * @author qye.zheng
     * 
     */
    // @DisplayName("test")
    @Test
    public void testJMockitBasic() {
        try {
            // 录制
            new Expectations() {
                {
                    helloJMockit.sayHello();
                    result = "hello,david";
                }
                
            };
            // 重放
            String msg = helloJMockit.sayHello();
            assertTrue(msg.equals("hello,david"));
            // 验证
            new Verifications() {
                {
                    helloJMockit.sayHello();
                    times = 1;
                }
            };
            
            new Verifications() {
                {
                    helloJMockit.sayHello();
                    times = 1;
                }
            };

        } catch (Exception e) {
            log.error("test =====> ", e);
        }
    }
	
    /**
     * 
     * 描述: 参数注入
     * @author qye.zheng
     * 
     */
    // @DisplayName("test")
    @Test
    public void testJMockitBasci2(@Mocked HelloJMockit helloJMockit) {
        try {
            // 录制
            new Expectations() {
                {
                    helloJMockit.sayHello();
                    result = "hello,david";
                }
                
            };
            // 重放
            String msg = helloJMockit.sayHello();
            assertTrue(msg.equals("hello,david"));
            // 验证
            new Verifications() {
                {
                    helloJMockit.sayHello();
                    times = 1;
                }
            };
            
            new Verifications() {
                {
                    helloJMockit.sayHello();
                    times = 1;
                }
            };

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
	@Override
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
	@Override
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
