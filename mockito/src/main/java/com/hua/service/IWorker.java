/**
  * @filename IWorker.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

 /**
 * @type IWorker
 * @description 
 * @author qianye.zheng
 */
public interface IWorker extends CoreService
{
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	void notParamRetVoid();
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	String notParamRetString();
	
	/**
	 * 
	 * @description 
	 * @param name
	 * @param value
	 * @author qianye.zheng
	 */
	void retVoid(final String name, final int value);
	
	/**
	 * 
	 * @description 
	 * @param code
	 * @param price
	 * @param amount
	 * @return
	 * @author qianye.zheng
	 */
	double retDouble(final String code, final double price, final int amount);
	
}
