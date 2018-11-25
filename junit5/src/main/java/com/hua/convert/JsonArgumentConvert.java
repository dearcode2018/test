/**
  * @filename JsonArgumentConvert.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import com.hua.entity.User;
import com.hua.util.JacksonUtil;

/**
 * @type JsonArgumentConvert
 * @description 
 * @author qianye.zheng
 */
public class JsonArgumentConvert extends SimpleArgumentConverter
{

	/**
	 * @description 
	 * @param source
	 * @param targetType
	 * @return
	 * @throws ArgumentConversionException
	 * @author qianye.zheng
	 */
	@Override
	protected Object convert(Object source, Class<?> targetType)
			throws ArgumentConversionException
	{
		
		return JacksonUtil.readValue(source.toString(), targetType);
	}

}
