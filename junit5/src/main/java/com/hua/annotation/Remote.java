/**
  * @filename Remote.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;


/**
 * 结合@Tag或@Tags注解
 * 自定义一个注解，用于测试，就不用在测试类中使用Tag或Tags标签
 * 
 * 例如 当前注解 @Remote 等同于 @Tag("remote")
 * 只用自定义的注解，是为了避免书写的时候出错
 */
/**
 * @type Remote
 * @description 
 * @author qianye.zheng
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("remote")
public @interface Remote
{

}
