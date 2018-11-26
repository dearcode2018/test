/**
  * @filename MyArgumentProvider.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.argument;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

/**
 * @type MyArgumentProvider
 * @description 
 * @author qianye.zheng
 */
public class MyArgumentProvider implements ArgumentsProvider
{

	/**
	 * @description 
	 * @param context
	 * @return
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public Stream<? extends Arguments> provideArguments(
			ExtensionContext context) throws Exception
	{
		
		return Stream.of("foo", "bar").map(Arguments :: of);
	}

}
