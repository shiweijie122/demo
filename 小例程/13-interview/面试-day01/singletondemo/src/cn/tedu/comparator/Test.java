package cn.tedu.comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class Test {
	TreeSet<Student> set = null;
	public static void main(String[] args) {
		Test test = new Test();
		test.studentSort();
		test.show();
	}

	private void show() {
		for(Student stu:set){
			System.out.println(stu);
		}
	}

	public void studentSort(){
		set = new TreeSet<>(new ByScore());
		for(int i=0;i<1000000;i++){
		 Student student = 
			new Student(i, "用户"+i,(int)( Math.random()*60000));
		 set.add(student);
		 if(set.size()>100){
			Iterator<Student> it = 
					set.iterator();
			it.next();
			it.remove();
		 }
		}
	}
}
