package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository("empDAO")
public class EmployeeDAO {
	
	@Autowired
	@Qualifier("jt")
	private JdbcTemplate jt;
	
	/**
	 * JdbcTemplate提供了很多实用的方法
	 * 来访问数据库。不再需要考虑如何获取
	 * 连接与关闭连接。另外，还会将底层的
	 * jdbc异常统一转换成了一些
	 * RuntimeException然后抛出。
	 */
	public void save(Employee e){
		String sql =
			"INSERT INTO t_emp "
		+ "VALUES(t_emp_seq.nextval,?,?,?)";
		Object[] args = 
			{e.getName(),e.getSalary(),
					e.getAge()};
		jt.update(sql, args);
	}
	
	public List<Employee> findAll(){
		String sql = "SELECT * FROM t_emp";
		return jt.query(sql, new EmpRowMapper());
	}
	
	public Employee findById(int id){
		String sql = "SELECT * FROM t_emp "
				+ "WHERE id=?";
		Object[] args = {id};
		Employee e;
		try{
			e = jt.queryForObject(
					sql, args,new EmpRowMapper());
		}catch(EmptyResultDataAccessException e1){
			return null;
		}
		return e;
	}
	
	public void update(Employee e){
		String sql = "UPDATE t_emp "
				+ "SET name=?,salary=?,age=? "
				+ "WHERE id=?";
		Object[] args = {e.getName(),
				e.getSalary(),
				e.getAge(),e.getId()};
		jt.update(sql, args);
	}
	
	public void delete(int id){
		String sql = "DELETE FROM t_emp "
				+ "WHERE id=?";
		Object[] args =	{id};
		jt.update(sql, args);
	}
	
	/*
	 * 告诉JdbcTemplate，如何将一条记录
	 * 转换成一个实体对象。
	 */
	class EmpRowMapper 
		implements RowMapper<Employee>{
		// index:正在被处理的记录的下标
		//（从0开始）
		public Employee mapRow(
				ResultSet rs, int index) 
						throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			return e;
		}
		
		
	}
}





