/**
 * 描述: 
 * DbUnitTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.dbunit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.ext.oracle.Oracle10DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.xml.sax.InputSource;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.db.JdbcUtil;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * DbUnitTest
 */
public final class DbUnitTest extends BaseTest
{

	/**
	 * 
	 * 描述: 备份测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackup() {
		try {
			String backupTable = "course";
			final Connection conn = JdbcUtil.getConnection();
			dbUnitConn = new DatabaseConnection(conn);
			
			//
			dbConfig = dbUnitConn.getConfig();
			// 数据类型工厂 - 这里采用 oracle
			dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new Oracle10DataTypeFactory());
			
			//
			backupDataSet = new QueryDataSet(dbUnitConn);
			
			//
			backupDataSet.addTable(backupTable);
			
			// 备份文件
			// 临时文件，进程结束 自动删除
			//final File file = File.createTempFile(ClassPathUtil.getClassPath("/conf/xml/")+ backupTable +"_back", ".xml");
			final File file = new File(ClassPathUtil.getClassPath("/conf/xml/") + backupTable +"_back.xml");
			
			// 执行备份
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(file));
			
		} catch (Exception e) {
			log.error("testBackup =====> ", e);
		} finally 
		{
			try
			{
				if (null != dbUnitConn)
				{
					dbUnitConn.close();
				}
				// 关闭 java.sql.Connection
				//JdbcUtil.close();
			} catch (SQLException e)
			{
				log.error("testBackup =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 先备份，然后录入准备的数据，并不还原数据表
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testImport() {
		try {
			String backupTable = "student";
			final Connection conn = JdbcUtil.getConnection();
			dbUnitConn = new DatabaseConnection(conn);
			
			//
			dbConfig = dbUnitConn.getConfig();
			// 数据类型工厂 - 这里采用 oracle
			dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new Oracle10DataTypeFactory());
			
			//
			backupDataSet = new QueryDataSet(dbUnitConn);
			
			//
			backupDataSet.addTable(backupTable);
			
			// 备份文件
			// 临时文件，进程结束 自动删除
			//final File file = File.createTempFile(ClassPathUtil.getClassPath("/conf/xml/")+ backupTable +"_back", ".xml");
			final File file = new File(ClassPathUtil.getClassPath("/conf/xml/") + backupTable +"_back.xml");
			
			// 执行备份
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(file));
			
			//
			final InputSource inputSource = new InputSource(ClassPathUtil.getInputStream("/conf/xml/dbunit/student_prepare.xml"));
			final FlatXmlProducer producer = new FlatXmlProducer(inputSource);
			
			
			// 读入准备的数据 (除了 FlatXmlDataSet(FlatXmlProducer) 构造方法，其他构造方法都过时了)
			importDataSet = new FlatXmlDataSet(producer);
			log.info("testImport =====> 执行录入 (先清理，然后再插入) ");
			// 执行录入 (先清理，然后再插入)
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, importDataSet);
			
			//
			
		} catch (Exception e) {
			log.error("testImport =====> ", e);
		} finally 
		{
			try
			{
				if (null != dbUnitConn)
				{
					dbUnitConn.close();
				}
				// 关闭 java.sql.Connection
				//JdbcUtil.close();
			} catch (SQLException e)
			{
				log.error("testImport =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 备份 - 录入数据 - 还原
	 * 说明: 此方法以单张表的 备份/录入/测试/还原 为例，多张表注意命名即可.
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRevert() {
		try {
			// 初始部分
			final Connection conn = JdbcUtil.getConnection();
			dbUnitConn = new DatabaseConnection(conn);
			
			// 数据库配置
			dbConfig = dbUnitConn.getConfig();
			// 数据类型工厂 - 这里采用 oracle
			dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new Oracle10DataTypeFactory());
			
			
			/** begin 1.数据备份 */
			// 
			String backupTable = "student";
			// 备份数据集
			backupDataSet = new QueryDataSet(dbUnitConn);
			// 添加表 (允许多个)
			backupDataSet.addTable(backupTable);
			
			// 备份文件
			// 临时文件，进程结束 自动删除
			//final File file = File.createTempFile(ClassPathUtil.getClassPath("/conf/xml/")+ backupTable +"_back", ".xml");
			backupFile = new File(ClassPathUtil.getClassPath("/conf/xml/") + backupTable +"_back.xml");
			
