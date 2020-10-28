/**
 * AppiumUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * AppiumUtil
 * 描述: 
 * @author  qye.zheng
 */
public final class AppiumUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private AppiumUtil()
	{
	}

	/**
	 * 
	 * @description 元素是否存在
	 * @param driver
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final boolean exist(final AppiumDriver<MobileElement> driver, final By by) {
		boolean flag = false;
		try {
			driver.findElement(by);
			flag = true;
		} catch (NoSuchElementException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @description 获取单个元素 (不存在，不抛异常)
	 * @param driver
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final MobileElement get(final AppiumDriver<MobileElement> driver, final By by) {
		MobileElement result = null;
		try {
			result = driver.findElement(by);
		} catch (NoSuchElementException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
		}
		
		return result;
	}
	
	/**
	 * 
	 * @description 获取单个元素 (不存在，不抛异常)
	 * @param driver
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final Optional<MobileElement> opt(final AppiumDriver<MobileElement> driver, final By by) {
		Optional<MobileElement> result = null;
		try {
			result = Optional.of(driver.findElement(by));
		} catch (NoSuchElementException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
			result = Optional.empty();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @description 获取单个元素 (不存在，不抛异常)
	 * @param element 父元素
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final Optional<MobileElement> opt(final MobileElement element, final By by) {
		Optional<MobileElement> result = null;
		try {
			result = Optional.of(element.findElement(by));
		} catch (NoSuchElementException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
			result = Optional.empty();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @description 获取单个元素 (不存在，不抛异常)
	 * @param element 父元素
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final MobileElement get(final MobileElement element, final By by) {
		MobileElement result = null;
		try {
			result = element.findElement(by);
		} catch (NoSuchElementException | StaleElementReferenceException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
		}
		
		return result;
	}
	
	/**
	 * 
	 * @description 获取多个元素 (不存在，不抛异常)
	 * @param driver
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final List<MobileElement> gets(final AppiumDriver<MobileElement> driver, final By by) {
		List<MobileElement> result = null;
		try {
			result = driver.findElements(by);
		} catch (NoSuchElementException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
		}
		
		return result;
	}
	
	/**
	 * 
	 * @description 获取多个元素 (不存在，不抛异常)
	 * @param element 父元素
	 * @param by 元素路径
	 * @return
	 * @author qianye.zheng
	 */
	public static final List<MobileElement> gets(final MobileElement element, final By by) {
		List<MobileElement> result = null;
		try {
			result = element.findElements(by);
		} catch (NoSuchElementException e)
		{ // 捕获元素不存在异常，可以根据实际情况扩大异常范围，避免存在其他情况 (APP卡顿/通讯中断等)
			// 返回空集合
			result = Collections.emptyList();
		}
		
		return result;
	}
}
