package day03;

import java.util.Collection;
import java.util.ArrayList;

/**
 * 集合的add方法 
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		//Collection是父类型,是接口
		//ArrayList 是具体子类型, 实现了
		//Collection接口, Collection中定义
		//的方法, ArrayList全部都实现了
		Collection c = new ArrayList();
		//Collection的add方法
		//将元素添加到集合中, c代表集合
		// 将"Tom" 添加到集合c中
		// 有返回值: true元素添加成功 false
		boolean b = c.add("Tom");
		System.out.println(b); //true
		System.out.println(c); //[Tom]
		//集合中可以添加多个元素
		c.add("Jerry");
		c.add("Andy");
		c.add("Andy");
		System.out.println(c); 
	}
}



