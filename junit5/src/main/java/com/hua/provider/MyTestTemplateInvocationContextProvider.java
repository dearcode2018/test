/**
  * @filename MyTestTemplateInvocationContextProvider.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.provider;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

/**
 * @type MyTestTemplateInvocationContextProvider
 * @description 
 * @author qianye.zheng
 */
public class MyTestTemplateInvocationContextProvider
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
		return Stream.of(invocationContext("foo"), invocationContext("bar"));
	}
	
	private TestTemplateInvocationContext invocationContext(final String parameter)
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
						return parameter;
					}
					
					/**
					 * @description 
					 * @return
					 * @author qianye.zheng
					 */
					@Override
					public List<Extension> getAdditionalExtensions()
					{
						return Collections.singletonList(new ParameterResolver()
						{
							
							@Override
							public boolean supportsParameter(ParameterContext parameterContext,
									ExtensionContext extensionContext)
									throws ParameterResolutionException
							{
								return parameterContext.getParameter().getType().equals(String.class);
							}
							
							@Override
							public Object resolveParameter(ParameterContext parameterContext,
									ExtensionContext extensionContext)
									throws ParameterResolutionException
							{
								return parameter;
							}
						});
					}
				};
	}

}
