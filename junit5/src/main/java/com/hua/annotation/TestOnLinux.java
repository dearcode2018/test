/**
  * @filename TestOnLinux.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * @type TestOnLinux
 * @description 
 * @author qianye.zheng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// 集成了多个注解，在具体测试对象中直接标注即可，省去很多注解
@Test
@EnabledOnOs(OS.LINUX)
public @interface TestOnLinux
{

}
