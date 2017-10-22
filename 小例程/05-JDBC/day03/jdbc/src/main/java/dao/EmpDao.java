package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import util.DBUtil;

public class EmpDao implements Serializable {

	/**
	 * 新增一个员工
	 */
	public void save(Emp e) {
		
	}
	
	/**
	 * 根据ID修改一个员工
	 * */
	public void update(Emp e) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"update emps_lhh set "
				+ "ename=?,"
				+ "job=?,"
				+ "mgr=?,"
				+ "hiredate=?,"
				+ "sal=?,"
				+ "comm=?,"
				+ "deptno=? "
				+ "where empno=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getJob());
			ps.setInt(3, e.getMgr());
			ps.setDate(4, e.getHiredate());
			ps.setDouble(5, e.getSal());
			ps.setDouble(6, e.getComm());
			ps.setInt(7, e.getDeptno());
			ps.setInt(8, e.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"修改员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 根据ID删除一个员工
	 * */
	public void delete(int id) {
		
	}
	
	/**
	 * 根据ID查询一个员工
	 * */
	public Emp findById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh "
				+ "where empno=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Emp e = createEmp(rs);
				return e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"查询员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

	/**
	 * Alt+Shift+M
	 * */
	private Emp createEmp(ResultSet rs) throws SQLException {
		Emp e = new Emp();
		e.setEmpno(rs.getInt("empno"));
		e.setEname(rs.getString("ename"));
		e.setJob(rs.getString("job"));
		e.setMgr(rs.getInt("mgr"));
		e.setHiredate(rs.getDate("hiredate"));
		e.setSal(rs.getDouble("sal"));
		e.setComm(rs.getDouble("comm"));
		e.setDeptno(rs.getInt("deptno"));
		return e;
	}
	
	/**
	 * 查询某一页员工数据
	 * */
	public List<Emp> findByPage(
		int page, int size) {
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
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();
			List<Emp> list = new ArrayList<Emp>();
			while(rs.next()) {
				list.add(createEmp(rs));
			}
			return list;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"查询员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 查询某部门内的员工
	 * */
	public List<Emp> findByDept(int deptno) {
		return null;
	}
	
}














