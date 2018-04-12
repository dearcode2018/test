/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import java.io.File;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.xml.sax.InputSource;

import com.hua.log.BaseLog;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	// db 配置
	public DatabaseConfig dbConfig;
	
	// dbUnit connection
	public IDatabaseConnection dbUnitConn;
	
	// 备份数据
	public QueryDataSet backupDataSet;
	
	public File backupFile;
	
	// 录入数据
	public IDataSet importDataSet;
	
	// 还原数据
	public IDataSet revertDataSet;
	
	// 输入源
	public InputSource inputSource;
	
	// xml供应者
	public FlatXmlProducer flatXmlProducer;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}

}
