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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hua.log.BaseLog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
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
	
	/**
	 * 
	 * @description 
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
		AppiumDriver<MobileElement> driver = new AppiumDriver<>(serverUrl, capabilities());
		
		return driver;
	}
	
	/**
	 * 
	 * @description 能力构建
	 * @return
	 * @author qianye.zheng
	 */
	protected final DesiredCapabilities capabilities() {
		// 期望的能力
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// 自动化类型，默认是 appium
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
		// 避免每次客户端启动 手机重复安装相关软件 (appium settings 和 目标app)
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		// 移动浏览器，Safari' for iOS and 'Chrome', 'Chromium', or 'Browser' for Android
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, "");
		// adb执行 超时时间 (毫秒)
		capabilities.setCapability("uiautomator2ServerInstallTimeout", 300 * 1000);
		capabilities.setCapability("adbExecTimeout", 300 * 1000);
		
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		// app 和 appPackage/appActivity 2者是等同的
		//capabilities.setCapability(MobileCapabilityType.APP, "");
		// 安卓平台特有的属性，待测试的app的java package
		// 允许在该设备安装APP
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, false);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ctrip.android.view");
		// 安卓平台特有的属性，原生app要在前面加一个 "."
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ctrip.business.splash.CtripSplashActivity");
		// 使用Unicode编码方式发送字符串
		capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		// 是否隐藏系统键盘
		capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);
		
		
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
