package entity;

import java.io.Serializable;

public class Emp implements Serializable{
	private int empNo;
	private String ename;
	private double salary;
	private int age;
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", ename=" + ename + ", salary=" + salary + ", age=" + age + "]";
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
