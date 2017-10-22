package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import util.DBTool;

/**
 * 1.JUnit可以让类中的每个方法单独执行
 * 2.对方法的要求:
 * 	- 方法是公有的
 * 	- 没有返回值
 * 	- 没有参数
 * 	- 前面必须写@Test注解
 * 3.Junit用来测试,而测试代码在正式WEB项目
 * 	里不需要了,会被连同Junit包一起丢弃,所以
 * 	Junit包不用maven导入也可.
 */
public class TestDay01 {

	/**
	 * 创建连接
	 */
	@Test
	public void test1() {
		System.out.println(1);
		Connection conn = null;
		try {
			//注册驱动,告诉DriverManager用这个类
			Class.forName(
				"oracle.jdbc.driver.OracleDriver");
			//创建连接
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.204.10:1521:orcl", "openlab", "open123");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 使用Properties读取db.properties
	 * 1.此类本质上是Map
	 * 2.专门用来读取properties文件
	 */
	@Test
	public void test2() {
		System.out.println(2);
		Properties p = new Properties();
		//获取ClassLoader,并通过它从classes
		//下读取db.properties
		try {
			p.load(TestDay01.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			System.out.println(p.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试DBTool
	 */
	@Test
	public void test3() {
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}
	
	/**
	 * 执行DML语句
	 */
	@Test
	public void test4() {
		//创建连接
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			//创建Statement,由它执行SQL
			Statement smt = conn.createStatement();
			//执行DML语句
			String sql = 
				"insert into emps_lhh values("
				+ "emps_seq_lhh.nextval,"
				+ "'唐僧','领导',0,sysdate,9000.0,6000.0,2)";
			//返回DML语句所影响的行数
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}
	
	/**
	 * 执行DQL语句
	 */
	@Test
	public void test5() {
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement smt = 
				conn.createStatement();
			String sql = 
				"select * from emps_lhh "
				+ "order by empno";
			//结果集,里面封装了多行多列的数据,
			//该对象采用了迭代器模式,通常使用
			//while进行遍历.
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()) {
				//每次遍历就可以从rs内获得下一行数据
				//rs.get类型(字段名)
				//rs.get类型(字段序号)
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}
	
}







