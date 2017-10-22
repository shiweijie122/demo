package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * set 方法的演示 
 */
public class SetDemo01 {
	public static void main(String[] args) {
		//创建集合
		List<String> list = 
			new ArrayList<String>();
		//添加元素
		list.add("Andy");
		list.add("Jerry");
		list.add("Tom");
		list.add("Robin");
		//利用set方法替换元素
		String s = list.set(2, "熊大");
		System.out.println(s);
		System.out.println(list);
		
 		//利用get和set配合交换两个元素位置
		list.set(2,list.set(0,list.get(2)));
		//检查交换结果
		System.out.println(list);
	}
}







