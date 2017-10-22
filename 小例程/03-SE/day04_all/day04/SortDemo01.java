package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 默认自然排序 
 */
public class SortDemo01 {
	public static void main(String[] args) {
		List<String> list = 
			new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Mac");
		//调用默认排序算法
		Collections.sort(list);
		System.out.println(list);
		//sort 方法 在执行期间,自动调用了
		//String 的 compareTo 方法, 根据
		//这个比较方法的结果进行排序
		//compare 比较
		// s1.compareTo(s2)
		//compareTo 如果返回 >0 s1>s2
		//compareTo 如果返回 <0 s1<s2
		//compareTo 如果返回 =0 s1==s2
		int n = "Tom".compareTo("Andy");
		System.out.println(n);
		n = "Jerry".compareTo("Tom");
		System.out.println(n);
		n = "Jerry".compareTo("Jerry");
		System.out.println(n);
	}
}







