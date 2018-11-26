/**
  * @filename ResourceVo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

 /**
 * @type ResourceVo
 * @description 
 * @author qianye.zheng
 */
public class ResourceVo
{
	
	private String code;
	
	private String name;
	
	private Integer grade;

	/**
	* @return the code
	*/
	public String getCode()
	{
		return code;
	}

	/**
	* @param code the code to set
	*/
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	* @return the name
	*/
	public String getName()
	{
		return name;
	}

	/**
	* @param name the name to set
	*/
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	* @return the grade
	*/
	public Integer getGrade()
	{
		return grade;
	}

	/**
	* @param grade the grade to set
	*/
	public void setGrade(Integer grade)
	{
		this.grade = grade;
	}
	
}
