package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历 
 */
public class IteratorDemo01 {
	public static void main(String[] args) {
		Collection c = new ArrayList(); 
		c.add("Tom");
		c.add("Jerry");
		c.add("熊大");
		c.add("光头强");
		c.add("熊二");
		Iterator ite = c.iterator();
		while(ite.hasNext()){
			Object obj = ite.next();
			System.out.println(obj);
			if(obj.equals("光头强")){
				//从原集合中删除正在遍历的元素
				ite.remove();
			}
		} 
		System.out.println(c); 
		
		
		//Java5 提供了增强For循环, 用来替代
		//传统的 迭代器 循环, 用来遍历集合
		//for(Iterator i=c.iterator();
		//		i.hasNext();){
		//	Object obj=i.next();
		for(Object obj:c){
			System.out.println(obj); 
		}
		//增强For循环不能在遍历期间删除元素
		//如果需要遍历期间删除元素,必须使用
		//传统的迭代器循环来解决
	}
}






