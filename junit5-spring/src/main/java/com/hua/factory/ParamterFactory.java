/**
  * @filename ParamterFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.factory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @type ParamterFactory
 * @description 
 * @author qianye.zheng
 */
public class ParamterFactory
{
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public static final Iterator<String> iterator()
	{
		Set<String> set = new HashSet<String>();
		set.add("guangzhou");
		set.add("nanjijng");
		set.add("beijing");
		
		return set.iterator();
	}
	

	
}
