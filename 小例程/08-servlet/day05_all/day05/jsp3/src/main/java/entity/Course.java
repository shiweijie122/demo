package entity;

import java.io.Serializable;

public class Course implements Serializable {

	//对象的属性
	private Integer courseId;
	private String name;
	private Integer days;
	
	//Bean的属性看get和set方法:
	//1.从该方法上直观反映出来的属性叫Bean属性
	//2.将get/set删除并将首字母小写所得到的单词
	public Integer getId() {
		return courseId;
	}
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}








