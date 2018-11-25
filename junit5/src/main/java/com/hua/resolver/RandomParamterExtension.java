/**
  * @filename RandomParamterExtension.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * @type RandomParamterExtension
 * @description 
 * @author qianye.zheng
 */
public class RandomParamterExtension implements ParameterResolver
{

	/**
	 * 
	 * @type Random
	 * @description 
	 * @author qianye.zheng
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.PARAMETER)
	public @interface Random
	{
		
	}
	
	/**
	 * @description 
	 * @param parameterContext
	 * @param extensionContext
	 * @return
	 * @throws ParameterResolutionException
	 * @author qianye.zheng
	 */
	@Override
	public boolean supportsParameter(ParameterContext parameterContext,
			ExtensionContext extensionContext)
			throws ParameterResolutionException
	{
		return parameterContext.isAnnotated(Random.class);
	}

	/**
	 * @description 
	 * @param parameterContext
	 * @param extensionContext
	 * @return
	 * @throws ParameterResolutionException
	 * @author qianye.zheng
	 */
	@Override
	public Object resolveParameter(ParameterContext parameterContext,
			ExtensionContext extensionContext)
			throws ParameterResolutionException
	{
		return getRandomValue(parameterContext.getParameter(), extensionContext);
	}

	/**
	 * 
	 * @description 
	 * @param parameter
	 * @param context
	 * @return
	 * @author qianye.zheng
	 */
	private Object getRandomValue(Parameter parameter, ExtensionContext context)
	{
		final Class<?> type = parameter.getType();
		final java.util.Random random = context.getRoot().getStore(Namespace.GLOBAL)
				.getOrComputeIfAbsent(java.util.Random.class);
		
		if (int.class.equals(type))
		{
			return random.nextInt();
		}
		if (double.class.equals(type))
		{
			return random.nextDouble();
		}
		
		throw new ParameterResolutionException("no random generator implemented for: " + type);
	}
	
	
}
