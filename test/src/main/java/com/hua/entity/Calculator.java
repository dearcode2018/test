/**
 * 描述: 
 * Calculator.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.entity;

/**
 * 描述: 简单计算器
 * 加/减/乘/除/求余/幂运算
 * 
 * @author qye.zheng
 * Calculator
 */
public final class Calculator extends BaseEntity {
	
	/* 运算结果 */
	private int result;
	
	/* 操作数 a */
	private int a = 0;
	
	/* 操作数 b */
	private int b = 0;
	
	 /** 无参构造方法 */
	public Calculator() {}
	
	public Calculator(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	/**
	 * 
	 * 描述: 加法运算 
	 * @author qye.zheng
	 * 
	 */
	public int add() {
		result = a + b;
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 减法运算 
	 * @author qye.zheng
	 * 
	 */
	public int substract() {
		result = a - b;
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 乘法运算 
	 * @author qye.zheng
	 * 
	 */
	public int multiply() {
		result = a * b;
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 除法运算 
	 * @author qye.zheng
	 * 
	 */
	public int divide() {
		result = a / b;
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 求余运算 
	 * @author qye.zheng
	 * 
	 */
	public int mod() {
		result = a % b;
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 幂运算 
	 * @author qye.zheng
	 * 
	 */
	public int power() {
		result = (int) Math.pow(a, b);
		
		return result;
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

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}
	
}
