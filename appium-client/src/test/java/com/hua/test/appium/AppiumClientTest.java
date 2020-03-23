/**
 * 描述: 
 * AppiumClientTest.java
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

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hua.test.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;


/**
 * 描述: appium (Java)客户端
 * 
 * @author qye.zheng
 * AppiumClientTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class AppiumClientTest extends BaseTest {

	
	/**
	 * 一个手机 只能跟一个 客户端建立会话，后来发起的将中断前面的会话.
	 * 
	 * 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testAppiumClient() {
		try {
			//File app  = new File("C:\\Users\\dell\\AppData\\Local\\Temp\\ctripA.apk");
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(true));
			// 会话ID，每次连接生成一个，22e4db34-2daa-4c06-9285-742058f87deb
			//System.out.println(driver.getSessionId());
			
			// 
			//driver.quit();
			
			// 设备时间
			// System.out.println(driver.getDeviceTime());
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.score(capabilities(true));
			AppiumDriverLocalService.buildService(builder);
			// 
			//AppiumDriverLocalService localService = AppiumDriverLocalService.buildDefaultService(builder);
			AppiumDriverLocalService localService = AppiumDriverLocalService.buildService(builder);
			//localService.start();
			//localService.start();

			
			//localService.stop();
			
		} catch (Exception e) {
			log.error("testAppiumClient =====> ", e);
		}
	}
	
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
	public void testFindByXPath() {
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
			//driver.closeApp();
/*			By by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.view:id/tab_title']");
			elements = driver.findElements(by);
			System.out.println(elements.size());
			
			for (MobileElement e : elements) {
				System.out.println(e.getText());
			}*/
			By by = null;
			// 点击第一个元素，账号输入框
			by = By.xpath("//android.widget.EditText");
			elements = driver.findElements(by);
			// 点击
			//element.click();
			//element.sendKeys("15018750788");
			
			elements.get(0).sendKeys("15018750787");
			
			elements.get(1).sendKeys("a123b456");
			
			by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.login:id/rlLoginBtn']/android.widget.Button");
			element = driver.findElement(by);
			element.click();
			//
			
/*			for (MobileElement e : elements) {
				System.out.println(e.getText());
			}*/
			
			
			
			//driver.getKeyboard().pressKey("15018750711");
			
			
			// 重置APP，清空缓存
			//driver.resetApp();
			// 
			//driver.quit();
			
			
			
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
	public void testGetAppString() {
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
			driver.findElementByClassName("cpt-choose-box cpt-choose-box-pop");
			//element = driver.findElementByClassName("android.widget.ImageView");
			//element = driver.findElementByXPath("/div[@class=' cpt-choose-box cpt-choose-box-pop']");
			System.out.println(element.getText());
			//driver.getKeyboard().pressKey("A");
			
			
			//driver.rotation();
			
			//System.out.println(orientation.name() + ", " + orientation.ordinal());
			
			//driver.close();
			
			//driver.closeApp();
		
			
			// 重置APP，清空缓存
			//driver.resetApp();
			// 
			//driver.quit();
			
			
			
		} catch (Exception e) {
			log.error("testAppiumClient =====> ", e);
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
	public void testAppiumDriver() {
		try {
			//File app  = new File("C:\\Users\\dell\\AppData\\Local\\Temp\\ctripA.apk");
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(true));
			// 会话ID，每次连接生成一个，22e4db34-2daa-4c06-9285-742058f87deb
			
			//localService.stop();
			
			// 退出目标 APP
			//driver.quit();
			
		} catch (Exception e) {
			log.error("testAppiumDriver =====> ", e);
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
	public void testTouch() {
		try {
			//File app  = new File("C:\\Users\\dell\\AppData\\Local\\Temp\\ctripA.apk");
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(true));
				
			// 
			TouchAction<AndroidTouchAction> action = new TouchAction<>(driver);
			MobileElement element = null;
			//element = driver.findElementById("ba4defec-e8dd-43f0-9672-03235e355cbb");
			//element = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ImageView");
			//action.tap(TapOptions.tapOptions()).perform();
			//element.click();
			Point point = null;
			// 	[0,0][720,393]
			point = new Point(720, 393);
			//
			action.press(PointOption.point(point)).perform();
			
			
			// 释放
			//action.release();
			
			// 取消
			//action.cancel();
			
			//localService.stop();
			
			// 退出目标 APP
			//driver.quit();
			
		} catch (Exception e) {
			log.error("testTouch =====> ", e);
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
	public void testAppiumServiceBuilder() {
		try {
			URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
			//AppiumDriver<MobileElement> driver = new AppiumDriver<>(appiumServerUrl, capabilities);
			// 会话ID，每次连接生成一个，22e4db34-2daa-4c06-9285-742058f87deb
			//System.out.println(driver.getSessionId());
			
			// 设备时间
			// System.out.println(driver.getDeviceTime());
			AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(capabilities(true))
					.withIPAddress("127.0.0.1").usingPort(4723);
/*			builder.usingPort(4723);
			builder.withIPAddress("127.0.0.1");
			builder.score(capabilities);*/
			// 
			AppiumDriverLocalService localService = builder.build();
			//localService.start();
			//localService.start();
			
			
			//localService.stop();
			
		} catch (Exception e) {
			log.error("testAppiumServiceBuilder =====> ", e);
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
	public void testAppiumClient2() {
		try {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			capabilities.setCapability(MobileCapabilityType.APP, "");
			//capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
			URL appiumServerUrl = new URL("http://127.0.0.1:4327/wd/hub");
			AppiumDriver<MobileElement> driver = new AppiumDriver<>(appiumServerUrl, capabilities);
			
			// 
			AppiumDriverLocalService localService = AppiumDriverLocalService.buildDefaultService();
			
			localService.start();
			
			localService.stop();
			
		} catch (Exception e) {
			log.error("testAppiumClient2 =====> ", e);
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
			System.out.println(Locale.getDefault().getDisplayName());
			System.out.println(Locale.getDefault().getLanguage());
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
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
