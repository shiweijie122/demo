package day03;

import java.util.Collection;
import java.util.HashSet;
/**
 * 向Set集合中添加元素:
 * set 是无序不可以重复的集合
 * 添加元素时候, 会拒绝重复添加元素, 并且
 * 返回false结果. 
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		Collection c = new HashSet();
		boolean b = c.add("Tom");
		System.out.println(b);//true
		b = c.add("Jerry");
		System.out.println(b);//true
		//重复添加元素, 集合会拒绝添加返回false
		b = c.add("Jerry");
		System.out.println(b);//false
		System.out.println(c);
	}
}





