/**
 * 描述: 
 * ParameterTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.junit5;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.hua.annotation.CsvToResource;
import com.hua.argument.MyArgumentProvider;
import com.hua.convert.JsonArgumentConvert;
import com.hua.entity.ResourceVo;
import com.hua.entity.User;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ParameterTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class ParameterTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源
	@ValueSource(strings = {"xx", "my", "zhangsan",  "name"})
	public void testParameterized(String candicate) {
		try {
			
			assertTrue("zhangsan".equals(candicate));
			
		} catch (Exception e) {
			log.error("testParameterized =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源
	@ValueSource(strings = {"xx", "my", "zhangsan",  "name"})
	public void testValueSource(String candicate) {
		try {
			System.out.println("candicate = " + candicate);
			assertTrue("zhangsan".equals(candicate));
			
		} catch (Exception e) {
			log.error("testValueSource =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	/*
	 * {index} 代表索引, {0} 代表第一个参数
	 */
	@ParameterizedTest(name = "{index} first = {0}, second = {1}")
	// 参数值源
	@CsvSource({"xx, 1", "my, 2", "zhangsan, 3",  "name, 55"})
	public void testFormatOutput(String value1, String value2) {
		try {
			System.out.println("value1 = " + value1);
			System.out.println("value2 = " + value2);
		} catch (Exception e) {
			log.error("testFormatOutput =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源， 使用了字符串隐式转化
	@ValueSource(strings = {"d043e930-7b3b-48e3-bdbe-5a3ccfb833db", "d043e931-7b32-48e1-bdbe-5a3c5fb833db"})
	public void testValueSource2(UUID candicate) {
		try {
			System.out.println("candicate = " + candicate.toString());
			
		} catch (Exception e) {
			log.error("testValueSource2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源， 使用了字符串隐式转化
	@ValueSource(strings = {"UTF-8"})
	public void testValueSource3(Charset candicate) {
		try {
			System.out.println("candicate = " + candicate.displayName());
			
		} catch (Exception e) {
			log.error("testValueSource3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源， 使用了字符串隐式转化
	@ValueSource(strings = {"2017-11-25", "2018-12-25"})
	public void testValueSource4(LocalDate candicate) {
		try {
			System.out.println("candicate = " + candicate.toString());
			
		} catch (Exception e) {
			log.error("testValueSource4 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	/*
	 * 参数值源，隐式转换，一个字符串给目标类型的单个参数构造方法/工厂方法
	 * 工厂方法，单个字符串参数
	 * 1. 构造方法
	 * 2. 非私有的静态工厂方法
	 * 
	 * 若构造方法和静态工厂方法同时存在，优先调用静态工厂方法
	 * 
	 * 若有多个静态工厂方法，则优先调用构造方法
	 */
	@ValueSource(strings = {"zhangsan", "lsi"})
	public void testValueSourceX(User candicate) {
		try {
			System.out.println("candicate = " + candicate.getUsername());
			
		} catch (Exception e) {
			log.error("testValueSourceX =====> ", e);
		}
	}
	
	@ParameterizedTest
	/*
	 * 参数值源，显示转换 指定参数转换器
	 * 
	 */
	@ValueSource(strings = {"{\"username\":\"zhangsan\"}", "{\"username\":\"lsi\"}"})
	public void testValueSourceY(@ConvertWith(JsonArgumentConvert.class) User candicate) {
		try {
			System.out.println("candicate = " + candicate.getUsername());
		} catch (Exception e) {
			log.error("testValueSourceX =====> ", e);
		}
	}
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	//@ParameterizedTest
	// 参数值源，name 指定可选的参数名，若不指定则使用所有参数，模式默认是包含
	//@EnumSource(value = UserType.class)
	//@EnumSource(value = UserType.class, names = {"SHOP_MANAGER", "GROUP"})
	/*@EnumSource(value = UserType.class, mode = Mode.EXCLUDE, 
	names = {"SHOP_MANAGER", "GROUP"})*/
	// 使用正则表达式 MATCH_ALL或MATHCH_ANY
	//@EnumSource(value = UserType.class, mode = Mode.MATCH_ALL, names = {"^SHOP.*$"})
	/*
	 * public void testEnumSource(UserType candicate) { try {
	 * 
	 * System.out.println(candicate.getRemark());
	 * 
	 * } catch (Exception e) { log.error("testEnumSource =====> ", e); } }
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 方法源，内部、外部方法
	@MethodSource(value = {"stringProvider", "com.hua.factory.ParamterFactory#iterator"})
	/*
	 * 若不提供参数，则默认搜索与当前方法同名的静态工厂方法
	 * 该设计只是人性化了，但不建议采用这种方式
	 */
	//@MethodSource
	public void testMethodSource(String candicate) {
		try {
			
			/*
			 * 引用工厂方法
			 * 测试类: 静态工厂方法或实例方法(必须用@TestInstance(Lifecycle.PER_CLASS)标注)
			 * 
			 * 外部类: 静态工厂方法
			 * 
			 * 工厂方法要求: 返回流、可迭代、迭代器、参数数组，工厂方法不接收任何参数
			 * 
			 * 支持 IntStream DoubleStream LongStream 原始流
			 * 
			 */
			
			System.out.println("candicate = " + candicate);
			
		} catch (Exception e) {
			log.error("testMethodSource =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	static Stream<String> stringProvider()
	{
		return Stream.of("abc", "kkl", "cc");
	}
	
	static Stream<String> testMethodSource()
	{
		return Stream.of("abc", "kkl", "cc");
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 方法源，内部、外部方法
	/*
	 * 若不提供参数，则默认搜索与当前方法同名的静态工厂方法
	 * 该设计只是人性化了，但不建议采用这种方式
	 */
	//@MethodSource
	// 多个参数 就需要返回参数实例的集合或流
	@MethodSource(value = {"stringIntAndListProvider"})
	public void testMethodSource2(String str, int num, List<String> list) {
		try {
			
			/*
			 * 引用工厂方法
			 * 测试类: 静态工厂方法或实例方法(必须用@TestInstance(Lifecycle.PER_CLASS)标注)
			 * 
			 * 外部类: 静态工厂方法
			 * 
			 * 工厂方法要求: 返回流、可迭代、迭代器、参数数组，工厂方法不接收任何参数
			 * 
			 * 支持 IntStream DoubleStream LongStream 原始流
			 * 
			 */
			
			System.out.println("candicate = " + str + " num  = " + num + ", list = " + list.size());
			
		} catch (Exception e) {
			log.error("testMethodSource2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public static final Stream<Arguments> stringIntAndListProvider()
	{
		return Stream.of(Arguments.of("foo", 2, Arrays.asList("xx", "dd")),
				Arguments.of("bar", 34, Arrays.asList("xx")));
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源
	//@CsvSource(value = {"xx, 1", "my, 3", "zhangsan, 8",  "name, 223"})
	// 也可自定义分隔符
	//@CsvSource(value = {"xx, 1", "my, 3", "zhangsan, 8",  "name, 223"}, delimiter = ',')
	// 内部可用单引号包围起来作为一个独立的项
	@CsvSource(value = {"xx, 1", "my, 3", "zhangsan, 8",  "'a, kkhh', 223"}, delimiter = ',')
	public void testCsvSource(String first, int num) {
		try {
			/**
			 * CsvSource 参数用逗号隔开，和参数列表一一对应
			 */
			System.out.println("first = " + first + ", num = " + num);
			
		} catch (Exception e) {
			log.error("testValueSource =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	/*
	 * numLinesToSkip 跳过多少行，一般用来跳过header
	 */
	@CsvFileSource(resources = {"/conf/资源编码映射.csv"}, numLinesToSkip = 1, encoding = "GB2312")
	public void testCsvFileSource(String code, final String name, int grade) {
		try {
			// cvs 格式示例: 10, APP资源根节点,1
			System.out.println("code = " + code + ", name = " + name + ", grade = " + grade);
			
		} catch (Exception e) {
			log.error("testValueSource =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 聚合参数
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	/*
	 * numLinesToSkip 跳过多少行，一般用来跳过header
	 * 参数较多时，用ArgumentsAccessor来作为入参，通过getX来获取参数
	 */
	@CsvFileSource(resources = {"/conf/资源编码映射.csv"}, numLinesToSkip = 1, encoding = "GB2312")
	public void testCsvFileSource2(ArgumentsAccessor arguments) {
		try {
			// cvs 格式示例: 10, APP资源根节点,1
			System.out.println("code = " + arguments.getString(0) + ", name = " +
			arguments.getString(1) + ", grade = " + arguments.getInteger(2));
			
		} catch (Exception e) {
			log.error("testValueSource2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 自定义聚合参数
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	/*
	 * numLinesToSkip 跳过多少行，一般用来跳过header
	 * 参数较多时，用ArgumentsAccessor来作为入参，通过getX来获取参数
	 */
	@CsvFileSource(resources = {"/conf/资源编码映射.csv"}, numLinesToSkip = 1, encoding = "GB2312")
	public void testCsvFileSource3(@CsvToResource ResourceVo vo) {
		try {
			// cvs 格式示例: 10, APP资源根节点,1
			System.out.println(JacksonUtil.writeAsString(vo));
			
		} catch (Exception e) {
			log.error("testValueSource3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@ParameterizedTest
	// 参数值源
	@ArgumentsSource(value = MyArgumentProvider.class)
	public void testArgumentsSource(String candicate) {
		try {
			System.out.println("candicate = " + candicate);
			
		} catch (Exception e) {
			log.error("testValueSource =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
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
	@DisplayName("testCommon")
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
	@DisplayName("testSimple")
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
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
	}
	
	/*
	 * 字符实例隐式转化为如下类型
	 * 	目标类型 					数据
		boolean/Boolean 	“true” → true
		byte/Byte 	“1” → (byte) 1
		char/Character 	“o” → ‘o’
		short/Short 	“1” → (short) 1
		int/Integer 	“1” → 1
		long/Long 	“1” → 1L
		float/Float 	“1.0” → 1.0f
		double/Double 	“1.0” → 1.0d
		Enum subclass 	“SECONDS” → TimeUnit.SECONDS
		java.io.File 	“/path/to/file” → new File(“/path/to/file”)
		java.nio.file.Path 	“/path/to/file” → Paths.get(“/path/to/file”)
		java.math.BigDecimal 	“123.456e789” → new BigDecimal(“123.456e789”)
		java.math.BigInteger 	“1234567890123456789” → new BigInteger(“1234567890123456789”)
		java.net.URI 	“http://junit.org/” → URI.create(“http://junit.org/“)
		java.net.URL 	“http://junit.org/” → new URL(“http://junit.org/“)
		java.nio.charset.Charset 	“UTF-8” → Charset.forName(“UTF-8”)
		java.time.Instant 	“1970-01-01T00:00:00Z” → Instant.ofEpochMilli(0)
		java.time.LocalDateTime 	“2017-03-14T12:34:56.789” → LocalDateTime.of(2017, 3, 14, 12, 34, 56, 789_000_000)
		java.time.LocalDate 	“2017-03-14” → LocalDate.of(2017, 3, 14)
		java.time.LocalTime 	“12:34:56.789” → LocalTime.of(12, 34, 56, 789_000_000)
		java.time.OffsetDateTime 	“2017-03-14T12:34:56.789Z” → OffsetDateTime.of(2017, 3, 14, 12, 34, 56, 789_000_000, ZoneOffset.UTC)
		java.time.OffsetTime 	“12:34:56.789Z” → OffsetTime.of(12, 34, 56, 789_000_000, ZoneOffset.UTC)
		java.time.YearMonth 	“2017-03” → YearMonth.of(2017, 3)
		java.time.Year 	“2017” → Year.of(2017)
		java.time.ZonedDateTime 	“2017-03-14T12:34:56.789Z” → ZonedDateTime.of(2017, 3, 14, 12, 34, 56, 789_000_000, ZoneOffset.UTC)
		java.time.Currency 	“JPY” → Currency.getInstance(“JPY”)
		java.util.Locale 	“en” → new Locale(“en”)
		java.util.UUID 	“d043e930-7b3b-48e3-bdbe-5a3ccfb833db” → UUID.fromString(“d043e930-7b3b-48e3-bdbe-5a3ccfb833db”)
*/

}
