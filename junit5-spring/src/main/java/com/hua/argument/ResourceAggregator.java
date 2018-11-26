/**
  * @filename ResourceAggregator.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.argument;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import com.hua.entity.ResourceVo;

/**
 * @type ResourceAggregator
 * @description 
 * @author qianye.zheng
 */
public class ResourceAggregator implements ArgumentsAggregator
{

	/**
	 * @description 
	 * @param accessor
	 * @param context
	 * @return
	 * @throws ArgumentsAggregationException
	 * @author qianye.zheng
	 */
	@Override
	public ResourceVo aggregateArguments(ArgumentsAccessor accessor,
			ParameterContext context) throws ArgumentsAggregationException
	{
		ResourceVo vo = new ResourceVo();
		vo.setCode(accessor.getString(0));
		vo.setName(accessor.getString(1));
		vo.setGrade(accessor.getInteger(2));
		
		return vo;
	}

}
