/**
 * 描述: 
 * CtripAPPTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.demo;

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
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;

import com.hua.test.BaseTest;
import com.hua.util.AppiumUtil;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


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

	/* 最大等待时间，单位: 毫秒 */
	private Integer maxWaitMillisecond = 10 * 1000;
	
	protected MobileElement element;
	
	/**
	 * 
	 * 描述: 忽略更新
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testIgnoreUpdate() {
		try {
			// class="android.widget.TextView" text="立即升级" resource-id="ctrip.android.publicproduct:id/upgrade_confirm"
			//By by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.publicproduct:id/upgrade_confirm']");
			By by = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.publicproduct:id/upgrade_cancel']");
			// 点击关闭升级对话框
			AppiumUtil.opt(driver, by).ifPresent(MobileElement :: click);
			// 后退一步，退回 首页
			//AppiumUtil.opt(driver, by).ifPresent(x -> driver.navigate().back());
			
		} catch (Exception e) {
			log.error("testIgnoreUpdate =====> ", e);
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
			by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			//byte[] value = driver.findElements(by).get(2).getScreenshotAs(OutputType.BYTES);
			//System.out.println(value);
			//FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/imageHui.png"), value);
			//String imageBase64 = driver.findElements(by).get(2).getScreenshotAs(OutputType.BASE64);
			//System.out.println(imageBase64);
			//File file = new File(ProjectUtil.getAbsolutePath("/doc/imageHui.png"));
			// 房型名称
			final By nameBy = By.xpath("//android.widget.TextView[resource-id='ctrip.android.hotel.detail:id/room_item_name']");
			String target = "1.8米床Loft格调家庭房AR";
			// 截取当前屏幕
			//String str = driver.findElements(by).get(3).getScreenshotAs(OutputType.BASE64);
			List<MobileElement> elements = driver.findElements(by);
			elements.forEach(x -> {
				if (target.equals(x.findElement(nameBy).getText())) { //
					System.out.println(x.getScreenshotAs(OutputType.BASE64));
				}
			});
			//final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			// 输出
			//System.out.println(str);
			//System.out.println(cache.contentEquals(str));
			//File value = driver.findElements(by).get(2).getScreenshotAs(OutputType.FILE);
			//SimilarityMatchingResult result = driver.getImagesSimilarity(file, value);
			//OccurrenceMatchingResult result = driver.findImageOccurrence(file, value);
			//System.out.println(result.getVisualization());
		} catch (Exception e) {
			log.error("testFindImage =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 输出目标图像的base64
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void printImageBase64() {
		try {
			By by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			//byte[] value = driver.findElements(by).get(2).getScreenshotAs(OutputType.BYTES);
			//System.out.println(value);
			//FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/imageHui.png"), value);
			//String imageBase64 = driver.findElements(by).get(2).getScreenshotAs(OutputType.BASE64);
			//System.out.println(imageBase64);
			//File file = new File(ProjectUtil.getAbsolutePath("/doc/imageHui.png"));
			// 房型名称
			final By nameBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_name']");
			String target = "1.8米床Loft格调家庭房AR";
			// 截取当前屏幕
			/*
			 * final List<MobileElement> elements = driver.findElements(by);
			 * elements.forEach(x -> { if (target.equals(x.findElement(nameBy).getText())) {
			 * // 输出目标元素的base64 System.out.println(x.getScreenshotAs(OutputType.BASE64)); }
			 * });
			 */
			//final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			String str = null;
			str = driver.findElements(by).get(2).getScreenshotAs(OutputType.BASE64);
			// 输出
			System.out.print(str);
			
			//System.out.println(cache.contentEquals(str));
			//File value = driver.findElements(by).get(2).getScreenshotAs(OutputType.FILE);
			//SimilarityMatchingResult result = driver.getImagesSimilarity(file, value);
			//OccurrenceMatchingResult result = driver.findImageOccurrence(file, value);
			//System.out.println(result.getVisualization());
		} catch (Exception e) {
			log.error("printImageBase64 =====> ", e);
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
	public void testElementMove() {
		try {
			/*
			 * 
			 */
			Rectangle rect = null;
			by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/special_peacock_room_layout']");
			element = driver.findElement(by);
			rect = element.getRect();
			// x, y是该元素的起始坐标(左上角)
			System.out.println("x = " + rect.getX() + ", y = " + rect.getY() + ", width = " + rect.getWidth() + ", height = " + rect.getHeight());
			
			// 移动不了
			//element.getLocation().move(rect.getX(), rect.getY() - rect.getHeight());
			// 差值，移动的时候增加或减少移动的像素 DPI: 每英寸点数（dots per inch ）
			int differenceDPI = 3;
			new TouchAction<>(driver).longPress(PointOption.point(element.getCenter()))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(rect.getX(), rect.getY() - rect.getHeight() - differenceDPI)).release().perform();
			
			// 获取第一个房型，后面的房型 index + 1即可
			by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/ctrip.android.hotel.detail:id/mBasicRoomItem']");
			element = AppiumUtil.get(driver, by);
			Integer index = null;
			while (null != element) { // 存在则继续往下探索
				// 输出 房间 物理信息
				printPhysic(element);
				// 点击 下拉箭头
				by = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.hotel.detail:id/base_room_arrow']");
				// 点击展开
				AppiumUtil.opt(element, by).ifPresent(x -> {
					x.click();
					// 查找第一个单元房型
					by = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item' and @index>0]");
					MobileElement elementRt = AppiumUtil.get(driver, by);
					Integer subIndex = null;
					while (null != elementRt) {
						// 输出单元房型信息
						printUniRoomType(elementRt);
						if (null == subIndex) {
							subIndex = Integer.valueOf(elementRt.getAttribute(INDEX));
						}
						// 下一个
						subIndex++;
						by = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item' and @index=" + subIndex + "]");
						elementRt = AppiumUtil.get(driver, by);
					}
				});
				// 不用展开的，直接读取
				
				
				if (null == index) {
					index = Integer.valueOf(element.getAttribute(INDEX));
				}
				// 下一个
				index++;
				by = By.xpath("//android.widget.LinearLayout[@resource-id='ctrip.android.hotel.detail:id/ctrip.android.hotel.detail:id/mBasicRoomItem']");
				element = AppiumUtil.get(driver, by);
			}
			
		} catch (Exception e) {
			log.error("testElementMove =====> ", e);
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
	@Deprecated
	public void testFetch_temp() {
		try {
			/**
			 * 
			 * 
			 */
			// 搜索控件
			by = By.xpath("//android.widget.LinearLayout[@resource-id='ctrip.android.hotel.detail:id/room_filter_container']");
			element = driver.findElement(by);
			
			int y = element.getRect().getY();
			
			//Rectangle rect = null;
			by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/special_peacock_room_layout']");
			element = driver.findElement(by);
			//rect = element.getRect();
			// x, y是该元素的起始坐标(左上角)
			//System.out.println("x = " + rect.getX() + ", y = " + rect.getY() + ", width = " + rect.getWidth() + ", height = " + rect.getHeight());
			
			// 移动不了
			//element.getLocation().move(rect.getX(), rect.getY() - rect.getHeight());
			// 差值，移动的时候增加或减少移动的像素 DPI: 每英寸点数（dots per inch ）
			int differenceDPI = 600;
			new TouchAction<>(driver).longPress(PointOption.point(element.getCenter()))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			//.moveTo(PointOption.point(element.getRect().getX(), element.getRect().getY() - element.getRect().getHeight() - differenceDPI)).release().perform().waitAction();
			.moveTo(PointOption.point(element.getRect().getX(), y - element.getRect().getHeight() - differenceDPI)).release().perform().waitAction();
			
			// 获取房型列表，舍弃最后一个房型，避免数据不全
			
			by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/mBasicRoomItem']");
			element = AppiumUtil.get(driver, by);
			while (null != element) { // 存在则继续往下探索
				// 输出 房间 物理信息
				printPhysic(element);
				// 点击 下拉箭头
				by = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.hotel.detail:id/base_room_arrow']");
				// 点击展开
				AppiumUtil.opt(element, by).ifPresent(MobileElement :: click);
				// 查找第一个单元房型
				by = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item'][1]");
				MobileElement elementRt = AppiumUtil.get(driver, by);
				while (null != elementRt) {
					// 输出单元房型信息
					printUniRoomType(elementRt);
					// 屏幕上滑
					new TouchAction<>(driver).longPress(PointOption.point(elementRt.getCenter()))
					// 等待，避免加载缓慢
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(PointOption.point(elementRt.getRect().getX(), elementRt.getRect().getY() - elementRt.getRect().getHeight())).release().perform().waitAction();
					
					// 下一个
					by = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item'][1]");			
					elementRt = AppiumUtil.get(driver, by);
				}
				
				// 屏幕上滑
				new TouchAction<>(driver).longPress(PointOption.point(element.getCenter()))
				// 等待，避免加载缓慢
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(element.getRect().getX(), element.getRect().getY() - element.getRect().getHeight() - differenceDPI)).release().perform().waitAction();

				// 下一个
				by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/mBasicRoomItem']");
				element = AppiumUtil.get(driver, by);
			}
			
		} catch (Exception e) {
			log.error("testElementMove =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同时支持基础房型 和 单元房型平铺 的场景
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFetch() {
		try {
			final int width = driver.manage().window().getSize().getWidth();
			final int height = driver.manage().window().getSize().getHeight();
			// 屏幕上滑
			new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(width / 2, height - 400)).release().perform().waitAction();
			
			// 灰色预订图标
			final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			// 基础房型
			final Set<String> basicRoomTypes = new HashSet<>();
			// 单元房型
			final Set<String> uniRoomTypes = new HashSet<>();
			
			// 预订图标的路径
			final By iconBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			// 基础房型
			final By basicBy = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/mBasicRoomItem']");
			// 下拉箭头
			final By arrowBy = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.hotel.detail:id/base_room_arrow']");
			// 单元房型
			final By uniBy = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item']");
			// 查看全部房型
			final By moreBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/mHandle_peacock']");
			
			// 钟点房标题
			final By hourTitleBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_title']");
			// 查看全部钟点房型
			final By moreHourBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_expand_collpase']");
			// 
			int differenceValue = -1;
			// 是否展开了更多
			final AtomicBoolean showMore = new AtomicBoolean(false);
			// 基础房型抓取是否结束
			Boolean basicFinish = null;
			// 是否发现钟点房
			while (true) { // 基础房型
				MobileElement basicElement = null;
				final List<MobileElement> elements = driver.findElements(basicBy);
				basicElement = decide1(basicRoomTypes, elements);
				if (Boolean.TRUE.equals(basicFinish)) {
					break;
				}
				if (null != basicElement) {
					// 输出 房间 物理信息
					printPhysic(basicElement);
					// 点击 下拉箭头
					AppiumUtil.opt(basicElement, arrowBy).ifPresent(MobileElement :: click);
				}
				
				MobileElement lastElement = null;
				while (true) { // 单元房型
					final List<MobileElement> subs = driver.findElements(uniBy);
					MobileElement uniElement = null;
					if (null == lastElement) { // 为空，用基础房型的元素
						uniElement = decide2(basicElement, uniRoomTypes, subs);
					} else { // 使用最靠近的一个元素
						uniElement = decide2(lastElement, uniRoomTypes, subs);
					}
					if (null == uniElement || (null != lastElement && uniElement == lastElement)) { // 拿到同一个，结束当前基础房型下单元房型的抓取
						break;
					}
					final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
					if (null != hourElement) { // 发现钟点房
						// 跳出这次单元房型的抓取
						if (uniElement.getRect().getY() > hourElement.getRect().getY()) {
							break;
						}
					}
	
					lastElement = uniElement;
					// 展开更多
					if (!showMore.get()) {
						AppiumUtil.opt(driver, moreBy).ifPresent(x -> {
							x.click(); 
							showMore.set(true);});
					}
					
					//System.out.println("基础房型的y坐标 = " + element.getLocation().getY());
					// 输出单元房型的y坐标
					//System.out.println("基础单元房型的y坐标 = " + subElement.getLocation().getY());
					printUniRoomType(uniElement);
					// 是否可预订
					final String str = uniElement.findElement(iconBy).getScreenshotAs(OutputType.BASE64);
					if (cache.equals(str)) {
						System.out.println("不可预订");
					} else {
						System.out.println("可预订");
					}
					
					// 元素的高度决定移动的偏移值
					differenceValue = uniElement.getRect().getHeight() + 100 + 20;
					// 当前元素底下y坐标 距离 钟点房 标签 小于一定值时 小幅度上滑，差值 可配置，不同屏幕尺寸值不同
					if (null != hourElement && (hourElement.getRect().getY() - (uniElement.getRect().getY() + uniElement.getRect().getHeight()) < 50)) {
						differenceValue = 10;
						// 标记基础房型结束
						basicFinish = Boolean.TRUE;
					}
					// 屏幕上滑
					new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
					// 等待，避免加载缓慢
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));

				}
			}
			
			// 钟点房抓取
			final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
			if (null != hourElement) {
				String text = hourElement.getText();
				Pattern pattern = Pattern.compile("钟点房\\((\\d+)\\)");
				Matcher matcher = pattern.matcher(text);
				Integer number = 0;
				if (matcher.matches()) {
					number = Integer.valueOf(matcher.group(1));
					if (0 == number) { // 没有钟点房
						return;
					}
					if (1 == number) { // 只有一个钟点房，无需展开
					} else { // 展开更多
						AppiumUtil.opt(driver, moreHourBy).ifPresent(MobileElement :: click);
					}
					// 钟点房父元素
					MobileElement parentElement = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='ctrip.android.hotel:id/hour_room_list']"));
					//
					int time = 0;
					MobileElement lastElement = null;
					while (time < number) {
						final List<MobileElement> subs = parentElement.findElements(uniBy);
						MobileElement subElement = decide2(lastElement, uniRoomTypes, subs);
						// 输出钟点房信息
						printPhysic(subElement);
						time++;
						differenceValue = subElement.getRect().getHeight() + 100;
						// 屏幕上滑
						new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
						// 等待，避免加载缓慢
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
						.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
						lastElement = subElement;
					}
				}
			}
			
		} catch (Exception e) {
			log.error("testFetch =====> ", e);
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
	public void testCloseAdvertisement() {
		try {
			final By by = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.ad:id/dis_ad_close']");
			// 点击关闭升级对话框
			AppiumUtil.opt(driver, by).ifPresent(MobileElement :: click);		
		} catch (Exception e) {
			log.error("testCloseAdvertisement =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 基础房型 + 展开后的单元房型
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFetch01() {
		try {
			final int width = driver.manage().window().getSize().getWidth();
			final int height = driver.manage().window().getSize().getHeight();
			
			// 顶层房型
			final By by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/special_peacock_room_layout']");
			final MobileElement topElement = driver.findElement(by);
			final int startY = height - 10;
			int endY = startY -  topElement.getRect().getHeight();
			endY = height / 2 - 10;
			// 屏幕上滑
			new TouchAction<>(driver).longPress(PointOption.point(width / 2, startY))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(width / 2, endY)).release().perform().waitAction();
			
			// 灰色预订图标
			final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			// 基础房型
			final Set<String> basicRoomTypes = new HashSet<>();
			// 单元房型
			final Set<String> uniRoomTypes = new HashSet<>();
			
			// 预订图标的路径
			final By iconBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			// 基础房型
			final By basicBy = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/mBasicRoomItem']");
			// 下拉箭头
			final By arrowBy = By.xpath("//android.widget.ImageView[@resource-id='ctrip.android.hotel.detail:id/base_room_arrow']");
			// 单元房型
			final By uniBy = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item']");
			// 查看全部房型
			final By moreBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/mHandle_peacock']");
			
			// 钟点房标题
			final By hourTitleBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_title']");
			// 查看全部钟点房型
			final By moreHourBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_expand_collpase']");
			// 
			MobileElement basicElement = null;
			int differenceValue = -1;
			// 是否展开了更多
			final AtomicBoolean showMore = new AtomicBoolean(false);
			// 是否发现钟点房
			while (true) { // 基础房型
				final List<MobileElement> elements = driver.findElements(basicBy);
				basicElement = decide1(basicRoomTypes, elements);
				if (null == basicElement) {
					break;
				}
				// 输出 房间 物理信息
				printPhysic(basicElement);
				/*
				 * 点击 下拉箭头
				 * 下拉箭头 不一定有，对应场景是 有就展开，没有就直接视为单元房型
				 */
				AppiumUtil.opt(basicElement, arrowBy).ifPresent(MobileElement :: click);
				
				MobileElement lastElement = null;
				while (true) { // 单元房型
					final List<MobileElement> subs = driver.findElements(uniBy);
					MobileElement uniElement = null;
					if (null == lastElement) { // 为空，用基础房型的元素
						uniElement = decide2(basicElement, uniRoomTypes, subs);
					} else { // 使用最靠近的一个元素
						uniElement = decide2(lastElement, uniRoomTypes, subs);
					}
					if (null == uniElement || (null != lastElement && uniElement == lastElement)) { // 拿到同一个，结束当前基础房型下单元房型的抓取
						break;
					}
					final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
					if (null != hourElement) { // 发现钟点房
						// 跳出这次单元房型的抓取
						if (uniElement.getRect().getY() > hourElement.getRect().getY()) {
							break;
						}
					}
	
					lastElement = uniElement;
					// 展开更多
					if (!showMore.get()) {
						AppiumUtil.opt(driver, moreBy).ifPresent(x -> {
							x.click(); 
							showMore.set(true);});
					}
					
					//System.out.println("基础房型的y坐标 = " + element.getLocation().getY());
					// 输出单元房型的y坐标
					//System.out.println("基础单元房型的y坐标 = " + subElement.getLocation().getY());
					printUniRoomType(uniElement);
					// 是否可预订
					final String str = uniElement.findElement(iconBy).getScreenshotAs(OutputType.BASE64);
					if (cache.equals(str)) {
						System.out.println("不可预订");
					} else {
						System.out.println("可预订");
					}
					
					// 元素的高度决定移动的偏移值
					differenceValue = uniElement.getRect().getHeight() + 100;
					// 当前元素底下y坐标 距离 钟点房 标签 小于一定值时 小幅度上滑，差值 可配置，不同屏幕尺寸值不同
					if (null != hourElement && (hourElement.getRect().getY() - (uniElement.getRect().getY() + uniElement.getRect().getHeight()) < 50)) {
						differenceValue = 10;
					}
					// 屏幕上滑
					new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
					// 等待，避免加载缓慢
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));

				}
			}
			
			// 钟点房抓取
			final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
			if (null != hourElement) {
				String text = hourElement.getText();
				Pattern pattern = Pattern.compile("钟点房\\((\\d+)\\)");
				Matcher matcher = pattern.matcher(text);
				Integer number = 0;
				if (matcher.matches()) {
					number = Integer.valueOf(matcher.group(1));
					if (0 == number) { // 没有钟点房
						return;
					}
					if (1 == number) { // 只有一个钟点房，无需展开
					} else { // 展开更多
						AppiumUtil.opt(driver, moreHourBy).ifPresent(MobileElement :: click);
					}
					// 钟点房父元素
					MobileElement parentElement = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='ctrip.android.hotel:id/hour_room_list']"));
					//
					int time = 0;
					MobileElement lastElement = null;
					while (time < number) {
						final List<MobileElement> subs = parentElement.findElements(uniBy);
						MobileElement subElement = decide2(lastElement, uniRoomTypes, subs);
						// 输出钟点房信息
						printPhysic(subElement);
						time++;
						differenceValue = subElement.getRect().getHeight() + 100;
						// 屏幕上滑
						new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
						// 等待，避免加载缓慢
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
						.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
						lastElement = subElement;
					}
				}
			}
			
		} catch (Exception e) {
			log.error("testFetch01 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 单元房型 平铺场景
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFetch02() {
		try {
			final int width = driver.manage().window().getSize().getWidth();
			final int height = driver.manage().window().getSize().getHeight();
			
			// 屏幕上滑
			new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(width / 2, height - 400)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
			
			// 灰色预订图标
			final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			// 单元房型
			final Set<String> uniRoomTypes = new HashSet<>();
			// 预订图标的路径
			final By iconBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			// 单元房型
			final By uniBy = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item']");
			// 查看全部房型
			final By moreBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/mHandle_peacock']");
			
			// 钟点房标题
			final By hourTitleBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_title']");
			// 查看全部钟点房型
			final By moreHourBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_expand_collpase']");
			int differenceValue = -1;
			// 是否展开了更多
			final AtomicBoolean showMore = new AtomicBoolean(false);
			while (true) { // 单元房型
				MobileElement lastElement = null;
				final List<MobileElement> subs = driver.findElements(uniBy);
				final MobileElement uniElement = decide2(lastElement, uniRoomTypes, subs);
				if (null == uniElement || (null != lastElement && uniElement == lastElement)) { // 拿到同一个，结束当前基础房型下单元房型的抓取
					break;
				}
				final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
				if (null != hourElement) { // 发现钟点房
					// 跳出这次单元房型的抓取
					if (uniElement.getRect().getY() > hourElement.getRect().getY()) {
						break;
					}
				}
				// 元素的高度决定移动的偏移值
				differenceValue = uniElement.getRect().getHeight() + 100;
				// 当前元素底下y坐标 距离 钟点房 标签 小于一定值时 小幅度上滑，差值 可配置，不同屏幕尺寸值不同
/*				if (null != hourElement && (hourElement.getRect().getY() - (uniElement.getRect().getY() + uniElement.getRect().getHeight()) < 50)) {
					differenceValue = 10;
				}*/
				// 屏幕上滑
				new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
				// 等待，避免加载缓慢
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
				lastElement = uniElement;
				// 展开更多
				if (!showMore.get()) {
					AppiumUtil.opt(driver, moreBy).ifPresent(x -> {
						x.click(); 
						showMore.set(true);});
				}
				
				printUniRoomType(uniElement);
				// 是否可预订
				final String str = uniElement.findElement(iconBy).getScreenshotAs(OutputType.BASE64);
				if (cache.equals(str)) {
					System.out.println("不可预订");
				} else {
					System.out.println("可预订");
				}
			}
		
			// 钟点房抓取
			final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
			if (null != hourElement) {
				String text = hourElement.getText();
				Pattern pattern = Pattern.compile("钟点房\\((\\d+)\\)");
				Matcher matcher = pattern.matcher(text);
				Integer number = 0;
				if (matcher.matches()) {
					number = Integer.valueOf(matcher.group(1));
					if (0 == number) { // 没有钟点房
						return;
					}
					if (1 == number) { // 只有一个钟点房，无需展开
					} else { // 展开更多
						AppiumUtil.opt(driver, moreHourBy).ifPresent(MobileElement :: click);
					}
					// 钟点房父元素
					MobileElement parentElement = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='ctrip.android.hotel:id/hour_room_list']"));
					//
					int time = 0;
					MobileElement lastElement = null;
					while (time < number) {
						final List<MobileElement> subs = parentElement.findElements(uniBy);
						MobileElement subElement = decide2(lastElement, uniRoomTypes, subs);
						// 输出钟点房信息
						printUniRoomType(subElement);
						time++;
						// 屏幕上滑
						new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
						// 等待，避免加载缓慢
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
						.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
						lastElement = subElement;
					}
				}
			}
			
			
		} catch (Exception e) {
			log.error("testFetch02 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 场景: 满房 (所有房型满房，不可预订，展示的是最低价的单元房型)
	 * 这部分代码和 02单元房型 代码相同，02只是多了钟点房
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	@Deprecated
	public void testFetch03() {
		try {
			final int width = driver.manage().window().getSize().getWidth();
			final int height = driver.manage().window().getSize().getHeight();
			
			// 屏幕上滑
			new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
			// 等待，避免加载缓慢
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(width / 2, height - 400)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
			
			// 灰色预订图标
			final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			// 单元房型
			final Set<String> uniRoomTypes = new HashSet<>();
			// 预订图标的路径
			final By iconBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			// 单元房型
			final By uniBy = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item']");
			// 查看全部房型
			final By moreBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/mHandle_peacock']");
			
			// 钟点房标题
			final By hourTitleBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_title']");
			int differenceValue = 400;
			// 是否发现钟点房
			MobileElement lastElement = null;
			// 是否展开了更多
			final AtomicBoolean showMore = new AtomicBoolean(false);
			while (true) { // 单元房型
				final List<MobileElement> subs = driver.findElements(uniBy);
				final MobileElement uniElement = decide2(lastElement, uniRoomTypes, subs);
				if (null == uniElement || (null != lastElement && uniElement == lastElement)) { // 拿到同一个，结束当前基础房型下单元房型的抓取
					break;
				}
				final MobileElement hourElement = AppiumUtil.get(driver, hourTitleBy);
				if (null != hourElement) { // 发现钟点房
					// 跳出这次单元房型的抓取
					if (uniElement.getRect().getY() > hourElement.getRect().getY()) {
						break;
					}
				}
				// 元素的高度决定移动的偏移值
				differenceValue = uniElement.getRect().getHeight() + 100;
				// 当前元素底下y坐标 距离 钟点房 标签 小于一定值时 小幅度上滑，差值 可配置，不同屏幕尺寸值不同
				if (null != hourElement && (hourElement.getRect().getY() - (uniElement.getRect().getY() + uniElement.getRect().getHeight()) < 50)) {
					differenceValue = 10;
				}
				// 屏幕上滑
				new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
				// 等待，避免加载缓慢
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(width / 2, height - differenceValue)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
				lastElement = uniElement;
				// 展开更多
				if (!showMore.get()) {
					AppiumUtil.opt(driver, moreBy).ifPresent(x -> {
						x.click(); 
						showMore.set(true);});
				}
				
				printUniRoomType(uniElement);
				// 是否可预订
				final String str = uniElement.findElement(iconBy).getScreenshotAs(OutputType.BASE64);
				if (cache.equals(str)) {
					System.out.println("不可预订");
				} else {
					System.out.println("可预订");
				}
			}
		} catch (Exception e) {
			log.error("testFetch03 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 钟点房
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testHourRoom() {
		try {
			int width = driver.manage().window().getSize().getWidth();
			int height = driver.manage().window().getSize().getHeight();
		
			final String cache = FileUtil.getString(ProjectUtil.getAbsolutePath("/doc/imageBase64.txt"));
			// 钟点房
			final By hourBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_title']");
			//
			// 单元房型
			By uniBy = By.xpath("//android.widget.LinearLayout[@content-desc='hotel_detail_room_item']");
			// 预订图片的路径
			final By bookBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_book']");
			// 钟点房抓取
			final MobileElement hourElement = AppiumUtil.get(driver, hourBy);
			if (null != hourElement) {
				String text = hourElement.getText();
				Pattern pattern = Pattern.compile("钟点房\\((\\d+)\\)");
				Matcher matcher = pattern.matcher(text);
				Integer number = 0;
				if (matcher.matches()) {
					number = Integer.valueOf(matcher.group(1));
					if (0 == number) { // 没有钟点房
						return;
					}
					if (1 == number) { // 只有一个钟点房，无需展开
					} else { // 展开更多
						By moreBy = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel:id/hour_room_expand_collpase']");
						AppiumUtil.opt(driver, moreBy).ifPresent(MobileElement :: click);
					}
					// 钟点房父元素
					final MobileElement parentElement = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='ctrip.android.hotel:id/hour_room_list']"));
					//
					// 单元房型
					final Set<String> uniRoomTypes = new HashSet<>();
					MobileElement lastElement = null;
					int time = 0;
					while (time < number) {
						final List<MobileElement> subs = parentElement.findElements(uniBy);
						MobileElement subElement = decide2(lastElement, uniRoomTypes, subs);
						// 输出钟点房信息
						printPhysic(subElement);
						// 是否可预订
						final String str = subElement.findElement(bookBy).getScreenshotAs(OutputType.BASE64);
						if (cache.equals(str)) {
							System.out.println("不可预订");
						} else {
							System.out.println("可预订");
						}
						time++;
						// 屏幕上滑
						new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
						// 等待，避免加载缓慢
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
						.moveTo(PointOption.point(width / 2, height - 310)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
						lastElement = subElement;
					}
				}
			}
			
		} catch (Exception e) {
			log.error("testHourRoom =====> ", e);
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
	public void testYan() {
		try {
			
			// 页面加载超时时间，app端不支持
			//driver.manage().timeouts().pageLoadTimeout(20 * 1000, TimeUnit.MILLISECONDS);
			
			/*
			 * 搜索元素的超时时间，全局容忍超时时间
			 * 设置此值就无需到处sleep了
			 */
			driver.manage().timeouts().implicitlyWait(20 * 1000, TimeUnit.MILLISECONDS);
			
			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			element.click();
			
			By.className("");

			//(new TouchAction(driver)).press();
			//element.sen
		} catch (Exception e) {
			log.error("testYan =====> ", e);
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
	public void testLocation() {
		try {
			// bounds="[0,589][720,800]" 
			By by = By.xpath("//android.widget.RelativeLayout[@resource-id='ctrip.android.hotel.detail:id/mBasicRoomItem']");
			element = driver.findElement(by);
			/*
			 * 返回的是该元素的起始坐标，对应bounds的起始坐标 - 左上角
			 */
			// y坐标 = 438
			//System.out.println("y坐标 = " + element.getLocation().getY());
			System.out.println("y坐标 = " + element.getRect().getY());
			// 单元房型
			by = By.xpath("//android.widget.LinearLayout[@resource-id='ctrip.android.hotel.detail:id/content_container_layout']");
			final List<MobileElement> elements = driver.findElements(by);
			// 取第二个元素
			// y坐标 = 665
			//System.out.println("y坐标 = " + elements.get(1).getLocation().getY());
			System.out.println("y坐标 = " + elements.get(1).getRect().getY());
		} catch (Exception e) {
			log.error("testLocation =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 决定使用哪个元素 (基础房型)
	 * @param roomTypes 基础房型
	 * @param elements
	 * @return
	 * @author qianye.zheng
	 */
	private MobileElement decide1(final Set<String> roomTypes, final List<MobileElement> elements) {
		By by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_name']");
		for (MobileElement element : elements) {
			MobileElement e = AppiumUtil.get(element, by);
			if (null != e) {
				String name = e.getText();
				if (name.equals("江南 详情AR")) {
					System.out.println("CtripAPPTest.decide1()");
				}
				if (roomTypes.contains(name)) { // 已经有了，下一个
					continue;
				} else {
					roomTypes.add(name);
					
					return element;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * @description 决定使用哪个元素 (单元房型)
	 * @param referenceElement 参考元素
	 * @param roomTypes 单元房型
	 * @param elements
	 * @return
	 * @author qianye.zheng
	 */
	private MobileElement decide2(final MobileElement referenceElement, final Set<String> roomTypes, final List<MobileElement> elements) {
		By by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_encrypted_room_id']");
		for (MobileElement element : elements) {
			MobileElement e = AppiumUtil.get(element, by);
			if (null != e) {
				/*
				 * 根据y坐标，忽略掉 推荐房型或重复的房型
				 * 小于 参考的元素的y坐标，说明是上一个房型，忽略掉
				 */
				if (null != referenceElement && e.getRect().getY() < referenceElement.getRect().getY()) {
					continue;
				}
				String name = e.getText();
				if (roomTypes.contains(name)) { // 已经有了，下一个
					continue;
				} else {
					roomTypes.add(name);

					return element;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @description 输出物理信息
	 * @param element
	 * @author qianye.zheng
	 */
	private void printPhysic(final MobileElement element) {
		System.out.println("=============");
		By by = null;
		// 房型名称
		by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.hotel.detail:id/room_item_name']");
		System.out.println("房型名称: " + element.findElement(by).getText());
		
		// 其他信息
		by = By.xpath("//android.view.ViewGroup[@resource-id='ctrip.android.hotel.detail:id/basic_info_paragraph_container']/android.widget.TextView");
		List<MobileElement> elements = AppiumUtil.gets(element, by);
		elements.forEach(x -> System.out.println(x.getText()));
		System.out.println("=============");
	}
	
	/**
	 * 
	 * @description 输出单元房型信息
	 * @param element
	 * @author qianye.zheng
	 */
	private void printUniRoomType(final MobileElement element) {
		By by = null;
		// 其他信息
		by = By.xpath("//android.widget.TextView");
		List<MobileElement> elements = AppiumUtil.gets(element, by);
		elements.forEach(x -> System.out.print(x.getText() + " | "));
		System.out.println();
	}
	
	/**
	 * 
	 * @description 是否登录 (账号是否已登录)
	 * @param driver
	 * @return
	 * @author qianye.zheng
	 */
	public boolean isLogin(final AppiumDriver<MobileElement> driver) {
		boolean flag = false;
		
		return flag;
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
			//TimeUnit.SECONDS.sleep(3);
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
			
			//TimeUnit.SECONDS.sleep(1);
			by = By.xpath("//android.widget.EditText[@resource-id='ctrip.android.search:id/search_main_input']");
			element = driver.findElement(by);
			element.sendKeys("北京7天酒店");
			
			// 搜索按钮
			by = By.xpath("//android.widget.TextView[@resource-id='ctrip.android.search:id/search_right_search_btn']");
			//element = driver.findElement(by);
			// id == resource-id
			element = driver.findElementById("ctrip.android.search:id/search_right_search_btn");
			element.click();

			// 返回上一步
			driver.navigate().back();

		} catch (Exception e) {
			log.error("testSearch =====> ", e);
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
			//TimeUnit.SECONDS.sleep(2);
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
			
			//TimeUnit.SECONDS.sleep(1);
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
				//TimeUnit.SECONDS.sleep(1);
			}
			
		} catch (Exception e) {
			log.error("testFistOpen =====> ", e);
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
			//TimeUnit.SECONDS.sleep(2);
			//driver.close();
			List<MobileElement> elements = null;
			By by = null;
			//driver.closeApp();
			by = By.xpath("//android.widget.TextView[@text='我的']");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			//TimeUnit.SECONDS.sleep(1);
			// 点击 [登录]
			by = By.xpath("//android.widget.Button[contains(@text,'登录')]");
			element = driver.findElement(by);
			// 点击
			element.click();
			
			//TimeUnit.SECONDS.sleep(2);
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
			//TimeUnit.SECONDS.sleep(1);
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
			
			//TimeUnit.SECONDS.sleep(1);
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
	public void getPageSource() {
		try {
			
			System.out.println(driver.getPageSource());
			
		} catch (Exception e) {
			log.error("getPageSource =====> ", e);
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
			//connect("emulator-5554");
			by = By.xpath("//android.widget.LinearLayout[@resource-id='ctrip.android.hotel.detail:id/content_container_layout']");
			List<MobileElement> elements = driver.findElements(by);
			System.out.println(elements.size());
			
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
		/*
		 * 退出会话，避免和下次冲突
		 * 解决 Original error: Error: socket hang up 异常
		 */
		driver.quit();
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
