package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dao.EmpDao;
import entity.Emp;
import util.DBUtil;

public class TestDay03 {

	/**
	 * 批量添加108个员工,
	 * 每一批添加50个.
	 */
	@Test
	public void test1() {
		//类似于导入这样的功能,
		//它是一个完整的业务,所以
		//只需要一个事务.
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			String sql = 
				"insert into emps_lhh values("
				+ "emps_seq_lhh.nextval,"
				+ "?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			for(int i=1;i<=108;i++) {
				ps.setString(1, "好汉" + i);
				ps.setString(2, "打劫");
				ps.setInt(3, 0);
				ps.setDate(4, new Date(
					System.currentTimeMillis()));
				ps.setDouble(5, 5000.0);
				ps.setDouble(6, 6000.0);
				ps.setInt(7, 9);
				//每一条数据都暂存到ps上
				ps.addBatch();
				if(i%50==0) {
					//每存50条就提交一次
					ps.executeBatch();
					//清空数据,以便下一轮提交
					ps.clearBatch();
				}
			}
			
			//为了避免有零头,再单独提交一次
			ps.executeBatch();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 1.先增加一个部门
	 * 2.再给这个部门增加一个员工
	 */
	@Test
	public void test2() {
		//假设网页传入的部门数据是
		String dname = "测试部";
		String loc = "雄安";
		//假设网页传入的员工数据是
		String ename = "张三";
		String job = "经理";
		int mgr = 0;
		Date hiredate = new Date(
			System.currentTimeMillis());
		double sal = 8000.0;
		double comm = 3000.0;
		//一个业务,一个事务
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			//增加部门
			String sql = 
				"insert into depts_lhh "
				+ "values(depts_seq_lhh.nextval,?,?)";
			//参数2是字段名数组,用来告诉ps,
			//希望它返回哪些(键)字段的值.
			PreparedStatement ps = 
				conn.prepareStatement(sql,
					new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();
			//获取自动生成的部门主键
			//由于只增加一行数据,所以返回的结果集
			//内只有一行数据.因为之前声明了要返回
			//一个字段(deptno),所以结果集中只有一列.
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			//通过这种方式获得的结果集,
			//从中取数必须用字段序号来取.
			int deptno = rs.getInt(1);
			//增加员工
			String sql2 = 
				"insert into emps_lhh values("
				+ "emps_seq_lhh.nextval,"
				+ "?,?,?,?,?,?,?)";
			PreparedStatement ps2 = 
				conn.prepareStatement(sql2);
			ps2.setString(1, ename);
			ps2.setString(2, job);
			ps2.setInt(3, mgr);
			ps2.setDate(4, hiredate);
			ps2.setDouble(5, sal);
			ps2.setDouble(6, comm);
			ps2.setInt(7, deptno);
			ps2.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 分页查询员工
	 */
	@Test
	public void test3() {
		//假设用户点击了第2页
		int page = 2;
		//假设需求规定了每页显示10条
		int size = 10;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from ("
				+ "	select e.*,rownum r from ("
				+ "		select * from emps_lhh "
				+ "		order by empno"
				+ "	) e"
				+ ") where r between ? and ?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			//起始行
			ps.setInt(1, (page-1)*size+1);
			//终止行
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getInt("empno") + "," +
					rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 测试findById()和update()
	 * */
	@Test
	public void test4() {
		EmpDao dao = new EmpDao();
		//先查询出旧的数据
		Emp e = dao.findById(2);
		//对此数据加以修改
		e.setEname("李斯");
		e.setJob("经理");
		dao.update(e);
	}
	
}












