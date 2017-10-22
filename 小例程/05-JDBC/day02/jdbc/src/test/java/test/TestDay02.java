package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class TestDay02 {
	
	/**
	 * 测试DBUtil
	 */
	@Test
	public void test1() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	/**
	 * 使用DBUtil创建连接,
	 * 并执行一个update语句.
	 * 该语句所需数据不要写死,
	 * 而是动态的拼接.
	 */
	@Test
	public void test2() {
		//假设浏览器传入的数据如下:
		int empno = 1;
		String ename = "张三丰";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement smt = conn.createStatement();
			String sql = 
				"update emps_lhh set "
				+ "ename='" + ename + "' "
				+ "where empno=" + empno;
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 使用PS执行DML语句
	 */
	@Test
	public void test3() {
		//假设浏览器传入的删除条件是
		int empno = 1;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//向数据库发送SQL,数据库会
			//检查SQL并将其编译成计划.
			String sql = 
				"delete from emps_lhh "
				+ "where empno=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			//给?赋值,将值暂存到PS里,
			//由PS一次性发送给数据库.
			//ps.set类型(?的序号,?的值)
			ps.setInt(1, empno);
			//发送?的值,让数据库执行计划
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 使用PS执行DQL语句
	 */
	@Test
	public void test4() {
		//假设浏览器传入的查询条件是
		int deptno = 1;
		double salary = 5000.0;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//ctl + shift + X/Y
			String sql = 
				"select * from emps_lhh "
				+ "where deptno=? and sal>?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			ps.setDouble(2, salary);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getDouble("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 使用PS执行查询,模拟登录.
	 * 看看传入不正经的密码时,
	 * 会不会登录成功.
	 */
	@Test
	public void test5() {
		//假设传入的账号密码如下:
		String username = "zhangsan";
		String password = "a' or 'b'='b";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from users_lhh "
				+ "where username=? "
				+ "and password=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * ResultSetMetaData
	 */
	@Test
	public void test6() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			//获取结果集元数据
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnCount());
			System.out.println(md.getColumnName(1));
			System.out.println(md.getColumnTypeName(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 模拟实现转账的业务:
	 * 
	 * 假设:当前用户已经登录了网银,
	 * 	并且输入了收款方的账号,以及
	 * 	转账的金额,点击按钮开始转账.
	 * 
	 * 转账的步骤:
	 * 	1.查询付款方账号,看余额够不够
	 * 	2.查询收款方账号,看是否正确
	 * 	3.修改付款方账号,-N元
	 *  4.修改收款方账号,+N元
	 * 
	 * 注意:转账是一个完整的业务,要保证
	 * 在一个事务之内,所以只创建一个连接.
	 */
	@Test
	public void test7() {
		//假设用户输入信息如下:
		//付款账号
		String payId = "00001";
		//收款账号
		String recId = "00002";
		//转账金额
		double mny = 1000.0;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//1.查询付款方账号,看余额够不够
			String sql = 
				"select * from accounts_lhh "
				+ "where id=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, payId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			double payMoney = rs.getDouble("money");
			if(payMoney < mny) {
				System.out.println("余额不足");
				return;
			}
			//2.查询收款方账号,看是否正确
			String sql2 = 
				"select * from accounts_lhh "
				+ "where id=?";
			PreparedStatement ps2 = 
				conn.prepareStatement(sql2);
			ps2.setString(1, recId);
			ResultSet rs2 = ps2.executeQuery();
			if(!rs2.next()) {
				System.out.println("收款账号不存在");
				return;
			}
			double recMoney = rs2.getDouble("money");
			//3.修改付款方账号,-N元
			String sql3 = 
				"update accounts_lhh set "
				+ "money=? where id=?";
			PreparedStatement ps3 = 
				conn.prepareStatement(sql3);
			ps3.setDouble(1, payMoney-mny);
			ps3.setString(2, payId);
			ps3.executeUpdate();
			//4.修改收款方账号,+N元
			String sql4 = 
				"update accounts_lhh set "
				+ "money=? where id=?";
			PreparedStatement ps4 = 
				conn.prepareStatement(sql4);
			ps4.setDouble(1, recMoney+mny);
			ps4.setString(2, recId);
			ps4.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
}









