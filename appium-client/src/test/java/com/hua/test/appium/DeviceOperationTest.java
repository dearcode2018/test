/**
 * 描述: 
 * DeviceOperationTest.java
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
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver.ImeHandler;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.html5.Location;

import com.hua.test.BaseTest;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;

import io.appium.java_client.appmanagement.ApplicationState;


/**
 * 描述: 设备操作
 * 
 * @author qye.zheng
 * DeviceOperationTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class DeviceOperationTest extends BaseTest {

	
	/**
	 * 
	 * 描述: APP 状态 (安装/运行)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testAppState() {
		try {
			/*
			 *     NOT_INSTALLED(没安装), NOT_RUNNING(没运行), RUNNING_IN_BACKGROUND_SUSPENDED (限制性 后台运行),
			 *     RUNNING_IN_BACKGROUND (后台运行), RUNNING_IN_FOREGROUND (前台运行)
			 */
			ApplicationState state = driver.queryAppState(bundleId);
			System.out.println(state.name() + ", " + state.ordinal());
		} catch (Exception e) {
			log.error("testAppState =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 激活APP (没有运行的，开启运行；在后台运行的，切换到前台运行)
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testActivateApp() {
		try {
			driver.activateApp(bundleId);
			
		} catch (Exception e) {
			log.error("testActivateApp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 安装APP
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testInstallApp() {
		try {
			/*
			 * 安装app
			 * 提供本地路径
			 */
			String path = "D:/Program Files/leidian/LDPlayer/leidian/apk/weixin.apk";
			
			driver.installApp(path);
			
		} catch (Exception e) {
			log.error("testInstallApp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 卸载APP
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testUninstallApp() {
		try {
			/*
			 * String bundleId; 要卸载的app的id，等于app的appPackage值
			 */
			//driver.removeApp("ctrip.android.view");
			// 卸载微信
			driver.removeApp("com.tencent.mm");
			
		} catch (Exception e) {
			log.error("testUninstallApp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 检测是否已安装
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testCheckInstalled() {
		try {
			//bundleId = "abc";
			// 等于app的appPackage值
			System.out.println(driver.isAppInstalled(bundleId));
			
		} catch (Exception e) {
			log.error("testCheckInstalled =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 设备定位
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testLocation() {
		try {
			TimeUnit.SECONDS.sleep(3);
			/*
			 * getTitle() 不支持 该指令
			 * Could not proxy command to remote server. Original error: 404 - ""
			 * 
			 */
			//System.out.println(driver.getTitle());
			//System.out.println(driver.getContext());
			/*
			 * 异常: 可能是当前appium暂不支持或有缺陷
			 * java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.Double
			 */
			Location location = driver.location();
			// longitude: 经度，latitude: 维度，altitude: 海拔高度
			System.out.println("altitude: " + location.getAltitude() + ", longitude: " + location.getLongitude() + ",  latitude: " + location.getLatitude());

			
		} catch (Exception e) {
			log.error("testLocation =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 管理员选项
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testManage() {
		try {
			
			Options options = driver.manage();
			// 添加cookie，在浏览器中
			//options.addCookie(null);
			ImeHandler ime = options.ime();
			System.out.println(ime.toString());
			
			System.out.println(ime.getActiveEngine());
			
			System.out.println(ime.isActivated());
			

			
		} catch (Exception e) {
			log.error("testManage =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 重启机器
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testRebootMachine() {
		try {
			
			
		} catch (Exception e) {
			log.error("testRebootMachine =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 上传文件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testUploadFile() {
		try {

			
		} catch (Exception e) {
			log.error("testUploadFile =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 拉取文件
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testPullFile() {
		try {
			// /storage/emulated/
			// APP存储路径
			String path = "/storage/emulated/0/Pictures/Screenshots/Screenshot_20200323-114317.png";
			byte[] data = driver.pullFile(path);
			File file = new File(ProjectUtil.getAbsolutePath("/doc/image.png"));
			FileUtil.writeByteArray(file, data);
			
		} catch (Exception e) {
			log.error("testPullFile =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 拉取目录
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testPullFolder() {
		try {
			// APP存储路径
			String path = "/storage/emulated/0/Download/accs";
			// A byte array of Base64 encoded zip archive data.
			byte[] data = driver.pullFolder(path);
			// 存储为zip压缩文件
			File file = new File(ProjectUtil.getAbsolutePath("/doc/accs.zip"));
			FileUtil.writeByteArray(file, data);
			
		} catch (Exception e) {
			log.error("testPullFolder =====> ", e);
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
	public void testGet() {
		try {
			/*
			 * 现状: 
			 * An unknown server-side error occurred while processing the command. Original error: URI and package arguments are required
			 */
			String url = "https://www.baidu.com";
			driver.get(url);
			
		} catch (Exception e) {
			log.error("testGet =====> ", e);
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
	public void testGetCurrentUrl() {
		try {
			/*
			 * 现状:  Method has not yet been implemented
			 */
			String url = driver.getCurrentUrl();
			System.out.println(url);
		} catch (Exception e) {
			log.error("testGetCurrentUrl =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取设备的日期时间
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testGetDeviceTime() {
		try {
			//参考格式: YYYY-MM-DDTHH:mm:ssZ
			System.out.println(driver.getDeviceTime());
			System.out.println(driver.getDeviceTime("YYYY-MM-DD"));
			System.out.println(driver.getDeviceTime("YYYY-MM-DD HH:mm:ssZ"));
		} catch (Exception e) {
			log.error("testGetDeviceTime =====> ", e);
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
	public void testErrorHandler() {
		try {
			driver.setErrorHandler(null);
			
		} catch (Exception e) {
			log.error("testErrorHandler =====> ", e);
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
	public void testGetExecuteMethod() {
		try {
			// 执行指令
			// driver.getExecuteMethod().execute(bundleId, null);
			
		} catch (Exception e) {
			log.error("testGetExecuteMethod =====> ", e);
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
	public void testFileDector() {
		try {
			//driver.setFileDetector(null);
			
		} catch (Exception e) {
			log.error("testFileDector =====> ", e);
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
			// 获取当前页面源码
			System.out.println(driver.getPageSource());
			
		} catch (Exception e) {
			log.error("testGetPageSource =====> ", e);
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
	public void testGetWindowHandle() {
		try {
			/*
			 * Proxy error: Could not proxy command to remote server. Original error: 404 - ""
			 */
			System.out.println(driver.getWindowHandle());
			Set<String> handles = driver.getWindowHandles();
			handles.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testGetWindowHandle =====> ", e);
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
	public void testGetOrientation() {
		try {
			
			ScreenOrientation orientation = driver.getOrientation();
			System.out.println(orientation.name());
			
		} catch (Exception e) {
			log.error("testGetOrientation =====> ", e);
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
	public void testGetRemoteAddress() {
		try {
			URL url = driver.getRemoteAddress();
			System.out.println(url.getPath() + ", " + url.toString());
		} catch (Exception e) {
			log.error("testGetRemoteAddress =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 重置输入状态
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testResetInputState() {
		try {
			driver.resetInputState();
		
		} catch (Exception e) {
			log.error("testResetInputState =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 设置客户端日志级别
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSetLogLevel() {
		try {
			// 默认为 fine级别
			driver.setLogLevel(Level.WARNING);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 终止APP的运行
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testTerminateApp() {
		try {
			/*
			 * 和quit/closeApp 功能类似
			 * 终止指定的APP
			 */
			boolean flag = false;
			flag = driver.terminateApp(bundleId);
			System.out.println(flag);
		} catch (Exception e) {
			log.error("testTerminateApp =====> ", e);
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
