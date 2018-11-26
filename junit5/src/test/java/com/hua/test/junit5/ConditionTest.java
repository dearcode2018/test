/**
 * 描述: 
 * ConditionTest.java
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import com.hua.annotation.TestOnLinux;
import com.hua.test.BaseTest;


/**
 * 描述: 条件测试
 * 
 * @author qye.zheng
 * ConditionTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class ConditionTest extends BaseTest {

	
	
	
	/**
	 * 
	 * 描述: 操作系统-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	//@EnabledOnOs(OS.WINDOWS)
	/*
	 * 不符合条件时，只有@BeforeAll/@AfterAll执行
	 * 而测试生命周期的核心逻辑是没有执行的
	 */
	@EnabledOnOs(OS.MAC)
	public void testEnabledOnOS() {
		try {
			System.out.println("ConditionTest.testEnabledOnOS()");
			
		} catch (Exception e) {
			log.error("testEnabledOnOS =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 操作系统-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	//@DisabledOnOs(OS.LINUX)
	@DisabledOnOs(OS.WINDOWS)
	public void testDisabledOnOS() {
		try {
			System.out.println("ConditionTest.testDisabledOnOS()");
			
		} catch (Exception e) {
			log.error("testDisabledOnOS =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 操作系统-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	//@Test
	@TestOnLinux
	public void testEnabledOSLinux() {
		try {
			System.out.println("ConditionTest.testEnabledOSLinux()");
			
		} catch (Exception e) {
			log.error("testEnabledOSLinux =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: JRE-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	//@EnabledOnJre(JRE.JAVA_8)
	@EnabledOnJre(JRE.JAVA_10)
	public void testEnabledOnJre() {
		try {
			System.out.println("ConditionTest.testEnabledOnJre()");
			
		} catch (Exception e) {
			log.error("testEnabledOnJre =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: JRE-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	@DisabledOnJre(JRE.JAVA_11)
	public void testDisabledOnJre() {
		try {
			System.out.println("ConditionTest.testDisabledOnJre()");
			
		} catch (Exception e) {
			log.error("testDisabledOnJre =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 系统属性(JVM)-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	/*
	 * named: JVM系统属性
	 * matches: 正则表达式
	 */
	//@EnabledIfSystemProperty(named = "os.name", matches = "Windows.*")
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	public void testEnabledIfSystemProperty() {
		try {
			// Windows 7
			System.out.println(System.getProperty("os.name"));
			// amd64
			System.out.println(System.getProperty("os.arch"));
		} catch (Exception e) {
			log.error("testEnabledIfSystemProperty =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 系统属性(JVM)-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	//@DisabledIfSystemProperty(named = "os.name", matches = "Windows.*")
	@DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
	@Test
	public void testDisabledIfSystemProperty() {
		try {
			// Windows 7
			System.out.println(System.getProperty("os.name"));
			// amd64
			System.out.println(System.getProperty("os.arch"));
			
		} catch (Exception e) {
			log.error("testDisabledIfSystemProperty =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 环境变量-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk1\\.8.*")
	@Test
	public void testEnabledIfEnvironmentVariable() {
		try {
			System.out.println(System.getenv("JAVA_HOME"));
			System.out.println(System.getenv("PATH"));
			
		} catch (Exception e) {
			log.error("testEnabledIfEnvironmentVariable =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 环境变量-条件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@DisabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk1\\7.*")
	@Test
	public void testDisabledIfEnvironmentVariable() {
		try {
			System.out.println(System.getenv("JAVA_HOME"));
			System.out.println(System.getenv("PATH"));
			
		} catch (Exception e) {
			log.error("testDisabledIfEnvironmentVariable =====> ", e);
		}
	}
	
	/**
	 * 
	 * 脚本绑定
	 * 1) systemEnvironment 操作系统环境变量访问器
	 * 2) systemProperty JVM系统属性访问器
	 * 3) junitConfigurationParamter 配置参数
	 * 4) junitDispalyName 测试、容器展示名称
	 * 5) junitTags 测试、容器的所有标签信息
	 * 6) junitUniqueId 测试、容器的唯一标志
	 * 
	 * 
	 */
	
	/**
	 * 
	 * 描述: 脚本条件(JavaScript/Groovy/)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@EnabledIf(value = {"2 * 3 == 6"})
	@Test
	public void testEnabledIf() {
		try {
			System.out.println("ConditionTest.testEnabledIf()");
			
		} catch (Exception e) {
			log.error("testEnabledIf =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 脚本条件(JavaScript/Groovy/)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@EnabledIf(value = {" 'CI' == systemEnvironment.get('ENV')"})
	@Test
	public void testEnabledIf2() {
		try {
			System.out.println("ConditionTest.testEnabledIf()");
			
		} catch (Exception e) {
			log.error("testEnabledIf2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 脚本条件(JavaScript/Groovy/)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	// 不成立的时候执行
	//@DisabledIf(value = {"2 * 4 == 6"})
	// 成立则不执行
	@DisabledIf(value = {"2 * 4 == 8"})
	@Test
	public void testDisabledIf() {
		try {
			System.out.println("ConditionTest.testDisabledIf()");
			
		} catch (Exception e) {
			log.error("testDisabledIf =====> ", e);
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
		
	}

}
