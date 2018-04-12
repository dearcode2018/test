/**
 * DbUnitUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.datatype.IDataTypeFactory;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.ext.oracle.Oracle10DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.xml.sax.InputSource;

import com.hua.util.ClassPathUtil;
import com.hua.util.db.JdbcUtil;

/**
 * DbUnitUtil
 * 描述: 
 * @author  qye.zheng
 * 
 */
public final class DbUnitUtil
{
	// db 配置
	public static DatabaseConfig dbConfig;
	
	// dbUnit connection
	public static IDatabaseConnection dbUnitConn;
	
	// 备份数据
	public static QueryDataSet backupDataSet;
	
	public static File backupFile;
	
	// 录入数据
	public static IDataSet importDataSet;
	
	// 还原数据
	public static IDataSet revertDataSet;
	
	// 输入源
	public static InputSource inputSource;
	
	// xml供应者
	public static FlatXmlProducer flatXmlProducer;	
	
	static 
	{
		try
		{
			// 初始部分
			final Connection conn = JdbcUtil.getConnection();
			dbUnitConn = new DatabaseConnection(conn);
			
			// 数据库配置
			dbConfig = dbUnitConn.getConfig();
			
			//  TODO 数据类型工厂 - 这里采用 oracle (不同的数据库，需要修改这里)
			final IDataTypeFactory dataTypeFactory = new Oracle10DataTypeFactory();
			
			dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, dataTypeFactory);
			
		} catch (DatabaseUnitException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 单张表 操作 执行顺序 : 
	 备份 - 录入数据 - 测试 - 还原
	 */
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * 
	 */
	private DbUnitUtil()
	{
	}
	
	/**
	 * 
	 * 描述: 单张表备份
	 * @author  qye.zheng
	 * 
	 * @param backupTable
	 * @return
	 */
	public static boolean singleTableBackup(final String backupTable)
	{
		boolean flag = false;
		try
		{
			// 备份数据集
			backupDataSet = new QueryDataSet(dbUnitConn);
			// 添加表 (允许多个)
			backupDataSet.addTable(backupTable);
			
			// 备份文件
			// 临时文件，进程结束 自动删除
			//final File file = File.createTempFile(ClassPathUtil.getClassSubpath("/conf/xml/")+ backupTable +"_back", ".xml");
			backupFile = new File(ClassPathUtil.getClassSubpath("/conf/xml/") + backupTable +"_back.xml");
			
			// 执行备份
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(backupFile));
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 单张表录入
	 * @author  qye.zheng
	 * 
	 * @param prepareFilePath
	 * @return
	 */
	public static boolean singleTableImport(final String prepareFilePath)
	{
		boolean flag = false;
		try
		{
			// /conf/xml/dbunit/student_prepare.xml
			inputSource = new InputSource(ClassPathUtil.getInputStream(prepareFilePath));
			flatXmlProducer = new FlatXmlProducer(inputSource);
			
			// 读入准备的数据 (除了 FlatXmlDataSet(FlatXmlProducer) 构造方法，其他构造方法都过时了)
			importDataSet = new FlatXmlDataSet(flatXmlProducer);
			System.out.println("singleTableImport =====> 执行录入 (先清理，然后再插入) ");
			// 执行录入 (先清理，然后再插入)
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, importDataSet);
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 单张表还原
	 * @author  qye.zheng
	 * 
	 * @return
	 */
	public static boolean singleTableRevert()
	{
		boolean flag = false;
		try
		{
			System.out.println("singleTableRevert =====> begin 还原数据");
			// 还原数据
			inputSource = new InputSource(new FileInputStream(backupFile));
			flatXmlProducer = new FlatXmlProducer(inputSource);
			revertDataSet = new FlatXmlDataSet(flatXmlProducer);
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, revertDataSet);
			System.out.println("singleTableRevert =====> end 还原数据");
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

}
