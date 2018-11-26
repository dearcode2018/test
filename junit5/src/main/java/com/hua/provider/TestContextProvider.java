/**
  * @filename TestContextProvider.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import com.hua.callback.MyAfterEachCallback;
import com.hua.callback.MyBeforeTestExecutionCallback;

/**
 * @type TestContextProvider
 * @description 
 * @author qianye.zheng
 */
public class TestContextProvider
		implements TestTemplateInvocationContextProvider
{

	/**
	 * @description 
	 * @param context
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public boolean supportsTestTemplate(ExtensionContext context)
	{
		return true;
	}

	/**
	 * @description 
	 * @param context
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(
			ExtensionContext context)
	{
		return Stream.of(invocationContext("Special Test Context"));
	}
	
	private TestTemplateInvocationContext invocationContext(String name)
	{
		return new TestTemplateInvocationContext()
			{
				/**
				 * @description 
				 * @param invocationIndex
				 * @return
				 * @author qianye.zheng
				 */
				@Override
				public String getDisplayName(int invocationIndex)
				{
					return name;
				}
				
				/**
				 * @description 
				 * @return
				 * @author qianye.zheng
				 */
				@Override
				public List<Extension> getAdditionalExtensions()
				{
					// 随便放置几个Extension
					return Arrays.asList(new MyAfterEachCallback(), new MyBeforeTestExecutionCallback());
				}
			};
	}

}
