/**
  * @filename WorkerImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import com.hua.service.IBusinessDao;
import com.hua.service.IWorker;

/**
 * @type WorkerImpl
 * @description 
 * @author qianye.zheng
 */
public class WorkerImpl extends CoreServiceImpl implements IWorker
{
	/*
	 * 在单元测试中，@InjectMocks 会将 @Mock的接口 构造对象后
	 * 注入此对象的属性，无需提供构造方法或者setter
	 */
	private IBusinessDao iBusinessDao;
	
	/**
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void notParamRetVoid()
	{
		int value = iBusinessDao.doSomeThing();
		System.out.println("WorkerImpl.notParamRetVoid(), value = " + value);
	}

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String notParamRetString()
	{
		System.out.println("WorkerImpl.notParamRetString()");
		return "notParamRetString";
	}

	/**
	 * @description 
	 * @param name
	 * @param value
	 * @author qianye.zheng
	 */
	@Override
	public void retVoid(String name, int value)
	{
		System.out.println("retVoid -> param: name = " + name + ", value = " + value);
	}

	/**
	 * @description 
	 * @param code
	 * @param price
	 * @param amount
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public double retDouble(String code, double price, int amount)
	{
		System.out.println("buy product code = " + code);
		if (0 == amount || 0.0 == price) {
			return 0.0;
		}
		
		return price * amount;
	}

}
