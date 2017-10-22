package day04;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 利用get方法性能测试, 了解ArrayList和
 * LinkedList 的结构差别. 
 */
public class GetDemo01 {
	public static void main(String[] args) {
		//创建两个集合
		ArrayList<Integer> list1=
			new ArrayList<Integer>();
		LinkedList<Integer> list2=
			new LinkedList<Integer>();
		//将10万个数据存储到集合中
		for(int i=0; i<100000; i++){
			list1.add(i);
			list2.add(i);
		}
		System.out.println(list1.size());
		System.out.println(list2.size());
		
		//获取集合中第一个元素
		// get(下标位置) 返回 下标位置上的元素 
		Integer n=list1.get(0);//获取0位置元素
		System.out.println(n);//0
		n=list2.get(0);//获取0位置元素
		System.out.println(n);//0
		
		//进行性能比较, 测试ArrayList的读取性能
		//比较ArrayList 在头部, 中部和尾部的
		// 读取性能: 0  50000 99999
		long t1 = System.nanoTime();
		n = list1.get(0);//读取头部
		long t2 = System.nanoTime();
		n = list1.get(50000);//读取中部
		long t3 = System.nanoTime();
		n = list1.get(99999);//尾部
		long t4 = System.nanoTime();
		//输出性能测试结果
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		System.out.println(t4-t3);
		
		//测试LinkedList数据结构的读取性能:
		t1 = System.nanoTime();
		n = list2.get(0);//读取头部
		t2 = System.nanoTime();
		n = list2.get(50000);//读取中部
		t3 = System.nanoTime();
		n = list2.get(99999);//尾部
		t4 = System.nanoTime();
		//输出测试结果
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		System.out.println(t4-t3);
	
		
	}
}