			// 执行备份
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(backupFile));
			
			/** end of 1.数据备份 */
			
			
			/** begin 2.录入数据 */
			//
			inputSource = new InputSource(ClassPathUtil.getInputStream("/conf/xml/dbunit/student_prepare.xml"));
			flatXmlProducer = new FlatXmlProducer(inputSource);
			
			// 读入准备的数据 (除了 FlatXmlDataSet(FlatXmlProducer) 构造方法，其他构造方法都过时了)
			importDataSet = new FlatXmlDataSet(flatXmlProducer);
			log.info("testRevert =====> 执行录入 (先清理，然后再插入) ");
			// 执行录入 (先清理，然后再插入)
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, importDataSet);
			
			/** end of 2.录入数据 */
			
			
			/** begin 3.测试部分 */
			// 还原数据表之前，可以在这里执行测试操作 (备份 - 录入数据 - 测试 - 还原)
			
			
			/** end of 3.测试部分 */
			
		
			/** begin 4.还原数据 */
			log.info("testRevert =====> begin 还原数据");
			// 还原数据
			inputSource = new InputSource(new FileInputStream(backupFile));
			flatXmlProducer = new FlatXmlProducer(inputSource);
			revertDataSet = new FlatXmlDataSet(flatXmlProducer);
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, revertDataSet);
			log.info("testRevert =====> end 还原数据");
			
			/** end of 4.还原数据 */
			
			
		} catch (Exception e) {
			log.error("testRevert =====> ", e);
		} finally 
		{
			try
			{
				if (null != dbUnitConn)
				{
					dbUnitConn.close();
				}
				// 关闭 java.sql.Connection
				//JdbcUtil.close();
			} catch (SQLException e)
			{
				log.error("testRevert =====> ", e);
			}
		}
	}
	
	/**
	 * 标准部分
	 * 描述: 备份 - 录入数据 - 还原
	 * 说明: 此方法以单张表的 备份/录入/测试/还原 为例，多张表注意命名即可.
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStandard() {
		try {
			// 初始部分
			final Connection conn = JdbcUtil.getConnection();
			dbUnitConn = new DatabaseConnection(conn);
			
			// 数据库配置
			dbConfig = dbUnitConn.getConfig();
			// 数据类型工厂 - 这里采用 oracle
			dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new Oracle10DataTypeFactory());
			
			
			/** begin 1.数据备份 */
			// 
			String backupTable = "student";
			// 备份数据集
			backupDataSet = new QueryDataSet(dbUnitConn);
			// 添加表 (允许多个)
			backupDataSet.addTable(backupTable);
			
			// 备份文件
			// 临时文件，进程结束 自动删除
			//final File file = File.createTempFile(ClassPathUtil.getClassPath("/conf/xml/")+ backupTable +"_back", ".xml");
			backupFile = new File(ClassPathUtil.getClassPath("/conf/xml/") + backupTable +"_back.xml");
			
			// 执行备份
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(backupFile));
			
			/** end of 1.数据备份 */
			
			
			/** begin 2.录入数据 */
			//
			inputSource = new InputSource(ClassPathUtil.getInputStream("/conf/xml/dbunit/student_prepare.xml"));
			flatXmlProducer = new FlatXmlProducer(inputSource);
			
			// 读入准备的数据 (除了 FlatXmlDataSet(FlatXmlProducer) 构造方法，其他构造方法都过时了)
			importDataSet = new FlatXmlDataSet(flatXmlProducer);
			log.info("testStandard =====> 执行录入 (先清理，然后再插入) ");
			// 执行录入 (先清理，然后再插入)
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, importDataSet);
			
			/** end of 2.录入数据 */
			
			
			/** begin 3.测试部分 */
			// 还原数据表之前，可以在这里执行测试操作 (备份 - 录入数据 - 测试 - 还原)
			
			
			/** end of 3.测试部分 */
			
		
			/** begin 4.还原数据 */
			log.info("testStandard =====> begin 还原数据");
			// 还原数据
			inputSource = new InputSource(new FileInputStream(backupFile));
			flatXmlProducer = new FlatXmlProducer(inputSource);
			revertDataSet = new FlatXmlDataSet(flatXmlProducer);
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, revertDataSet);
			log.info("testStandard =====> end 还原数据");
			
			/** end of 4.还原数据 */
			
			
		} catch (Exception e) {
			log.error("testStandard =====> ", e);
		} finally 
		{
			try
			{
				if (null != dbUnitConn)
				{
					dbUnitConn.close();
				}
				// 关闭 java.sql.Connection
				//JdbcUtil.close();
			} catch (SQLException e)
			{
				log.error("testStandard =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		} finally 
		{
			try
			{
				if (null != dbUnitConn)
				{
					dbUnitConn.close();
				}
				// 关闭 java.sql.Connection
				//JdbcUtil.close();
			} catch (SQLException e)
			{
				log.error("test =====> ", e);
			}
		}
	}
	
}
