/**
  * @filename TimeExecutionLogger.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @type TimeExecutionLogger
 * @description 
 * @author qianye.zheng
 */
@Tag("timed")
@ExtendWith(TimingExtension.class)
public interface TimeExecutionLogger
{

}
