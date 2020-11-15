/**
  * @filename BusinessDaoImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import org.springframework.stereotype.Repository;

import com.hua.service.IBusinessDao;

/**
 * @type BusinessDaoImpl
 * @description 
 * @author qianye.zheng
 */
@Repository
public class BusinessDaoImpl implements IBusinessDao
{

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int doSomeThing()
	{
		return 0;
	}

	/**
	 * @description 
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String doSomeThing(int value)
	{
		return null;
	}

}
