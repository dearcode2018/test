/**
  * @filename CsvToResource.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.params.aggregator.AggregateWith;

import com.hua.argument.ResourceAggregator;

/**
 * @type CsvToResource
 * @description 
 * @author qianye.zheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(ResourceAggregator.class)
public @interface CsvToResource
{

}
