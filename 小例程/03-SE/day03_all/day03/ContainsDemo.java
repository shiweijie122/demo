package day03;

import java.util.ArrayList;
import java.util.Collection;

public class ContainsDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("Tom");
		c.add("Jerry");
		c.add("Andy");
		c.add("Mac");
		//检查集合中是否包含Mac
		boolean b = c.contains("Mac");
		System.out.println(b);
		//检查集合中是否包含Lee
		b = c.contains("Lee");
		System.out.println(b);
		//检查集合中元素的个数
		int n = c.size();
		System.out.println(n);//4
		//清空集合的内容
		c.clear();//清空
		//检查集合是否为空集
		boolean emp = c.isEmpty();
		System.out.println(emp);//true	
	}
}






