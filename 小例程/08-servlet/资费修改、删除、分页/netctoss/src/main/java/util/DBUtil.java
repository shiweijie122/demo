package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {

	private static BasicDataSource ds;

	static {
		try {
			Properties prop = new Properties();
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			String driverName = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			int maxActive = Integer.parseInt(prop.getProperty("ds.maxActive"));
			int maxWait = Integer.parseInt(prop.getProperty("ds.maxWait"));
			// ʵ�������ӳ�
			ds = new BasicDataSource();
			// �������ӳز���
			ds.setDriverClassName(driverName);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			// �������������
			ds.setMaxActive(maxActive);
			// �������ȴ�ʱ��
			ds.setMaxWait(maxWait);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			// �����ӳ��л�ȡ����
			conn = ds.getConnection();
		} catch (Exception e) {
			// ��־
			e.printStackTrace();
			throw e;
		}
		return conn;
	}

	/**
	 * �ر����ݿ������
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
}
