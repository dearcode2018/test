/**
 * 描述: 
 * AppImageTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.appium;

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

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;
import org.springframework.util.Base64Utils;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 图片
 * 
 * @author qye.zheng
 * AppImageTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class AppImageTest extends BaseTest {

	
	/**
	 * Base64编码转换
	 * 
	 * 
	 * 
	 */
	
	/**
	 * 
	 * 描述: 截屏
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testScreenshot() {
		try {
			// 返回base64的数据
			Response response = driver.execute(DriverCommand.SCREENSHOT);
			/*
			 * state: success, status = 0，表示截屏成功
			 * 
			 * 注意，这里返回的字符串已经分段换行，需要将换行去掉，然后再解码
			 */
			
			Object value = response.getValue();
			//System.out.println(value.toString());
			/*
			 * 注意 不要直接调用 Base64Utils.decodeFromString()
			 * 正确做法是调用 Base64Utils.decode(byte[])
			 * nodtepad++ 工具替换的正则是: \r\n
			 * 而java程序中用的正则是: \n
			 * 注意这2者的区别.
			 */
			//System.out.println(value.toString().replaceAll("\n", ""));
			FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), Base64Utils.decode(value.toString().replaceAll("\n", "").getBytes()), true);
			//System.out.println(response.getValue());
		} catch (Exception e) {
			log.error("testScreenshot =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 截屏 方法2
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testScreenshot2() {
		try {
			//FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), Base64Utils.decode(value.toString().replaceAll("\n", "").getBytes()));
			//System.out.println(response.getValue());
			// 截取当前屏幕
			String value = driver.getScreenshotAs(OutputType.BASE64);
			//System.out.println(value);
			FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), Base64Utils.decode(value.toString().replaceAll("\n", "").getBytes()), true);
		} catch (Exception e) {
			log.error("testScreenshot2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 截屏 方法3
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testScreenshot3() {
		try {
			//FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), Base64Utils.decode(value.toString().replaceAll("\n", "").getBytes()));
			//System.out.println(response.getValue());
			// 截取当前屏幕
			byte[] value = driver.getScreenshotAs(OutputType.BYTES);
			//System.out.println(value);
			FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), value, true);
		} catch (Exception e) {
			log.error("testScreenshot3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 截屏 方法4，获取到文件对象，直接操作该对象，
	 * 不适用于保存文件的场景
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testScreenshot4() {
		try {
			//FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), Base64Utils.decode(value.toString().replaceAll("\n", "").getBytes()));
			//System.out.println(response.getValue());
			// 截取当前屏幕
			File value = driver.getScreenshotAs(OutputType.FILE);
			//System.out.println(value);
		} catch (Exception e) {
			log.error("testScreenshot4 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 截屏
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testToImage() {
		try {
			// 返回base64的数据
			//String value = FileUtil.getString(ClassPathUtil.getClassPath("/imageBase64.txt"));
			//System.out.println(value);
			/**
			 * decode 字节，不要用FileUtil.getString() 的方式，避免读取文本文件，存在文件结束符多余的问题.
			 */
			FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/image2.png"), Base64Utils.decode(FileUtil.getByteArray(ClassPathUtil.getClassPath("/imageBase64.txt"))), true);
			//System.out.println(response.getValue());
			
		} catch (Exception e) {
			log.error("testToImage =====> ", e);
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
	public void testToBase64() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/image.png");
			System.out.println(Base64Utils.encodeToString(FileUtil.getByteArray(path)));
			
		} catch (Exception e) {
			log.error("testToBase64 =====> ", e);
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
	public void testFindImage() {
		try {
			
			
		} catch (Exception e) {
			log.error("testFindImage =====> ", e);
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
		driver = driver();
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
