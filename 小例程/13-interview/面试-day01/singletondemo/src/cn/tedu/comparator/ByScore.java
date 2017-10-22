package cn.tedu.comparator;

import java.util.Comparator;

public class ByScore implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getScore()-o2.getScore();
	}

}
