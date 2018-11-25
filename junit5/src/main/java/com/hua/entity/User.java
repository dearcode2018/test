/**
  * @filename User.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

 /**
 * @type User
 * @description 
 * @author qianye.zheng
 */
public class User
{
	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public User()
	{
	}
	/**
	 * @description 构造方法
	 * @param username
	 * @author qianye.zheng
	 */
	public User(String username)
	{
		super();
		System.out.println("User.User()");
		this.username = username;
	}

	/**
	 * 
	 * @description 非私有的静态构造方法 (工厂方法)
	 * @param username
	 * @return
	 * @author qianye.zheng
	 */
	static User build(final String username)
	{
		System.out.println("User.build()");
		
		return new User(username);
	}
	
	/**
	 * 
	 * @description 
	 * @param username
	 * @return
	 * @author qianye.zheng
	 */
/*	static User build2(final String username)
	{
		System.out.println("User.build()");
		
		return new User(username);
	}*/
	
	/**
	* @return the username
	*/
	public String getUsername()
	{
		return username;
	}

	/**
	* @param username the username to set
	*/
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	* @return the nickname
	*/
	public String getNickname()
	{
		return nickname;
	}

	/**
	* @param nickname the nickname to set
	*/
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	* @return the password
	*/
	public String getPassword()
	{
		return password;
	}

	/**
	* @param password the password to set
	*/
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
