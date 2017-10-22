package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 线性表插入元素和删除元素演示 
 */
public class AddRemoveDemo01 {
	public static void main(String[] args) {
		List<String> list = 
			new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Robin");
		//get获取集合中的元素不删除
		String s = list.get(1);
		System.out.println(s);//Jerry
		//remove删除元素,返回被删除的元素
		String s2 = list.remove(2);
		System.out.println(s2);//Andy
		//插入元素到指定位置, 集合元素向后移动
		System.out.println(list);
		list.add(1, "熊大");
		System.out.println(list);
	}

}





