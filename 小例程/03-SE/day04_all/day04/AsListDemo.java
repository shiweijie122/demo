package day04;

import java.util.Arrays;
import java.util.List;

/**
 * asList Demo
 */
public class AsListDemo {
	public static void main(String[] args) {
		String[] ary = 
			{"Tom", "Jerry", "Andy"};
		//asList转换的结果是一个长度不可变的
		//list集合, 于数组共享存储空间
		List<String> list = 
				Arrays.asList(ary);
		System.out.println(list);
		list.set(1, "熊大");
		//输出数组内容
		System.out.println(
				Arrays.toString(ary));
	}
}



