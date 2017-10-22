package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
	
	private static String url;
	private static String user;
	private static String pwd;
	
	static {
		Properties p = new Properties();
		try {
			//加载配置文件
			p.load(DBTool.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			//注册驱动
			Class.forName(driver);
		} catch (IOException e) {
			//异常的处理原则:
			//1.记录日志
			e.printStackTrace();
			//2.能处理则处理,具体参考开发规范
			//3.不能处理则抛出
			throw new RuntimeException(
				"加载db.properties失败!",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"找不到驱动类!",e);
		}
	}

	public static Connection getConnection() 
		throws SQLException {
		return DriverManager
			.getConnection(url, user, pwd);
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"关闭连接失败!",e);
		}
	}
	
}









