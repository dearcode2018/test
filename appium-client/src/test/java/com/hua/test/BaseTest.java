/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hua.log.BaseLog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith(JUnitPlatform.class)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@DisplayName("BaseTest")
public class BaseTest extends BaseLog {
	

	protected AppiumDriver<MobileElement> driver;
	
	protected String bundleId = "ctrip.android.view";
	
	protected static final String RESOURCE_ID = "resource-id";
	
	protected static final String INDEX = "index";
	
	protected By by;
	
	protected MobileElement element;
	
	/**
	 * 
	 * @description 打开指定APP
	 * @return
	 * @author qianye.zheng
	 */
	protected final AppiumDriver<MobileElement> driverWithApp() {
		URL serverUrl = null;
		try
		{
			serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(true));
		// 搜索元素的超时时间
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	/**
	 * 
	 * @description 不打开指定APP
	 * @return
	 * @author qianye.zheng
	 */
	protected final AppiumDriver<MobileElement> driver() {
		URL serverUrl = null;
		try
		{
			serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities(false));
		// 搜索元素的超时时间
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	/**
	 * 
	 * @description 能力构建
	 * @param openApp 是否打开APP
	 * @return
	 * @author qianye.zheng
	 */
	protected final DesiredCapabilities capabilities(final boolean openApp) {
		// 期望的能力
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		// 自动化类型，默认是 appium
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
		// 避免每次客户端启动 手机重复安装相关软件 (appium settings 和 目标app)
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		// 移动浏览器，Safari' for iOS and 'Chrome', 'Chromium', or 'Browser' for Android
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "127.0.0.1:5555");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// 指令执行超时时间
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
		// 是否报告时间耗时，默认false
		capabilities.setCapability(MobileCapabilityType.EVENT_TIMINGS, false);
		// 是否完全恢复(会话完成卸载响应APP)，默认false
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		
		//capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, "");
		capabilities.setCapability("uiautomator2ServerInstallTimeout", 300 * 1000);
		// adb执行 超时时间 (毫秒)
		capabilities.setCapability("adbExecTimeout", 300 * 1000);
		
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		// app 和 appPackage/appActivity 2者是等同的
		//capabilities.setCapability(MobileCapabilityType.APP, "");
		// 安卓平台特有的属性，待测试的app的java package
		// 允许在该设备安装APP
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, false);
		// AVD 启动和连接ADB超时时间，毫秒
		capabilities.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 120 * 1000);
		
		// APP 打开超时时间，毫秒
		capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 20 * 1000);
		// 设备准备好超时时间，秒
		capabilities.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, 120);
		// webview 加载完毕超时时间，毫秒
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_WEBVIEW_TIMEOUT, 60 * 1000);
		// APK安装时间，毫秒
		capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 90 * 1000);
		
		if (openApp) {
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ctrip.android.view");
			// 安卓平台特有的属性，原生app要在前面加一个 "."
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ctrip.business.splash.CtripSplashActivity");
		} else { // 不打开
			capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, "ctrip.android.view");
			// 安卓平台特有的属性，原生app要在前面加一个 "."
			capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "ctrip.business.splash.CtripSplashActivity");
		}
		// 是否使用Unicode编码方式发送字符串，设置为false，避免修改手机的输入法
		capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, false);
		// 是否隐藏系统键盘
		// 是否重置键盘
		capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		
		// 不启动目标APP
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, "ctrip.android.view");
		// 安卓平台特有的属性，原生app要在前面加一个 "."
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "ctrip.business.splash.CtripSplashActivity");
		
		
		
		// 无需再次签名
		capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, "true");
		// 设备ID
		//capabilities.setCapability(MobileCapabilityType.UDID, "");
		
		//capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
		
		return capabilities;
	}
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeClass")
	@BeforeAll
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterClass")
	@AfterAll
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
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
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}

}
