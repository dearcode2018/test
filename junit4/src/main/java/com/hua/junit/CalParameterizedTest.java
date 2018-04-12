/**
 * 描述: 
 * CalParameterizedTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hua.entity.Calculator;
import com.hua.test.BaseTest;

/**
 * 描述: 参数测试-示例
 * 
 * @author qye.zheng
 * CalParameterizedTest
 * 
 * 参数化测试_原理 : 手工设置参数和预期结果列表，
 * 通过 [多次构造] 测试对象的方式提交给 参数化运行器
 * 
 */
// 需要指定 相应的运行器
@RunWith(Parameterized.class)
public final class CalParameterizedTest extends BaseTest {
	
	// 手工设置 参数列表
	private static Num[] params = {new Num(1, 2), new Num(3, 4), new Num(5, 6)};
	
	// 手工设置 预期结果列表
	private static int[] expectResults = {2, 12, 30};
	
	/* 参数 */
	private Num param;
	
	/* 预期结果 */
	private int expectResult;
	
	private Calculator cal;
	
	/** 构造方法 - 每个参数测试 构造一个对象 */
	public CalParameterizedTest(Num param, int expectResult) {
		this.param = param;
		this.expectResult = expectResult;
		cal = new Calculator(param.getA(), param.getB());
	}
	
	/**
	 * 
	 * 描述: 参数-预期结果
	 * 必须是静态方法，以确保能通过
	 * 构造方法来构造测试参数
	 * @author qye.zheng
	 * 
	 * @return
	 */
	@SuppressWarnings("all")
	@Parameters
	public static Collection data() {
		// 构成一个2维数组
		final Object[][] objs = new Object[][] {
				{params[0], expectResults[0]}, 
				{params[1], expectResults[1]}, 
				{params[2], expectResults[2]}
				};

		return Arrays.asList(objs);
	}
	
	/**
	 * 
	 * 描述: 普通测试方法
	 ,@Test注解 不带参数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMultiply() {
		System.out.println("CalParameterizedTest.testMultiply()");
		// 预期结果、每个参数测试所构造的对象(这里是 Calculator)
		assertEquals("结果错误", expectResult, cal.multiply());
	}
	
	/**
	 * @return the param
	 */
	public Num getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(Num param) {
		this.param = param;
	}

	/**
	 * @return the expectResult
	 */
	public int getExpectResult() {
		return expectResult;
	}

	/**
	 * @param expectResult the expectResult to set
	 */
	public void setExpectResult(int expectResult) {
		this.expectResult = expectResult;
	}



	/* 内部类，封装测试目标的参数 */
	static class Num {
		
		/* 操作数 a */
		private int a;
		
		/* 操作数 b */
		private int b;
		
		/** 构造方法 */
		public Num(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		/**
		 * @return the a
		 */
		public int getA() {
			return a;
		}

		/**
		 * @param a the a to set
		 */
		public void setA(int a) {
			this.a = a;
		}

		/**
		 * @return the b
		 */
		public int getB() {
			return b;
		}

		/**
		 * @param b the b to set
		 */
		public void setB(int b) {
			this.b = b;
		}
	}
	
}
