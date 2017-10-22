package dao;

import java.util.List;
import java.util.Map;

import entity.Emp;
import entity.Employee;

/**
 * DAO接口
 *
 */
public interface EmployeeDAO {
	public void save(Employee e);
	public List<Employee> findAll();
	public Employee findById(int id);
	public void update(Employee e);
	public void delete(int id);
	public Map findById2(int id);
	public Emp findById3(int id);
	
}









