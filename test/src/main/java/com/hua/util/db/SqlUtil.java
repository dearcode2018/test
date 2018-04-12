/**
 * 描述: 
 * SqlUtil.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.util.db;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.hua.constant.JdbcConstant;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * SqlUtil
 */
public final class SqlUtil {
	
	/** 无参构造方法 */
	private SqlUtil() {}
	
	public static final String ESCAPE = " ESCAPE '/' ";
	
	
	
	/**
	 * 将查询内容格式化
	 * @param content
	 * @return
	 */
	public static String likeQuery(String content) {
		// 单引号
		/*if (content.contains("'")) {
			content = content.replace("'", "''");
		}*/
		
		if (content.contains("_")) {
			content = content.replace("_",  "/_");
		}
		
		if (content.contains("%")) {
			content = content.replace("%", "/%");
		}
		
		return content;
	}
	
	/**
	 * 
	 * 描述: 组装值
	 * @author qye.zheng
	 * 
	 * @param ps
	 * @param params 参数
	 */
	public static void setValue(final PreparedStatement ps, final Object[] params) {
		// PreparedStatement 设置值，下标从1开始
		try {
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof Short) {
					ps.setShort(i + 1, (Short) params[i]);
				}  else if (params[i] instanceof Integer)  {
					ps.setInt(i + 1, (Integer) params[i]);
				} else if (params[i] instanceof Long) {
					ps.setLong(i + 1, (Long) params[i]);
				} else if (params[i] instanceof Float) {
					ps.setFloat(i + 1, (Float) params[i]);
				} else if (params[i] instanceof Double) {
					ps.setDouble(i + 1, (Double) params[i]);
				} else if (params[i] instanceof String) {
					ps.setString(i + 1, (String) params[i]);
				} else if (params[i] instanceof Date) {
					// java.sql.Date
					ps.setDate(i + 1, (Date) params[i]);
				}  else if (params[i] instanceof Time) {
					ps.setTime(i + 1, (Time) params[i]);
				}  else if (params[i] instanceof Timestamp) {
					ps.setTimestamp(i + 1, (Timestamp) params[i]);
				} else if (params[i] instanceof Clob) {
					ps.setClob(i + 1, (Clob) params[i]);
				} else if (params[i] instanceof Blob) {
					ps.setBlob(i + 1, (Blob) params[i]);
				} else if (params[i] instanceof Object) {
					ps.setObject(i + 1, (Object) params[i]);
				} else {
					// 类型不支持异常
					throw new IllegalArgumentException(JdbcConstant.TYPE_NOT_SUPPORT);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param ps
	 * @param params
	 */
	public static void setValue(final PreparedStatement ps, final List<Object> params)
	{
		final Object[] objs = params.toArray();
		
		setValue(ps, objs);
	}
	
}
