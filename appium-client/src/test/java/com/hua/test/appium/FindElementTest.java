/**
 * 描述: 
 * FindElementTest.java
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

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.hua.test.BaseTest;

import io.appium.java_client.MobileElement;


/**
 * 描述: 查找APP元素
 * 
 * @author qye.zheng
 * FindElementTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class FindElementTest extends BaseTest {

	private By by;
	
	private MobileElement element;
	
	private List<MobileElement> elements;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFindByXPath() {
		try {
			// 启动应用
			//driver.launchApp();
			//driver.findElementByClassName("cpt-choose-box cpt-choose-box-pop");
			//element = driver.findElementByClassName("android.widget.ImageView");
			//element = driver.findElementByXPath("//div[@class=' cpt-choose-box cpt-choose-box-pop']");
			//System.out.println(element.getText());
			//driver.getKeyboard().pressKey("A");
			
			//driver.rotation();
			
			//System.out.println(orientation.name() + ", " + orientation.ordinal());
			// 休眠若干秒，等待APP准备就绪
			TimeUnit.SECONDS.sleep(2);
			//driver.close();
			List<MobileElement> elements = null;
			System.out.println(driver.getPageSource());
			//driver.closeApp();
/*			By by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.view:id/tab_title']");
			elements = driver.findElements(by);
			System.out.println(elements.size());
			
			for (MobileElement e : elements) {
				System.out.println(e.getText());
			}*/
			// 点击第一个元素，账号输入框
			
			by = By.xpath("//android.widget.EditText");
			
		} catch (Exception e) {
			log.error("testFindByXPath =====> ", e);
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
	public void testFindElement() {
		try {
			// 点击第一个元素，账号输入框
			by = By.xpath("//android.widget.FrameLayout[@resource-id='ctrip.android.publicproduct:id/home_search_text']/android.widget.TextView");
			element = driver.findElement(by);
			//元素ID是运行时变量，每次运行都不同，可以作为一个会话的唯一元素标记
			// 590b4b10-7f4c-4363-8101-4c299f24cd87, null, 大家都在吃啥？
			System.out.println(element.getId() + ", " + element.getTagName() + ", " + element.getText());
			//Coordinates coordinates = element.getCoordinates();
			//System.out.println(coordinates.getAuxiliary());
		
			element = driver.findElement("//android.widget.FrameLayout[@resource-id='ctrip.android.publicproduct:id/home_search_text']/android.widget.TextView", "xpath");
			
		} catch (Exception e) {
			log.error("testFindElement =====> ", e);
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
	public void testFindElement2() {
		try {
			// by: 通过什么方式(xpath/className/css/id/...)， using: 具体的值 
			String by = "xpath";
			String using = "//android.widget.FrameLayout[@resource-id='ctrip.android.publicproduct:id/home_search_text']/android.widget.TextView";
			element = driver.findElement(by, using);
			//元素ID是运行时变量，每次运行都不同，可以作为一个会话的唯一元素标记
			// 590b4b10-7f4c-4363-8101-4c299f24cd87, null, 大家都在吃啥？
			System.out.println(element.getId() + ", " + element.getTagName() + ", " + element.getText());
			
		} catch (Exception e) {
			log.error("testFindElement2 =====> ", e);
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
	public void testFindElementById() {
		try {
			// 根据ID找元素，在H5中使用比价多，APP中没有定义ID属性，ID属于运行时值
			// 点击第一个元素，账号输入框
			by = By.xpath("//android.widget.FrameLayout[@resource-id='ctrip.android.publicproduct:id/home_search_text']/android.widget.TextView");
			element = driver.findElement(by);
			MobileElement element2 = driver.findElementById("DKDKSLDJWO1323");
			System.out.println(element.equals(element2));
		} catch (Exception e) {
			log.error("testFindElementById =====> ", e);
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
	public void testFindElementByLinkText() {
		try {
			// 应该是手机端不支持该操作
			// Locator Strategy 'link text' is not supported for this session
			element = driver.findElementByLinkText("攻略·景点");
			//System.out.println(element.toString());
			//System.out.println(element.getId() + ", " + element.getTagName());
			System.out.println(element.getText());
			
		} catch (Exception e) {
			log.error("testFindElementByLinkText =====> ", e);
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
	public void testFindElementByPartialLinkText() {
		try {
			// 应该是手机端不支持该操作
			//  Locator Strategy 'link text' is not supported for this session
			element = driver.findElementByLinkText("攻略·景点");
			//System.out.println(element.toString());
			//System.out.println(element.getId() + ", " + element.getTagName());
			System.out.println(element.getText());
			
		} catch (Exception e) {
			log.error("testFindElementByPartialLinkText =====> ", e);
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
	public void testFindElementByTagName() {
		try {
			// Locator Strategy 'tag name' is not supported for this session
			element = driver.findElementByTagName("android.support.v4.view.ViewPager");
			MobileElement element2 = element.findElement("xpath", "//android.widget.ImageView");
			//System.out.println(element.toString());
			//System.out.println(element.getId() + ", " + element.getTagName());
			System.out.println(element2.getAttribute("checkable"));
		} catch (Exception e) {
			log.error("testFindElementByTagName =====> ", e);
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
	public void testFindElementByName() {
		try {
			/*
			 * 通过属性name 来匹配，存在多个则返回第一个
			 */
			// Locator Strategy 'name' is not supported for this session
			//element = driver.findElementByClassName("android.view.ViewGroup");
			element = driver.findElementByName("android.widget.TextView");
			//System.out.println(element.toString());
			//System.out.println(element.getId() + ", " + element.getTagName());
			System.out.println(element.getText());
		} catch (Exception e) {
			log.error("testFindElementByName =====> ", e);
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
	public void testFindElementByClassName() {
		try {
			/*
			 * 通过属性class 来匹配，存在多个则返回第一个
			 */
			//element = driver.findElementByClassName("android.view.ViewGroup");
			element = driver.findElementByClassName("android.widget.TextView");
			//System.out.println(element.toString());
			//System.out.println(element.getId() + ", " + element.getTagName());
			System.out.println(element.getText());
			
			/*
			 * 通过属性class 来匹配，查找多个
			 */
			elements = driver.findElementsByClassName("android.support.v4.view.ViewPager");
			
			elements.forEach(x -> System.out.println(x.getAttribute(RESOURCE_ID)));
			

		} catch (Exception e) {
			log.error("testFindElementByClassName =====> ", e);
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
	public void testFindElementByCssSelector() {
		try {
			// 手机原生页面不支持
		} catch (Exception e) {
			log.error("testFindElementByCssSelector =====> ", e);
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
	public void testFindElementByXPath() {
		try {
			//by = By.xpath("//android.widget.EditText");
			String using = "//android.widget.FrameLayout[@resource-id='ctrip.android.publicproduct:id/home_search_text']/android.widget.TextView";
			element = driver.findElementByXPath(using);
			System.out.println(element.getText());
			
		} catch (Exception e) {
			log.error("testFindElementByXPath =====> ", e);
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
			TimeUnit.SECONDS.sleep(3);
			System.out.println(driver.getPageSource());
			
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
