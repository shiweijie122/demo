package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 自定义排序 
 */
public class SortDemo02 {
	public static void main(String[] args) {
		List<Student> sutdents=
				new ArrayList<Student>();	
		sutdents.add(new Student("Tom",90));
		sutdents.add(new Student("Jerry",78));
		sutdents.add(new Student("Andy", 66));
		sutdents.add(new Student("Wang", 80));

		//sort自定义排序:
		// .sort(被排序的集合, 比较规则);
		Collections.sort(sutdents, new ByScore());
		System.out.println(sutdents); 
	}
}
//自定义比较规则, 按照学生分数比较大小
class ByScore implements Comparator<Student>{
	public int compare(
			Student o1, Student o2) {
		return -(o1.score - o2.score);
	}
}

class Student{
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}















