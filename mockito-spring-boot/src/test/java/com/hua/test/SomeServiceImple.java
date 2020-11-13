/**
  * @filename SomeServiceImple.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.test;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.hua.service.SomeService;

/**
 * @type SomeServiceImple
 * @description 
 * @author qianye.zheng
 */
@MockBean
public class SomeServiceImple implements SomeService {

	/**
	 * @description 
	 * @param name
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int getValue(String name) {
		return 0;
	}

}
