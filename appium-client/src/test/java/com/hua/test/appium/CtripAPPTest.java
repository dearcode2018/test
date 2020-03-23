/**
 * 描述: 
 * CtripAPPTest.java
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.hua.test.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


/**
 * 描述: 携程APP
 * 
 * @author qye.zheng
 * CtripAPPTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class CtripAPPTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 登录动作
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testLogin() {
		try {
			//File app  = new File("C:\\Users\\dell\\AppData\\Local\\Temp\\ctripA.apk");
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(true));
			// 会话ID，每次连接生成一个，22e4db34-2daa-4c06-9285-742058f87deb
			//driver.getAppStringMap();
			//Map<String, String> stringMap = driver.getAppStringMap(Locale.getDefault().getLanguage());
			//Map<String, String> stringMap = driver.getAppStringMap();
			//Set<String> keys = stringMap.keySet();
			
			//keys.forEach(x -> System.out.println(stringMap.get(x)));
			
			//ScreenOrientation orientation = driver.getOrientation();
			
			MobileElement element = null;
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
			By by = null;
			//driver.closeApp();
			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			TimeUnit.SECONDS.sleep(1);
			// 点击 [登录]
			by = By.xpath("//android.widget.Button[contains(@text,'登录')]");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			TimeUnit.SECONDS.sleep(2);
			// 点击第一个元素，账号输入框
			by = By.xpath("//android.widget.EditText");
			elements = driver.findElements(by);
			// 输入账号
			elements.get(0).sendKeys("15018750787");
			// 输入密码
			elements.get(1).sendKeys("a123b456");
			
			// 点击登录
			by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.login:id/rlLoginBtn']/android.widget.Button");
			element = driver.findElement(by);
			element.click();	
			
			// 重置APP，清空缓存
			//driver.resetApp();
			// 
			//driver.quit();
			
			
			
		} catch (Exception e) {
			log.error("testLogin =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 退出登录
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testLogout() {
		try {
			//File app  = new File("C:\\Users\\dell\\AppData\\Local\\Temp\\ctripA.apk");
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(true));
			// 会话ID，每次连接生成一个，22e4db34-2daa-4c06-9285-742058f87deb
			//driver.getAppStringMap();
			//Map<String, String> stringMap = driver.getAppStringMap(Locale.getDefault().getLanguage());
			//Map<String, String> stringMap = driver.getAppStringMap();
			//Set<String> keys = stringMap.keySet();
			
			//keys.forEach(x -> System.out.println(stringMap.get(x)));
			
			//ScreenOrientation orientation = driver.getOrientation();
			
			MobileElement element = null;
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
			TimeUnit.SECONDS.sleep(1);
			//driver.close();
			List<MobileElement> elements = null;
			By by = null;
			//driver.closeApp();
			
			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			// 点击头像
			by = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.myctrip:id/ivAvatar']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			TimeUnit.SECONDS.sleep(1);
			// 点击退出登录
			by = By.xpath("//android.widget.Button[@resource-id='ctrip.android.myctrip:id/myctrip_loginout_btn']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			// 点击确认退出
			by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.view:id/right_btn']");
			element = driver.findElement(by);
			element.click();	
			
			// 重置APP，清空缓存
			//driver.resetApp();
			// 
			//driver.quit();
			
			
			
		} catch (Exception e) {
			log.error("testLogout =====> ", e);
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
		driver = driverWithApp();
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
