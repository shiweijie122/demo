package dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import entity.Emp;
import entity.Employee;

/**
 * DAO实现类
 *		注：
 *			可通过注入SqlSessionTemplate来简化。
 */
@Repository("empDAO")
public class EmployeeDAOMyBatisImpl 
implements EmployeeDAO{
	
	@Autowired
	@Qualifier("sst")
	private SqlSessionTemplate sst;

	public void save(Employee e) {
		sst.insert("dao.EmployeeDAO.save",
				e);
		//这儿不需要提交事务与关闭SqlSession。
	}

	public List<Employee> findAll() {
		return sst.selectList(
				"dao.EmployeeDAO.findAll");
	}

	public Employee findById(int id) {
		return sst.selectOne(
				"dao.EmployeeDAO.findById",
				id);
	}

	public void update(Employee e) {
		sst.update("dao.EmployeeDAO.update",
				e);
	}

	public void delete(int id) {
		sst.delete("dao.EmployeeDAO.delete",
				id);
	}

	public Map findById2(int id) {
		return sst.selectOne(
				"dao.EmployeeDAO.findById2", id);
	}

	public Emp findById3(int id) {
		return sst.selectOne(
				"dao.EmployeeDAO.findById3", id);
	}

}
