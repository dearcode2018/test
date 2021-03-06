/**
 * 描述: 
 * AppCommonTest.java
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

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.hua.test.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


/**
 * 描述: APP 公共操作
 * 
 * @author qye.zheng
 * AppCommonTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class AppCommonTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 屏幕上滑
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSlideUp() {
		try {
			/*
			 * longPress() 指定开始的位置，长按
			 * moveTo() 指定目标位置，移动
			 * 
			 * x/y轴以左上角为原点
			 * 上滑: y坐标终点比起点小
			 * 
			 * 下滑: y坐标终点比起点大
			 * 
			 * 注意: 页面上的起始坐标 要选择可以执行滑动的，有些位置是不能滑动的.
			 * 
			 */
			//new TouchAction<>(driver).longPress(PointOption.point(360, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
			
			Dimension size = driver.manage().window().getSize();
			int height = size.height;
			int width = size.width;
			System.out.println("height = " + height + ", width = " + width);
			//new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100)).moveTo(PointOption.point(height / 2, 100)).release().perform();
			new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(width / 2, height - 300)).release().perform();
		} catch (Exception e) {
			log.error("testSlideUp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 屏幕(手势)下滑
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSlideDown() {
		try {
			/*
			 * longPress() 指定开始的位置，长按
			 * moveTo() 指定目标位置，移动
			 * 
			 * x/y轴以左上角为原点
			 * 上滑: y坐标终点比起点小
			 * 
			 * 下滑: y坐标终点比起点大
			 * 
			 * 注意: 页面上的起始坐标 要选择可以执行滑动的，有些位置是不能滑动的.
			 * 
			 */
			Dimension size = driver.manage().window().getSize();
			int height = size.height;
			int width = size.width;
			System.out.println("height = " + height + ", width = " + width);
			//new TouchAction<>(driver).longPress(PointOption.point(height / 2, 500)).moveTo(PointOption.point(width / 2, height - 100)).release().perform();
			new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 300))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(width / 2, height - 100)).release().perform();
			
		} catch (Exception e) {
			log.error("testSlideDown =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 打开APP
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testOpenApp() {
		try {
			/*
			 * 关闭APP之后， 再次打开，调用此方法
			 * 
			 */
			driver.launchApp();
			
			
			//driver.closeApp();
			
			//driver.launchApp();
			
			
/*			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			// 点击
			element.click();*/
			
		} catch (Exception e) {
			log.error("testOpenApp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 关闭APP
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testCloseApp() {
		try {
			// 休眠若干秒，等待APP准备就绪
			TimeUnit.SECONDS.sleep(2);
			/*
			 * 退出运行(包括前台和后台)
			 * 关闭APP
			 * 退出到APP桌面
			 * 若app已处于关闭状态，不会抛异常
			 */
			driver.closeApp();
			/*
			 *  不支持该指令，command. Original error: Could not proxy. Proxy error: Could not proxy command 
			 *  to remote server. Original error: 404 - undefined
			 */
			//driver.close();
			
		} catch (Exception e) {
			log.error("testCloseApp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 首次打开 (APP欢迎页，点击授权、允许)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFistOpen() {
		try {
			/*
			 * APP欢迎页，点击授权、允许
			 * 判断是否是第一次打开，然后在针对APP启动过程中的提示，逐个处理
			 */
			// 休眠若干秒，等待APP准备就绪
			TimeUnit.SECONDS.sleep(2);
			MobileElement element = null;
		
			By by = null;
			//driver.closeApp();
			by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.view:id/common_boot_permission_positive_btn' and @text='同意并继续']");
			// 捕获 元素找不到异常
			try
			{
				element = driver.findElement(by);
			} catch (NoSuchElementException e)
			{ // 找不到元素，说明不是首次打开
				e.printStackTrace();
				return;
			}
			// 首次打开
			// 点击 同意
			element.click();
			
			TimeUnit.SECONDS.sleep(1);
			// 获取多少项
			by = By.xpath("//android.widget.TextView[@resource-id='com.android.packageinstaller:id/current_page_text' and contains(@text, '项')]");
			element = driver.findElement(by);
			// 出去数字，看后面有多少项需要允许的
			String text = element.getText();
			Pattern pattern = Pattern.compile("第 1 项权限（共 (\\d+) 项）");
			Matcher matcher = pattern.matcher(text);
			Integer count = 0;
			if (matcher.matches()) {
				count = Integer.valueOf(matcher.group(1));
			}
			
			for (int i = 0; i < count; i++) {
				// 允许
				by = By.xpath("//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']");
				element = driver.findElement(by);
				element.click();
				TimeUnit.SECONDS.sleep(1);
			}
			
		} catch (Exception e) {
			log.error("testFistOpen =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 检测是否打开
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testCheckOpened() {
		try {
			/*
			 * getTitle() 不支持 该指令
			 * Could not proxy command to remote server. Original error: 404 - ""
			 * 
			 */
			//System.out.println(driver.getTitle());
			//System.out.println(driver.getContext());
			TimeUnit.SECONDS.sleep(3);
			//System.out.println(driver.getPageSource());
	
		} catch (Exception e) {
			log.error("testCheckOpened =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 收起键盘
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testHideKeyboard() {
		try {
			/*
			 * getTitle() 不支持 该指令
			 * Could not proxy command to remote server. Original error: 404 - ""
			 * 
			 */
			//System.out.println(driver.getTitle());
			//System.out.println(driver.getContext());
			//TimeUnit.SECONDS.sleep(3);
			//System.out.println(driver.getPageSource());
			driver.hideKeyboard();
			
			
			
		} catch (Exception e) {
			log.error("testHideKeyboard =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 是否是 原生页面 还是H5
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testIsBrowser() {
		try {
			/*
			 * getTitle() 不支持 该指令
			 * Could not proxy command to remote server. Original error: 404 - ""
			 * 
			 */
			//System.out.println(driver.getTitle());
			//System.out.println(driver.getContext());
			TimeUnit.SECONDS.sleep(3);
			//System.out.println(driver.getPageSource());
			System.out.println(driver.isBrowser());
			
			
		} catch (Exception e) {
			log.error("testIsBrowser =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取页面源码，可以通过解析XML实现功能
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testGetPageSource() {
		try {
			/*
			 * getTitle() 不支持 该指令
			 * Could not proxy command to remote server. Original error: 404 - ""
			 * 
			 */
			//System.out.println(driver.getTitle());
			//System.out.println(driver.getContext());
			TimeUnit.SECONDS.sleep(3);
			// 获取当前页面源码
			System.out.println(driver.getPageSource());
			
		} catch (Exception e) {
			log.error("testGetPageSource =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 后台运行APP
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testRunBackground() {
		try {
			/*
			 * 指定app后台运行的时间，到时间后，会切换回前台运行
			 * 在特定场景下 能发挥作用
			 */
			driver.runAppInBackground(Duration.ofSeconds(5));
			
		} catch (Exception e) {
			log.error("testRunBackground =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 退出APP (返回桌面首页)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testQuit() {
		try {
			// 休眠若干秒，等待APP准备就绪
			TimeUnit.SECONDS.sleep(2);
			// 也是退出APP，和closeApp()方法相同
			/*
			 * 退出运行(包括前台和后台)
			 */
			driver.quit();
			
		} catch (Exception e) {
			log.error("testQuit =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 强制退出APP (杀掉进程)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testKill() {
		try {
			
			
		} catch (Exception e) {
			log.error("testKill =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 重置APP (清空缓存)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testRest() {
		try {
			// 
			driver.resetApp();
			
		} catch (Exception e) {
			log.error("testRest =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 后退一步 (返回上一步)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testGoBack() {
		try {
			
			TimeUnit.SECONDS.sleep(3);
			MobileElement element = null;
			By by = null;
			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			TimeUnit.SECONDS.sleep(2);
			// 返回上一步
			driver.navigate().back();
			
			TimeUnit.SECONDS.sleep(2);
			/*
			 *  processing the command. Original error: Could not proxy. Proxy error: Could not proxy command to remote server. 
			 *  Original error: 404 - undefined
			 */
			// 前进上一步，不支持
			//driver.navigate().forward();
			
			
		} catch (Exception e) {
			log.error("testGoBack =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 单击
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSingleClick() {
		try {
			TimeUnit.SECONDS.sleep(3);
			MobileElement element = null;
			By by = null;
			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
		} catch (Exception e) {
			log.error("testSingleClick =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 双击
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDoubleClick() {
		try {
			
			
		} catch (Exception e) {
			log.error("testDoubleClick =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 长按
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testLongPress() {
		try {
			TimeUnit.SECONDS.sleep(3);
			
		} catch (Exception e) {
			log.error("testLongPress =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 键盘
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testKeyBoard() {
		try {
			/**
			 * 在当前输入框，或者指定的元素执行按键操作，直接发送指定的字符串
			 */
			driver.getKeyboard().pressKey("");
			
		} catch (Exception e) {
			log.error("testKeyBoard =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 重启APP
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testRebootApp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testRebootApp =====> ", e);
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
	public void testSearch() {
		try {
			TimeUnit.SECONDS.sleep(3);
			MobileElement element = null;
			By by = null;
			//driver.closeApp();
			by = By.xpath("//android.widget.FrameLayout[@resource-id='ctrip.android.publicproduct:id/home_search_text']/android.widget.TextView");
			element = driver.findElement(by);
			System.out.println(element.getText());
/*			Map<String, Object> map = element.toJson();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				System.out.println(key + ", " + map.get(key).toString());
			}*/
			//System.out.println(element.toString());
			
			// 获取元素指定的属性值
			// element.getAttribute("");
			
			// 继续找下一级元素
			//element.findElement(by);
			// annot set the element to '哈哈哈'. Did you interact with the correct element?
			//element.setValue("哈哈哈");
			
			element.click();
			
			TimeUnit.SECONDS.sleep(1);
			by = By.xpath("//android.widget.EditText[@resource-id='ctrip.android.search:id/search_main_input']");
			element = driver.findElement(by);
			element.sendKeys("北京7天酒店");
			
			// 搜索按钮
			by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.search:id/search_right_search_btn']");
			element = driver.findElement(by);
			element.click();
			
			// 返回上一步
			driver.navigate().back();
			
		} catch (Exception e) {
			log.error("testSearch =====> ", e);
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
	public void testActivateApp() {
		try {
			System.out.println("AppCommonTest.testActivateApp()");
			driver.activateApp(bundleId);
			
			//driver.launchApp();
			
			System.out.println("AppCommonTest.testActivateApp()");
			driver.closeApp();
			
		} catch (Exception e) {
			log.error("testActivateApp =====> ", e);
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
			MobileElement element = null;
			element = driver.findElementByXPath("//android.widget.TextView[@text='我的']");
			// 点击
			element.click();
			
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
		//driver = driverWithApp();
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
		// 关闭
		//driver.close();
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
