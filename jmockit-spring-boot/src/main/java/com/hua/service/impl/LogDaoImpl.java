/**
  * @filename LogDaoImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import org.springframework.stereotype.Repository;

import com.hua.service.ILogDao;

/**
 * @type LogDaoImpl
 * @description 
 * @author qianye.zheng
 */
@Repository
public class LogDaoImpl implements ILogDao
{

	/**
	 * @description 
	 * @param name
	 * @author qianye.zheng
	 */
	@Override
	public void save(String name)
	{
		System.out.println("log operation");
	}

}
